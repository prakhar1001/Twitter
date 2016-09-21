package com.example.team.cleartaxtwitter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.team.cleartaxtwitter.util.ActivityHelper;

/**
 * Created by Prakhar on 21-Sep-16.
 */

public class WelcomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle args = new Bundle();
        args.putString(SearchResultsFragment.ARG_SEARCH_REQUEST, "cleartax");
        fragment.setArguments(args);
        ActivityHelper.navigateTo(getActivity(), fragment, R.id.container_main);
        return rootView;
    }

}
