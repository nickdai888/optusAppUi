package com.optus.optusuidemo;

import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import com.optus.optusuidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBinding;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter viewPagerAdapter;

//    private TextView mTextView;
    private int selectedTabIndex = 1;//choose the first one as default
    private UserData user;

    //small round point
    private ViewGroup smallRoundGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new UserData();

        mBinding.setUser(user);
        //init ui elements
        initTab();
        initViewPager();
        //init event
        initEvents();
    }


    private ImageView imageView;
    private ImageView[] imageViews;

    private void initViewPager(){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager = mBinding.vpViewpager;
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.addOnPageChangeListener(new GuidePageChangeListener());

        //init small round group
        smallRoundGroup = mBinding.ptViewGroup;
        imageViews = new ImageView[viewPagerAdapter.getPageNumber()];
        for (int i = 0; i < viewPagerAdapter.getPageNumber(); i++) {
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            margin.setMargins(10, 0, 0, 0);
            imageView = new ImageView(MainActivity.this);

            imageView.setLayoutParams(new LayoutParams(5, 5));
            imageViews[i] = imageView;

            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(R.drawable.page_indicator_focued_round);
            } else {
                imageViews[i]
                        .setBackgroundResource(R.drawable.page_indicator_unfocued_round);
            }
            smallRoundGroup.addView(imageViews[i], margin);
        }
    }

    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0]
                        .setBackgroundResource(R.drawable.page_indicator_focued_round);

                if (arg0 != i) {
                    imageViews[i]
                            .setBackgroundResource(R.drawable.page_indicator_unfocued_round);
                }
            }
        }
    }

    private void initTab(){
        mTabLayout = mBinding.tlTabs;
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        TabLayout.Tab tab1 = mTabLayout.newTab().setText(this.getString(R.string.tab1_name));
        mTabLayout.addTab(tab1);
        tab1.setTag(new Integer(1));

        TabLayout.Tab tab2 = mTabLayout.newTab().setText(this.getString(R.string.tab2_name));
        mTabLayout.addTab(tab2);
        tab2.setTag(new Integer(2));

        TabLayout.Tab tab3 = mTabLayout.newTab().setText(this.getString(R.string.tab3_name));
        mTabLayout.addTab(tab3);
        tab3.setTag(new Integer(3));

        TabLayout.Tab tab4 = mTabLayout.newTab().setText(this.getString(R.string.tab4_name));
        mTabLayout.addTab(tab4);
        tab4.setTag(new Integer(4));

        TabLayout.Tab tab5 = mTabLayout.newTab().setText(this.getString(R.string.tab5_name));
        mTabLayout.addTab(tab5);
        tab5.setTag(new Integer(5));

        user.setItemPanleText(getTextContent());
    }



    private void updateText(){
        user.setItemPanleText(getTextContent());
    }

    //get text content by selected tab item
    private final String getTextContent(){
        String content =  this.getString(R.string.user_choose_title) +   String.valueOf(selectedTabIndex );
        return content;
    }

    private void initEvents() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int selectedItem = 0;
                Integer itr = (Integer)tab.getTag();
                if(itr != null) {
                    selectedItem = itr.intValue();
                }
                if((selectedItem >= 1) && (selectedItem <= 5)){
                    selectedTabIndex  =  selectedItem;
                }
                updateText();
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
    public void onClick(View v) {
        Button button = (Button)v;
        ColorStateList mList = button.getTextColors();
        int color = mList.getDefaultColor();
        user.setBtnColor(color);
    }

}


