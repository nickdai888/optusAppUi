package com.optus.optusuidemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
/**
 * Created by nick on 16/8/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int pagecount = 4;
    private int color[]=new int[]{android.R.color.holo_orange_light,android.R.color.holo_green_dark,
            android.R.color.holo_red_dark,android.R.color.holo_blue_bright};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.getInstance(position+1,color[position]);
    }

    @Override
    public int getCount() {
        return pagecount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page"+(position+1);
    }

    public int getPageNumber(){
        return pagecount;
    }
}

