package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.dalilegamalek.sample.Activity.FilterActivity;
import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ShareFragment extends Fragment {

    private static final String EXTRA_TEXT = "text";
    AppCompatButton a;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sendfragment, container, false);
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        a=view.findViewById(R.id.btn_login);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), FilterActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
