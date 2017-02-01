package com.geca.wings.events;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.geca.wings.R;
import com.geca.wings.about.Developer;


public class EventDetails extends AppCompatActivity {
    static String theme="";
    static  String rules="";
    static String event="";
    static  String team="";
    static  String title="vikas";
    static String img="";
    static  String contact="";
    static  String contactN="";
    static  String url="";
    android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle=this.getIntent().getExtras();
        if(bundle!=null)
        {
            theme=bundle.getString("theme");
            rules=bundle.getString("rules");
            event=bundle.getString("event");
            team=bundle.getString("team");
            contactN=bundle.getString("contactN");
             title=bundle.getString("title");
            contact=bundle.getString("contact");
            img=bundle.getString("img");
            url=bundle.getString("url");

        }
         int id=getResources().getIdentifier(img,"drawable",getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            toolbar.setBackground(drawable);
        }else{
            toolbar.setBackgroundDrawable(drawable);

        }
        actionBar= getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
        }
        actionBar.setTitle(title);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("THEME"));
        tabLayout.addTab(tabLayout.newTab().setText("RULES"));
        tabLayout.addTab(tabLayout.newTab().setText("EVENT STRUCTURE"));
        tabLayout.addTab(tabLayout.newTab().setText("TEAM & FEE STRUCTURE"));
        tabLayout.addTab(tabLayout.newTab().setText("CONTACT US"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i=new Intent(EventDetails.this,Developer.class);

            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}