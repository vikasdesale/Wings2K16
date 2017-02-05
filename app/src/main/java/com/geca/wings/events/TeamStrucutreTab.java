package com.geca.wings.events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geca.wings.R;

public class TeamStrucutreTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_fragment_3, container, false);;
        //Bundle bundle=getActivity().getIntent().getExtras();
        // if(bundle!=null)
        //{/
        //    data=bundle.getString("id2");

        //}

        TextView tv=(TextView)v.findViewById(R.id.textView);
        tv.setText(EventDetails.team);
        return v;
    }
}
