package com.geca.wings.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.geca.wings.MainActivity;
import com.geca.wings.R;

/**
 * Created by naman on 16/12/14.
 */
public class EventFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    KenBurnsView imageView;
    Button newsfeed, events, about, gallery, sponsors, contactus;
    private boolean isInFront;
   String a[]={"Robotics","Brain Drills","Fun Zone","Codem Gamble","Talent Arena","Civil-O-Villa"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_event, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Events");

        GridView gridView = (GridView)v.findViewById(R.id.gridview);

        gridView.setAdapter(new MyAdapter(getActivity()));
        gridView.setOnItemClickListener(this);
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        isInFront = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isInFront = false;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(),EventViewActivity.class);
        Bundle bundle=new Bundle();
        switch(position){
            case 0:bundle.putString("key",a[0]);
                break;
            case 1: bundle.putString("key",a[1]);
                break;
            case 2: bundle.putString("key",a[2]);
                break;
            case 3:bundle.putString("key",a[3]);
                break;
            case 4: bundle.putString("key",a[4]);
                break;
            case 5:bundle.putString("key",a[5]);
                break;
            default:break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }
}


