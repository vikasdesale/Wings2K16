package com.geca.wings.events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geca.wings.R;

public class EventStruFragmentTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_fragment_3, container, false);;
     
        TextView tv=(TextView)v.findViewById(R.id.textView);
       tv.setText(EventDetails.event);
        return v;
    }
}
