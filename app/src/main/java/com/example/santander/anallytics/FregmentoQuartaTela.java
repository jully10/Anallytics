package com.example.santander.anallytics;

/**
 * Created by Santander on 13/09/17.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mayragomes on 15/07/17.
 */

public class FregmentoQuartaTela extends Fragment implements View.OnClickListener{

    View minhaView;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        minhaView = inflater.inflate(R.layout.activity_layout_quarta, container, false);
        btn = (Button) minhaView.findViewById(R.id.button1);
        btn.setOnClickListener(this);

        return minhaView;
        //return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.getActivity(), CanaisActivity.class);
        startActivity(intent);
    }
}