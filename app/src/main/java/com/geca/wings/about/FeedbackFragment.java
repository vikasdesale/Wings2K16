package com.geca.wings.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.geca.wings.MainActivity;
import com.geca.wings.R;


public class FeedbackFragment extends Fragment {

    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_feedback, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Your Experience");
        LinearLayout errorLayout = (LinearLayout)v.findViewById(R.id.error);
        LinearLayout contLayout = (LinearLayout)v.findViewById(R.id.content);
        if (!com.geca.wings.NetworkUtil.isNetworkConnected(getActivity())){

            errorLayout.setVisibility(View.VISIBLE);
            contLayout.setVisibility(View.GONE);
        }else {
            webView = (WebView) v.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("http://goo.gl/forms/lKKl8xbKlz");
        }
        return v;
    }


}


