package com.geca.wings.about;

/**
 * Created by Dell on 1/10/2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.geca.wings.R;


public class Developer extends AppCompatActivity implements View.OnClickListener {
    ImageView fb,linkedin,youtube,google,whatsapp;
    ImageView fbe,webe,sharee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar= getSupportActionBar();

        actionbar.setTitle("Developed By");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fb=(ImageView)findViewById(R.id.fb);
        linkedin=(ImageView)findViewById(R.id.ln);
        whatsapp=(ImageView)findViewById(R.id.wt);
        youtube=(ImageView)findViewById(R.id.gp);
        google=(ImageView)findViewById(R.id.youtube);
        fb.setOnClickListener(this);
        linkedin.setOnClickListener(this);
        whatsapp.setOnClickListener(this);
        youtube.setOnClickListener(this);
        google.setOnClickListener(this);
      fbe= (ImageView) findViewById(R.id.facebook);
        sharee= (ImageView) findViewById(R.id.share);

        webe= (ImageView) findViewById(R.id.web);
        fbe.setOnClickListener(this);
        sharee.setOnClickListener(this);
        webe.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fb:Uri uri6 = Uri.parse("https://www.facebook.com/vikas.desale.963"); // missing 'http://' will cause crashed
                Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);
                startActivity(intent6);
                break;
            case R.id.wt:
                break;
            case R.id.youtube:Uri uri1 = Uri.parse("https://plus.google.com/101910787809465436804/posts/p/pub"); // missing 'http://' will cause crashed
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);

                startActivity(intent1);
                break;
            case R.id.gp:Uri uri2 = Uri.parse("https://www.youtube.com/channel/UC6-f1uwcuwU-2j1T_HMb75Q"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);break;
            case R.id.ln:
            Uri uri7 = Uri.parse("https://www.linkedin.com/in/vikas-desale-01756774");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri7);
            startActivity(intent);break;

            case R.id.facebook:
                Uri uri9 = Uri.parse("https://www.facebook.com/gecawings"); // missing 'http://' will cause crashed
                Intent intent7 = new Intent(Intent.ACTION_VIEW, uri9);
                startActivity(intent7);
          break;
            case R.id.web:
                Uri uri10 = Uri.parse("https://www.wings2016.in"); // missing 'http://' will cause crashed
                Intent intent10 = new Intent(Intent.ACTION_VIEW, uri10);
                startActivity(intent10);
                break;

            case R.id.share:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Wings");
                String sAux = "\nGet the official wings app for latest updates and information about Wings 2016\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.geca.wings \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Choose one"));

        }
    }
}
