package com.geca.wings.events;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.geca.wings.R;

import java.util.ArrayList;


public class EventViewActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    int  CodemGamblePhoto[]={R.drawable.codesprint_logo,R.drawable.codejunkie2,R.drawable.cladder1,R.drawable.hitech};
    String CodemGamble[]={"Code Sprint","Code Junkie 2.0","C-Ladder","High-Tech Jatra"};
    int RoboticsPhoto[]={R.drawable.pnp,R.drawable.roborace1,R.drawable.robosoccar};
    String Robotics[]={"Pick & Place","Roborace","Robo-Soccer"};
    int CivilPhoto[]={R.drawable.civil,R.drawable.civil,R.drawable.civil};
    String Civil[]={"Plan Your Smart City","Paper Bridge Making","Thedosurf"};
    int talentaphoto[]={R.drawable.vircampus,R.drawable.hardware1,R.drawable.ee1,R.drawable.pp2,R.drawable.tdlog,R.drawable.hardware1};
    String talenta[]={"Virtual Campus","Thechnothon","Energy Contraption","Paper Presentation","3D Modeling","Hardware Garage"};
    int funzonephoto[]={R.drawable.langame,R.drawable.photologo,R.drawable.cricket,R.drawable.stff};
    String funzone[]={"Lan Gaming","Photography","Box Cricket","Short Flim Fest"};
    int braindrillsphoto[]={R.drawable.tp,R.drawable.google1,R.drawable.murder,R.drawable.tr1,R.drawable.bollyblaster,R.drawable.spell,R.drawable.conqure1,R.drawable.hitech};
    String braindrill[]={"Talent Profile","Googler","Murder Mystery","Treasure Hunt","Bolly Blaster","Spell Your Brain","Conquer","WebQuest 3.0"};
    String a[]={"Codem Gamble","Robotics","Civil-O-Villa","Talent Arena","Fun Zone","Brain Drills"};
    String comp;

//CodemGamble



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar= getSupportActionBar();

        actionbar.setTitle("Events");
        Bundle bundle=this.getIntent().getExtras();
        if(bundle!=null)
        {
            comp=bundle.getString("key");


        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

          if(comp.equals(a[0])){  mAdapter = new EventViewAdapter(getDataSet( CodemGamblePhoto, CodemGamble));}
              else if(comp.equals(a[1])){  mAdapter = new EventViewAdapter(getDataSet( RoboticsPhoto,Robotics));}
                else if(comp.equals(a[2])){  mAdapter = new EventViewAdapter(getDataSet( CivilPhoto,Civil));}
                else if(comp.equals(a[3])){  mAdapter = new EventViewAdapter(getDataSet( talentaphoto, talenta));}
               else if(comp.equals(a[4])){  mAdapter = new EventViewAdapter(getDataSet( funzonephoto, funzone));}
                else if(comp.equals(a[5])){  mAdapter = new EventViewAdapter(getDataSet( braindrillsphoto, braindrill));}

        ((EventViewAdapter) mAdapter).setOnItemClickListener(new EventViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent=new Intent(EventViewActivity.this,EventDetails.class);
                Bundle bundle=new Bundle();
                if(position==0&&comp.equals(a[0])){

                    bundle.putString("img",CodingGamble.CodeSprint[0]);
                    bundle.putString("title",CodingGamble.CodeSprint[1]);
                    bundle.putString("theme",CodingGamble.CodeSprint[2]);
                    bundle.putString("rules",CodingGamble.CodeSprint[3]);
                    bundle.putString("event",CodingGamble.CodeSprint[4]);
                    bundle.putString("team",CodingGamble.CodeSprint[5]);
                    bundle.putString("contact",CodingGamble.CodeSprint[6]);
                    bundle.putString("contactN",CodingGamble.CodeSprint[7]);
                    bundle.putString("url",CodingGamble.CodeSprint[8]);
                 //   Toast.makeText(getApplicationContext(),"Codem Gambel"+position,Toast.LENGTH_SHORT).show();

                }else if(position==1&&comp.equals(a[0])){
                    bundle.putString("img",CodingGamble.CodeJunki[0]);
                    bundle.putString("title",CodingGamble.CodeJunki[1]);
                    bundle.putString("theme",CodingGamble.CodeJunki[2]);
                    bundle.putString("rules",CodingGamble.CodeJunki[3]);
                    bundle.putString("event",CodingGamble.CodeJunki[4]);
                    bundle.putString("team",CodingGamble.CodeJunki[5]);
                    bundle.putString("contact",CodingGamble.CodeJunki[6]);
                    bundle.putString("contactN",CodingGamble.CodeJunki[7]);
                    bundle.putString("url", CodingGamble.CodeJunki[8]);
                   // Toast.makeText(getApplicationContext(),"Codem Gambel"+position,Toast.LENGTH_SHORT).show();

                }else if(position==2&&comp.equals(a[0])){
                    bundle.putString("img",CodingGamble.cLadder[0]);
                    bundle.putString("title",CodingGamble.cLadder[1]);
                    bundle.putString("theme",CodingGamble.cLadder[2]);
                    bundle.putString("rules",CodingGamble.cLadder[3]);
                    bundle.putString("event",CodingGamble.cLadder[4]);
                    bundle.putString("team",CodingGamble.cLadder[5]);
                    bundle.putString("contact",CodingGamble.cLadder[6]);
                    bundle.putString("contactN",CodingGamble.cLadder[7]);
                    bundle.putString("url", CodingGamble.cLadder[8]);
  //                  Toast.makeText(getApplicationContext(),"Codem Gambel"+position,Toast.LENGTH_SHORT).show();

                }else if(position==3&&comp.equals(a[0])){
                    bundle.putString("img",CodingGamble.highTech[0]);
                    bundle.putString("title",CodingGamble.highTech[1]);
                    bundle.putString("theme",CodingGamble.highTech[2]);
                    bundle.putString("rules",CodingGamble.highTech[3]);
                    bundle.putString("event",CodingGamble.highTech[4]);
                    bundle.putString("team",CodingGamble.highTech[5]);
                    bundle.putString("contact",CodingGamble.highTech[6]);
                    bundle.putString("contactN",CodingGamble.highTech[7]);
                    bundle.putString("url", CodingGamble.highTech[8]);


                   // Toast.makeText(getApplicationContext(),"Codem Gambel"+position,Toast.LENGTH_SHORT).show();

                }
                if(position==0&&comp.equals(a[1])){
                    bundle.putString("img",CodingGamble.pickaplace[0]);
                    bundle.putString("title",CodingGamble.pickaplace[1]);
                    bundle.putString("theme",CodingGamble.pickaplace[2]);
                    bundle.putString("rules",CodingGamble.pickaplace[3]);
                    bundle.putString("event",CodingGamble.pickaplace[4]);
                    bundle.putString("team",CodingGamble.pickaplace[5]);
                    bundle.putString("contact",CodingGamble.pickaplace[6]);
                    bundle.putString("contactN",CodingGamble.pickaplace[7]);
                    bundle.putString("url", CodingGamble.pickaplace[8]);
                }else if(position==1&&comp.equals(a[1])){
                    bundle.putString("img",CodingGamble.roborace[0]);
                    bundle.putString("title",CodingGamble.roborace[1]);
                    bundle.putString("theme",CodingGamble.roborace[2]);
                    bundle.putString("rules",CodingGamble.roborace[3]);
                    bundle.putString("event",CodingGamble.roborace[4]);
                    bundle.putString("team",CodingGamble.roborace[5]);
                    bundle.putString("contact",CodingGamble.roborace[6]);
                    bundle.putString("contactN",CodingGamble.roborace[7]);
                    bundle.putString("url", CodingGamble.roborace[8]);

                }else if(position==2&&comp.equals(a[1])){
                    bundle.putString("img",CodingGamble.robosoccker[0]);
                    bundle.putString("title",CodingGamble.robosoccker[1]);
                    bundle.putString("theme",CodingGamble.robosoccker[2]);
                    bundle.putString("rules",CodingGamble.robosoccker[3]);
                    bundle.putString("event",CodingGamble.robosoccker[4]);
                    bundle.putString("team",CodingGamble.robosoccker[5]);
                    bundle.putString("contact",CodingGamble.robosoccker[6]);
                    bundle.putString("contactN",CodingGamble.robosoccker[7]);
                    bundle.putString("url", CodingGamble.robosoccker[8]);
                   // Toast.makeText(getApplicationContext(),"Robotics"+position,Toast.LENGTH_SHORT).show();

                }

                if(position==0&&comp.equals(a[2])){
                    bundle.putString("img",CodingGamble.plant[0]);
                    bundle.putString("title",CodingGamble.plant[1]);
                    bundle.putString("theme",CodingGamble.plant[2]);
                    bundle.putString("rules",CodingGamble.plant[3]);
                    bundle.putString("event",CodingGamble.plant[4]);
                    bundle.putString("team",CodingGamble.plant[5]);
                    bundle.putString("contact",CodingGamble.plant[6]);
                    bundle.putString("contactN",CodingGamble.plant[7]);
                    bundle.putString("url", CodingGamble.plant[8]);
                    //Toast.makeText(getApplicationContext(),"Civil-O-Villa"+position,Toast.LENGTH_SHORT).show();

                }else if(position==1&&comp.equals(a[2])){
                    bundle.putString("img",CodingGamble.paperbridgem[0]);
                    bundle.putString("title",CodingGamble.paperbridgem[1]);
                    bundle.putString("theme",CodingGamble.paperbridgem[2]);
                    bundle.putString("rules",CodingGamble.paperbridgem[3]);
                    bundle.putString("event",CodingGamble.paperbridgem[4]);
                    bundle.putString("team",CodingGamble.paperbridgem[5]);
                    bundle.putString("contact",CodingGamble.paperbridgem[6]);
                    bundle.putString("contactN",CodingGamble.paperbridgem[7]);
                    bundle.putString("url", CodingGamble.paperbridgem[8]);
 //                   Toast.makeText(getApplicationContext(),"Civil-O-Villa"+position,Toast.LENGTH_SHORT).show();

                }else if(position==2&&comp.equals(a[2])){
   //                 Toast.makeText(getApplicationContext(),"Civil-O-Villa"+position,Toast.LENGTH_SHORT).show();
                    bundle.putString("img",CodingGamble.tedo[0]);
                    bundle.putString("title",CodingGamble.tedo[1]);
                    bundle.putString("theme",CodingGamble.tedo[2]);
                    bundle.putString("rules",CodingGamble.tedo[3]);
                    bundle.putString("event",CodingGamble.tedo[4]);
                    bundle.putString("team",CodingGamble.tedo[5]);
                    bundle.putString("contact",CodingGamble.tedo[6]);
                    bundle.putString("contactN",CodingGamble.tedo[7]);
                    bundle.putString("url", CodingGamble.tedo[8]);
                }

                if(position==0&&comp.equals(a[3])){
                    bundle.putString("img",CodingGamble.virCampus[0]);
                    bundle.putString("title",CodingGamble.virCampus[1]);
                    bundle.putString("theme",CodingGamble.virCampus[2]);
                    bundle.putString("rules",CodingGamble.virCampus[3]);
                    bundle.putString("event",CodingGamble.virCampus[4]);
                    bundle.putString("team",CodingGamble.virCampus[5]);
                    bundle.putString("contact",CodingGamble.virCampus[6]);
                    bundle.putString("contactN",CodingGamble.virCampus[7]);
                    bundle.putString("url", CodingGamble.virCampus[8]);
                   // Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();

                }else if(position==1&&comp.equals(a[3])){
                    bundle.putString("img",CodingGamble.encrypto[0]);
                    bundle.putString("title",CodingGamble.encrypto[1]);
                    bundle.putString("theme",CodingGamble.encrypto[2]);
                    bundle.putString("rules",CodingGamble.encrypto[3]);
                    bundle.putString("event",CodingGamble.encrypto[4]);
                    bundle.putString("team",CodingGamble.encrypto[5]);
                    bundle.putString("contact",CodingGamble.encrypto[6]);
                    bundle.putString("contactN",CodingGamble.encrypto[7]);
                    bundle.putString("url", CodingGamble.encrypto[8]);
                    //Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();

                }else if(position==2&&comp.equals(a[3])){

                    bundle.putString("img",CodingGamble.energyCo[0]);
                    bundle.putString("title",CodingGamble.energyCo[1]);
                    bundle.putString("theme",CodingGamble.energyCo[2]);
                    bundle.putString("rules",CodingGamble.energyCo[3]);
                    bundle.putString("event",CodingGamble.energyCo[4]);
                    bundle.putString("team",CodingGamble.energyCo[5]);
                    bundle.putString("contact",CodingGamble.energyCo[6]);
                    bundle.putString("contactN",CodingGamble.energyCo[7]);
                    bundle.putString("url", CodingGamble.energyCo[8]);
                    //Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();

                }else if(position==3&&comp.equals(a[3])){
                    bundle.putString("img",CodingGamble.paperPre[0]);
                    bundle.putString("title",CodingGamble.paperPre[1]);
                    bundle.putString("theme",CodingGamble.paperPre[2]);
                    bundle.putString("rules",CodingGamble.paperPre[3]);
                    bundle.putString("event",CodingGamble.paperPre[4]);
                    bundle.putString("team",CodingGamble.paperPre[5]);
                    bundle.putString("contact",CodingGamble.paperPre[6]);
                    bundle.putString("contactN",CodingGamble.paperPre[7]);
                    bundle.putString("url", CodingGamble.paperPre[8]);
//                    Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();

                }else if(position==4&&comp.equals(a[3])){
  //                  Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();
                    bundle.putString("img",CodingGamble.tdmodel[0]);
                    bundle.putString("title",CodingGamble.tdmodel[1]);
                    bundle.putString("theme",CodingGamble.tdmodel[2]);
                    bundle.putString("rules",CodingGamble.tdmodel[3]);
                    bundle.putString("event",CodingGamble.tdmodel[4]);
                    bundle.putString("team",CodingGamble.tdmodel[5]);
                    bundle.putString("contact",CodingGamble.tdmodel[6]);
                    bundle.putString("contactN",CodingGamble.tdmodel[7]);
                    bundle.putString("url", CodingGamble.tdmodel[8]);
                }else if(position==5&&comp.equals(a[3])){
                //                  Toast.makeText(getApplicationContext(),"Talent Arena"+position,Toast.LENGTH_SHORT).show();
                bundle.putString("img",CodingGamble.hg[0]);
                bundle.putString("title",CodingGamble.hg[1]);
                bundle.putString("theme",CodingGamble.hg[2]);
                bundle.putString("rules",CodingGamble.hg[3]);
                bundle.putString("event",CodingGamble.hg[4]);
                bundle.putString("team",CodingGamble.hg[5]);
                bundle.putString("contact",CodingGamble.hg[6]);
                bundle.putString("contactN",CodingGamble.hg[7]);
                bundle.putString("url", CodingGamble.hg[8]);
            }
                if(position==0&&comp.equals(a[4])){
                    bundle.putString("img",CodingGamble.langaming[0]);
                    bundle.putString("title",CodingGamble.langaming[1]);
                    bundle.putString("theme",CodingGamble.langaming[2]);
                    bundle.putString("rules",CodingGamble.langaming[3]);
                    bundle.putString("event",CodingGamble.langaming[4]);
                    bundle.putString("team",CodingGamble.langaming[5]);
                    bundle.putString("contact",CodingGamble.langaming[6]);
                    bundle.putString("contactN",CodingGamble.langaming[7]);
                    bundle.putString("url", CodingGamble.langaming[8]);
                   // Toast.makeText(getApplicationContext(),"Fun Zone"+position,Toast.LENGTH_SHORT).show();

                }else if(position==1&&comp.equals(a[4])){
                    bundle.putString("img",CodingGamble.photography[0]);
                    bundle.putString("title",CodingGamble.photography[1]);
                    bundle.putString("theme",CodingGamble.photography[2]);
                    bundle.putString("rules",CodingGamble.photography[3]);
                    bundle.putString("event",CodingGamble.photography[4]);
                    bundle.putString("team",CodingGamble.photography[5]);
                    bundle.putString("contact",CodingGamble.photography[6]);
                    bundle.putString("contactN",CodingGamble.photography[7]);
                    bundle.putString("url", CodingGamble.photography[8]);

                   // Toast.makeText(getApplicationContext(),"Fun Zone"+position,Toast.LENGTH_SHORT).show();

                }else if(position==2&&comp.equals(a[4])){
                    bundle.putString("img",CodingGamble.boxcricket[0]);
                    bundle.putString("title",CodingGamble.boxcricket[1]);
                    bundle.putString("theme",CodingGamble.boxcricket[2]);
                    bundle.putString("rules",CodingGamble.boxcricket[3]);
                    bundle.putString("event",CodingGamble.boxcricket[4]);
                    bundle.putString("team",CodingGamble.boxcricket[5]);
                    bundle.putString("contact",CodingGamble.boxcricket[6]);
                    bundle.putString("contactN",CodingGamble.boxcricket[7]);
                    bundle.putString("url", CodingGamble.boxcricket[8]);

                   // Toast.makeText(getApplicationContext(),"Fun Zone"+position,Toast.LENGTH_SHORT).show();

                }else if(position==3&&comp.equals(a[4])){
                    bundle.putString("img",CodingGamble.shortflim[0]);
                    bundle.putString("title",CodingGamble.shortflim[1]);
                    bundle.putString("theme",CodingGamble.shortflim[2]);
                    bundle.putString("rules",CodingGamble.shortflim[3]);
                    bundle.putString("event",CodingGamble.shortflim[4]);
                    bundle.putString("team",CodingGamble.shortflim[5]);
                    bundle.putString("contact",CodingGamble.shortflim[6]);
                    bundle.putString("contactN",CodingGamble.shortflim[7]);
                    bundle.putString("url", CodingGamble.shortflim[8]);

                    //  Toast.makeText(getApplicationContext(),"Fun Zone"+position,Toast.LENGTH_SHORT).show();

                }
                if(position==0&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.talentProfile[0]);
                    bundle.putString("title",CodingGamble.talentProfile[1]);
                    bundle.putString("theme",CodingGamble.talentProfile[2]);
                    bundle.putString("rules",CodingGamble.talentProfile[3]);
                    bundle.putString("event",CodingGamble.talentProfile[4]);
                    bundle.putString("team",CodingGamble.talentProfile[5]);
                    bundle.putString("contact",CodingGamble.talentProfile[6]);
                    bundle.putString("contactN",CodingGamble.talentProfile[7]);
                    bundle.putString("url", CodingGamble.talentProfile[8]);

//                    Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==1&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.googler[0]);
                    bundle.putString("title",CodingGamble.googler[1]);
                    bundle.putString("theme",CodingGamble.googler[2]);
                    bundle.putString("rules",CodingGamble.googler[3]);
                    bundle.putString("event",CodingGamble.googler[4]);
                    bundle.putString("team",CodingGamble.googler[5]);
                    bundle.putString("contact",CodingGamble.googler[6]);
                    bundle.putString("contactN",CodingGamble.googler[7]);
                    bundle.putString("url", CodingGamble.googler[8]);

                  //  Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==2&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.murderMystery[0]);
                    bundle.putString("title",CodingGamble.murderMystery[1]);
                    bundle.putString("theme",CodingGamble.murderMystery[2]);
                    bundle.putString("rules",CodingGamble.murderMystery[3]);
                    bundle.putString("event",CodingGamble.murderMystery[4]);
                    bundle.putString("team",CodingGamble.murderMystery[5]);
                    bundle.putString("contact",CodingGamble.murderMystery[6]);
                    bundle.putString("contactN",CodingGamble.murderMystery[7]);
                    bundle.putString("url", CodingGamble.murderMystery[8]);

                 //   Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==3&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.treasureHunt[0]);
                    bundle.putString("title",CodingGamble.treasureHunt[1]);
                    bundle.putString("theme",CodingGamble.treasureHunt[2]);
                    bundle.putString("rules",CodingGamble.treasureHunt[3]);
                    bundle.putString("event",CodingGamble.treasureHunt[4]);
                    bundle.putString("team",CodingGamble.treasureHunt[5]);
                    bundle.putString("contact",CodingGamble.treasureHunt[6]);
                    bundle.putString("contactN",CodingGamble.treasureHunt[7]);
                    bundle.putString("url", CodingGamble.treasureHunt[8]);

//                    Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==4&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.bollyblaster[0]);
                    bundle.putString("title",CodingGamble.bollyblaster[1]);
                    bundle.putString("theme",CodingGamble.bollyblaster[2]);
                    bundle.putString("rules",CodingGamble.bollyblaster[3]);
                    bundle.putString("event",CodingGamble.bollyblaster[4]);
                    bundle.putString("team",CodingGamble.bollyblaster[5]);
                    bundle.putString("contact",CodingGamble.bollyblaster[6]);
                    bundle.putString("contactN",CodingGamble.bollyblaster[7]);
                    bundle.putString("url", CodingGamble.bollyblaster[8]);

                    // Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==5&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.spellubrain[0]);
                    bundle.putString("title",CodingGamble.spellubrain[1]);
                    bundle.putString("theme",CodingGamble.spellubrain[2]);
                    bundle.putString("rules",CodingGamble.spellubrain[3]);
                    bundle.putString("event",CodingGamble.spellubrain[4]);
                    bundle.putString("team",CodingGamble.spellubrain[5]);
                    bundle.putString("contact",CodingGamble.spellubrain[6]);
                    bundle.putString("contactN",CodingGamble.spellubrain[7]);
                    bundle.putString("url", CodingGamble.spellubrain[8]);

                    //Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==6&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.conquer[0]);
                    bundle.putString("title",CodingGamble.conquer[1]);
                    bundle.putString("theme",CodingGamble.conquer[2]);
                    bundle.putString("rules",CodingGamble.conquer[3]);
                    bundle.putString("event",CodingGamble.conquer[4]);
                    bundle.putString("team",CodingGamble.conquer[5]);
                    bundle.putString("contact",CodingGamble.conquer[6]);
                    bundle.putString("contactN",CodingGamble.conquer[7]);
                    bundle.putString("url", CodingGamble.conquer[8]);

                    // Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }else if(position==7&&comp.equals(a[5])){
                    bundle.putString("img",CodingGamble.webq[0]);
                    bundle.putString("title",CodingGamble.webq[1]);
                    bundle.putString("theme",CodingGamble.webq[2]);
                    bundle.putString("rules",CodingGamble.webq[3]);
                    bundle.putString("event",CodingGamble.webq[4]);
                    bundle.putString("team",CodingGamble.webq[5]);
                    bundle.putString("contact",CodingGamble.webq[6]);
                    bundle.putString("contactN",CodingGamble.webq[7]);
                    bundle.putString("url", CodingGamble.webq[8]);

                    // Toast.makeText(getApplicationContext(),"Brain Drills"+position,Toast.LENGTH_SHORT).show();

                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

            mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private ArrayList<EventData> getDataSet(int photo[],String title1[]) {
        ArrayList results = new ArrayList<EventData>();
        for (int index = 0; index <photo.length; index++) {
            EventData obj = new EventData(title1[index],photo[index]
                    );
            results.add(index, obj);
        }
        return results;
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
            overridePendingTransition(R.drawable.from_middle, R.drawable.to_middle);

        }
        return super.onOptionsItemSelected(item);
    }


}