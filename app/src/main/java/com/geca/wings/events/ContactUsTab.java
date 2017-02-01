package com.geca.wings.events;

/**
 * Created by shailendra on 24-02-2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geca.wings.R;

public class ContactUsTab extends Fragment implements View.OnClickListener {
    String no;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.contact_tab, container, false);;
        //Bundle bundle=getActivity().getIntent().getExtras();
        // if(bundle!=null)
        //{/
        //    data=bundle.getString("id2");

        //}

        TextView tv=(TextView)v.findViewById(R.id.textView);
        TextView tv2=(TextView)v.findViewById(R.id.textView1);
        tv2.setOnClickListener(this);
        tv.setText(EventDetails.contactN);
        tv2.setText(EventDetails.contact);
          no= (String) tv2.getText();

        return v;
    }

    @Override
    public void onClick(View v) {
        Intent sIntent = new Intent(Intent.ACTION_CALL, Uri


                .parse("tel:"+no));


        sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



        startActivity(sIntent);
    }
}
