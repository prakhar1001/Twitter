package com.example.team.cleartaxtwitter;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.team.cleartaxtwitter.api.TweetList;
import com.example.team.cleartaxtwitter.event.SearchTweetsEvent;
import com.example.team.cleartaxtwitter.event.SearchTweetsEventFailed;
import com.example.team.cleartaxtwitter.event.SearchTweetsEventOK;
import com.example.team.cleartaxtwitter.event.TwitterGetTokenEvent;
import com.example.team.cleartaxtwitter.event.TwitterGetTokenEventFailed;
import com.example.team.cleartaxtwitter.event.TwitterGetTokenEventOK;
import com.example.team.cleartaxtwitter.util.ActivityHelper;
import com.example.team.cleartaxtwitter.util.BusProvider;
import com.example.team.cleartaxtwitter.util.PrefsController;
import com.example.team.cleartaxtwitter.util.TweetAdapter;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import static com.example.team.cleartaxtwitter.util.Util.makeToast;

/**
 * Created by Prakhar on 21-Sep-16.
 */

public class SearchResultsFragment extends ListFragment {

    private static final String TAG = SearchResultsFragment.class.getName();
    private Bus mBus;
    private String request;
    public static ProgressBar loader;
    TweetList list = new TweetList();
    private TweetAdapter brandAdapter;

    private TextView textResult;

    public static final String ARG_SEARCH_REQUEST = "request";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_tweets, container, false);
        loader = (ProgressBar) rootView.findViewById(R.id.loader);
        brandAdapter = new TweetAdapter(getActivity(), list);
        setListAdapter(brandAdapter);
        request = getArguments().getString(ARG_SEARCH_REQUEST);
        return rootView;
    }

    public void setTweetList(TweetList tweetList) {
        list = tweetList;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Do your stuff..
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), TweetAnalytics.class);
        intent.putExtra("TweetMessage", list.tweets.get(position).text);
        startActivity(intent);

    }

    @Override
    public void onStart() {
        super.onStart();
        getBus().register(this);
        if (TextUtils.isEmpty(PrefsController.getAccessToken(getActivity()))) {
            getBus().post(new TwitterGetTokenEvent());
        } else {
            String token = PrefsController.getAccessToken(getActivity());
            getBus().post(new SearchTweetsEvent(token, request));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        getBus().unregister(this);
    }

    @Subscribe
    public void onTwitterGetTokenOk(TwitterGetTokenEventOK event) {
        getBus().post(new SearchTweetsEvent(PrefsController.getAccessToken(getActivity()), request));
    }

    @Subscribe
    public void onTwitterGetTokenFailed(TwitterGetTokenEventFailed event) {
        makeToast(getActivity(), "Failed to get token");
    }

    @Subscribe
    public void onSearchTweetsEventOk(final SearchTweetsEventOK event) {
        setTweetList(event.tweetsList);
        brandAdapter.setTweetList(event.tweetsList);
        brandAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onSearchTweetsEventFailed(SearchTweetsEventFailed event) {
        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle args = new Bundle();
        args.putString(SearchResultsFragment.ARG_SEARCH_REQUEST, "cleartax");
        fragment.setArguments(args);
        ActivityHelper.navigateTo(getActivity(), fragment, R.id.container_main);
        makeToast(getActivity(), "Search of tweets failed");
    }


    // TODO migrate to DI
    private Bus getBus() {
        if (mBus == null) {
            mBus = BusProvider.getInstance();
        }
        return mBus;
    }

    public void setBus(Bus bus) {
        mBus = bus;
    }

}
