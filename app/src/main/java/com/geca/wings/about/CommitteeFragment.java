package com.geca.wings.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geca.wings.MainActivity;
import com.geca.wings.R;

import java.util.ArrayList;

/**
 * Created by Dell on 1/18/2016.
 */
public class CommitteeFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    int photos[]={R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos,R.drawable.wingslogos};
    String title[]={"Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale","Vikas Desale"};
    String position[]={"Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary","Technical Secretary"};
    String mobile[]={"8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926","8600507926"};
    String gmail[]={"http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com","http://www.google.com/vikas.desaleu@gmail.com"};
    String facebook[]={"http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963","http://www.facebook.com/vikas.desale.963"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_team, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Our Team");
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CommitteeViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CommitteeViewAdapter) mAdapter).setOnItemClickListener(new CommitteeViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<CommitteeData> getDataSet() {
        ArrayList results = new ArrayList<CommitteeData>();
        for (int index = 0; index <10; index++) {
            CommitteeData obj = new CommitteeData(title[index],photos[index],
                    position[index],mobile[index],facebook[index],gmail[index]);
            results.add(index, obj);
        }
        return results;
    }




    @Override
    public void onPause() {
        super.onPause();

    }
}


