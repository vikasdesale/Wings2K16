package com.geca.wings.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geca.wings.MainActivity;
import com.geca.wings.R;


public class HomeFragment extends Fragment implements View.OnClickListener {


    String aboutWings="\n\nGovernment College Of Engineering presents you 'WINGS' the fest of zeal enthusiasm,entertainment,knowledge,talent,creativity,innovation,sportmanship and wisdom.\n\nWINGS had its journey since 2007.\nYour Perseverance,dedication,determination and innovation all together will lead to Wings 2016. ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_home, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("About GECA");

         TextView t= (TextView)v.findViewById(R.id.aboutWings1);
        t.setMovementMethod(new ScrollingMovementMethod());
        t.setText(aboutWings);
        ImageView v1=(ImageView)v.findViewById(R.id.imageView);
        v1.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
       // Fragment f=new EventFragment();
        //FragmentTransaction fg=getFragmentManager().beginTransaction();
        //fg.replace(R.id.fragment_event,)
    }
}


