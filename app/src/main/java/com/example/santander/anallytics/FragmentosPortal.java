package com.example.santander.anallytics;

/**
 * Created by Santander on 13/09/17.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;




public class FragmentosPortal extends Fragment {
    View minhaView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        minhaView = inflater.inflate(R.layout.activity_layout_segunda, container, false);
        return minhaView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

}
