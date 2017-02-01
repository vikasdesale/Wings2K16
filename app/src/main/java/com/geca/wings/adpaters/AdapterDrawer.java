package com.geca.wings.adpaters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geca.wings.R;
import com.geca.wings.info.Information;

import java.util.Collections;
import java.util.List;


/**
 * Created by Windows on 22-12-2014.
 */
public class AdapterDrawer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Information> data= Collections.emptyList();
    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;
    private LayoutInflater inflater;
    private Context context;
    Bitmap bitmap;
    String userImageUrl;
    String textName;
    String emailid;
    Bitmap map = null;
    private boolean isInFront;

    HeaderHolder headerHolder;
    public AdapterDrawer(Context context, List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;


    }


    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEADER){
            View view=inflater.inflate(R.layout.drawer_header, parent,false);
            HeaderHolder holder=new HeaderHolder(view);
            return holder;
        }
        else{
            View view=inflater.inflate(R.layout.item_drawer, parent,false);
            ItemHolder holder=new ItemHolder(view);
            return holder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }
        else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder ){

              final HeaderHolder headerHolder=(HeaderHolder) holder;

              // headerHolder.emailid.setText("Welcome in Wings 2016");
           //    headerHolder.profile_pic.setImageBitmap(map);
             // headerHolder.username.setText("Wings 2016");
        }
        else{
            ItemHolder itemHolder= (ItemHolder) holder;
            Information current=data.get(position-1);
            itemHolder.title.setText(current.title);
            itemHolder.icon.setImageResource(current.iconId);


        }

    }
    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        public ItemHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
    class HeaderHolder extends RecyclerView.ViewHolder {
         ImageView profile_pic;
        ImageView back;
        TextView emailid,username;

        public HeaderHolder(View itemView) {
            super(itemView);
            back = (ImageView) itemView.findViewById(R.id.header);
            profile_pic = (ImageView) itemView.findViewById(R.id.image_profile);
        }
    }
}
