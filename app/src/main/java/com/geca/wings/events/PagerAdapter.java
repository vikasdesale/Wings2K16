package com.geca.wings.events;

/**
 * Created by shailendra on 24-02-2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ThemeFragmentTab tab1 = new ThemeFragmentTab();

                return tab1;
            case 1:
                RulesFragmentTab tab2 = new RulesFragmentTab();
                return tab2;
            case 2:
                EventStruFragmentTab tab3 = new EventStruFragmentTab();
                return tab3;

            case 3:
                TeamStrucutreTab tab4= new TeamStrucutreTab();
                return tab4;


            case 4:
                 ContactUsTab tab5 = new ContactUsTab();

                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}