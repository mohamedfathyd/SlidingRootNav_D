package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ProfileFragment extends Fragment {

    private static final String EXTRA_TEXT = "text";

    public static ProfileFragment createFor(String text) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_profile_page, container, false);
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
