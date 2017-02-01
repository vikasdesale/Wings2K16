package com.geca.wings.about;

/**
 * Created by Dell on 1/18/2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geca.wings.R;
import com.geca.wings.anim.AnimationUtils;

import java.util.ArrayList;

public class CommitteeViewAdapter extends RecyclerView
        .Adapter<CommitteeViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<CommitteeData> mDataset;
    private static MyClickListener myClickListener;
    private CardView cardview;
    Context context;
    private int mPreviousPosition = 0;
    String phone,gmail,facebook;
    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name,pos;

        ImageView pic,phone,gmail,facebook;
        public DataObjectHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            pos = (TextView) itemView.findViewById(R.id.pos);
            pic = (ImageView) itemView.findViewById(R.id.image_profile);
            gmail = (ImageView) itemView.findViewById(R.id.imgGmail);
            facebook = (ImageView) itemView.findViewById(R.id.imgFacebook);
            phone = (ImageView) itemView.findViewById(R.id.imgPhone);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CommitteeViewAdapter(ArrayList<CommitteeData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
       context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.committee_student, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.name.setText(mDataset.get(position).getmText1());
        holder.pos.setText(mDataset.get(position).getPosition());
        phone=mDataset.get(position).getPhone();
        gmail=mDataset.get(position).getGmail();
        facebook=mDataset.get(position).getFacebook();
        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animate1(holder, true);
//            AnimationUtils.animate(holder,true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animate1(holder, false);
//            AnimationUtils.animate(holder, false);
        }
        mPreviousPosition = position;

        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,phone+"",Toast.LENGTH_SHORT).show();

            }
        });
        holder.gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,gmail+"",Toast.LENGTH_SHORT).show();

            }
        });
        holder.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, facebook + "", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void addItem(CommitteeData dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}