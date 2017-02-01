package com.geca.wings.about;

/**
 * Created by Dell on 2/27/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geca.wings.MainActivity;
import com.geca.wings.R;


public class KeyAttraction extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.about_key_attrac, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Key Attraction");


        return v;
    }





    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }




    }




