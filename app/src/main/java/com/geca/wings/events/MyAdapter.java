package com.geca.wings.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geca.wings.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2/25/2016.
 */
public class MyAdapter extends BaseAdapter
{ int width=0;
    int height=0;
    int aheight=0;
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;
    ImageView img;
    public MyAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);

        items.add(new Item("Robotics", R.drawable.pnp));
        items.add(new Item("Brain Drills", R.drawable.tw3));
        items.add(new Item("Fun Zone", R.drawable.funzone));
        items.add(new Item("Codem Gamble", R.drawable.codejunkie2));
        items.add(new Item("Talent Arena", R.drawable.talent));
        items.add(new Item("Civil-O-Villa", R.drawable.civil));
        //DisplayMetrics displayMetrics=new DisplayMetrics();


    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i)
    {
        return items.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null)
        {
            v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
            int p=height-aheight;

            img= (ImageView)v.findViewById(R.id.picture);
            v.setMinimumHeight(p / 2);
            img.setMaxHeight(height / 2);
            v.setTag(R.id.picture,img);
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private class Item
    {
        final String name;
        final int drawableId;

        Item(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}