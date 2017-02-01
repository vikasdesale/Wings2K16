package com.geca.wings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.geca.wings.about.AboutGECAFragment;
import com.geca.wings.about.CommitteeFragment;
import com.geca.wings.about.FeedbackFragment;
import com.geca.wings.about.KeyAttraction;
import com.geca.wings.adpaters.PagerAdapter;
import com.geca.wings.events.EventFragment;
import com.geca.wings.fragments.HomeFragment;
import com.geca.wings.fragments.MapFragment;
import com.geca.wings.fragments.NavigationDrawerFragment;
import com.geca.wings.gallery.GalleryActivity;
import com.geca.wings.sponsors.SponsorsFragment;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment fragment;
    NavigationDrawerFragment mDrawerFragment;
    private String actionBarTitle="vikas";
    ActionBar actionBar;
    ViewPager pager;
    FrameLayout f;
    /** maintains the pager adapter*/
    private PagerAdapter mPagerAdapter;
    private static String windowsSize;

    public  int[] getWindowsSize() {

        DisplayMetrics displayMetrics=new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;
        int aheight=toolbar.getHeight();
        int windowsSize[]=new int[]{width, height, aheight};
        return windowsSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager)findViewById(R.id.frame_container1);
       f=(FrameLayout)findViewById(R.id.frame_container);

        setSupportActionBar(toolbar);
        actionBar= getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
        }
        actionBar.setTitle("Wings 2016");

        disp(0);
        //initialsie the pager
        this.initialisePaging();

        //setupJob();
        setupDrawer();

    }
    private void setupDrawer() {
       mDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
    }
    public void onDrawerItemClicked(int index) {
     disp(index);


    }

public void disp(int index){
    if(index==0){
        index=0;
    }
    fragment = null;
    switch (index) {
        case 0:
            pager.setVisibility(View.VISIBLE);
            initialisePaging();
            break;

        case 1:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment=new KeyAttraction();
               break;
        case 2:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment=new EventFragment();
            break;

        case 3:

             Intent i=new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(i);
            pager.setVisibility(View.VISIBLE);
            break;
        case 4:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment = new MapFragment();break;
        case 5:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment = new FeedbackFragment();
            break;

        case 6:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment = new CommitteeFragment();
           // Intent openMain= new Intent(MainActivity.this,Committee.class);

            //startActivity(openMain);

            break;

        case 7:
            pager.setVisibility(View.GONE);
            f.setVisibility(View.VISIBLE);
            fragment = new SponsorsFragment();
            break;
        default:
            break;
    }

    if (fragment != null) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();




    } else {
        initialisePaging();
    }

} /**
     * Initialise the fragments to be paged
     */
    private void initialisePaging() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, HomeFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, AboutGECAFragment.class.getName()));
        //fragments.add(Fragment.instantiate(this, Tab3Fragment.class.getName()));
        this.mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        f.setVisibility(View.GONE);
        ViewPager pager = (ViewPager)super.findViewById(R.id.frame_container1);
        pager.setAdapter(this.mPagerAdapter);
    }



    public void onDrawerSlide(float slideOffset) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent openMain1 = new Intent(MainActivity.this, com.geca.wings.about.Developer.class);

            startActivity(openMain1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setActionBarTitle(String actionBarTitle) {
        this.actionBarTitle = actionBarTitle;
        actionBar.setTitle(actionBarTitle);
        getSupportActionBar().setHomeButtonEnabled(true);


    }
}
