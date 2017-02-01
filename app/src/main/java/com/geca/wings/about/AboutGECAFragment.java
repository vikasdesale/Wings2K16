package com.geca.wings.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geca.wings.MainActivity;
import com.geca.wings.R;


public class AboutGECAFragment extends Fragment {


    String aboutGECA="The Government College of Engineering, Aurangabad (GECA), is the premier technical institute in Marathwada region of Maharashtra State. It is established in 1960, by the Government of Maharashtra, with the view of catering to Maharashtra state technical expertise requirements. The institution has earned well repute over period of time by its continuous pursuing to qualitative and competitive needs of the technical world. GECA has the distinction of being graded A amongst the colleges located in the state of Maharashtra by the Directorate of Technical Education, Mumbai.\n";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_about, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("About Wings");

         TextView t= (TextView)v.findViewById(R.id.aboutWings2);
        t.setText(aboutGECA);

        return v;
    }

}


