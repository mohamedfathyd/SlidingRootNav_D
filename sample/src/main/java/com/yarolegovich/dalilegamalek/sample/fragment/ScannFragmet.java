package com.yarolegovich.dalilegamalek.sample.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.yarolegovich.dalilegamalek.sample.R;

import me.anwarshahriar.calligrapher.Calligrapher;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ScannFragmet extends Fragment {

    private static final String EXTRA_TEXT = "text";
    ImageView imageView;
    private SharedPreferences sharedpref;

    int id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.scannfragment, container, false);

        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Droid.ttf", true);
        imageView=view.findViewById(R.id.parcode);
        sharedpref= getActivity().getSharedPreferences("ManoAd", Context.MODE_PRIVATE);
        id=sharedpref.getInt("id",0);
        String text = String.valueOf(id);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,900,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
