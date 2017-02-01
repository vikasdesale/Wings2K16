package com.geca.wings.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geca.wings.MainActivity;
import com.geca.wings.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private GoogleMap mMap;
    private int resultCode;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View v = inflater.inflate(R.layout.fragment_maps, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("GECA Is Here");

        resultCode=GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if(resultCode != ConnectionResult.SUCCESS)
        {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), 69);
            dialog.setCancelable(true);

            dialog.show();
        }
        else {
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();


            MarkerOptions markerOptions;
            MarkerOptions markerOptions1;
            MarkerOptions markerOptions2;
            MarkerOptions markerOptions3;
            MarkerOptions markerOptions4;
            MarkerOptions markerOptions5;
            MarkerOptions markerOptions6;

            LatLng position;
            LatLng position1;
            LatLng position2;
            LatLng position3;
            LatLng position4;
            LatLng position5;
            LatLng position6;
            LatLng position7;

            markerOptions = new MarkerOptions();
            markerOptions1 = new MarkerOptions();
            markerOptions2 = new MarkerOptions();
            markerOptions3 = new MarkerOptions();
            markerOptions4 = new MarkerOptions();
            markerOptions5 = new MarkerOptions();
            markerOptions6 = new MarkerOptions();

            if (isGoogleMapsInstalled()) {
                String lat[]={"19.866374","19.867841","19.867371","19.867139","19.868320","19.868252","19.867465" };

                String  lng[]={"75.323650","75.323125","75.323319","75.324467","75.323295","75.324312"," 75.324256"};
                String Title[]={"Government College Of Engineering,Aurangabad","Computer Science Department","Electronics Engineering Department","Information Technology Department","Mechanical Engineering Department","Electrical Engineering Department","Civil Engineering Department"};
                String lati="19.866374";
                String lang="75.323650";
                for(int i=0;i<lat.length;i++) {
                    lati = lat[i];
                    lang = lng[i];
                    position = new LatLng(Double.parseDouble(lati), Double.parseDouble(lang));
                    markerOptions.position(position);
                    markerOptions.title(Title[i]);
                    mMap.addMarker(markerOptions);
                }
                position = new LatLng(Double.parseDouble(lati), Double.parseDouble(lang));

                CameraUpdate cameraPosition = CameraUpdateFactory.newLatLngZoom(position, 18.0f);
                mMap.animateCamera(cameraPosition);
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Please install Google Maps");
                builder.setCancelable(true);
                builder.setPositiveButton("Install", getGoogleMapsListener());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
        return v;
    }


    public boolean isGoogleMapsInstalled()
    {
        try
        {
            ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        }
        catch(PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }
    public DialogInterface.OnClickListener getGoogleMapsListener() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps"));
                startActivity(intent);


            }
        };
    }

}
