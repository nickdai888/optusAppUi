package com.optus.optusuidemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private TextView mTextView;
    private int selectedTabIndex = 1;//choose the first one as default

    private int buttonBackGroundColor = Color.RED;
    private LinearLayout btnBackground;

    //small round point
    private ViewGroup smallRoundGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init ui elements
        initTab();
        initViewPager();
        initTextView();
        initButtons();
        //init event
        initEvents();
    }

    private void initButtons(){
        Button bt_red =  (Button)this.findViewById(R.id.bt_red);
        bt_red.setTag(Color.RED);
        bt_red.setOnClickListener(this);

        Button bt_green=  (Button)this.findViewById(R.id.bt_green);
        bt_green.setTag(Color.GREEN);
        bt_green.setOnClickListener(this);

        Button bt_blue =  (Button)this.findViewById(R.id.bt_blue);
        bt_blue.setTag(Color.BLUE);
        bt_blue.setOnClickListener(this);

        btnBackground = (LinearLayout)findViewById(R.id.bt_bg);
        updateButtonBackGroundColor();//init button background color
    }

    private ImageView imageView;
    private ImageView[] imageViews;

    private void initViewPager(){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.addOnPageChangeListener(new GuidePageChangeListener());

        //init small round group
        smallRoundGroup = (ViewGroup)this.findViewById(R.id.ptViewGroup);
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
        mTabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        TabLayout.Tab tab1 = mTabLayout.newTab().setText("item1");
        mTabLayout.addTab(tab1);
        tab1.setTag(new Integer(1));

        TabLayout.Tab tab2 = mTabLayout.newTab().setText("item2");
        mTabLayout.addTab(tab2);
        tab2.setTag(new Integer(2));

        TabLayout.Tab tab3 = mTabLayout.newTab().setText("item3");
        mTabLayout.addTab(tab3);
        tab3.setTag(new Integer(3));

        TabLayout.Tab tab4 = mTabLayout.newTab().setText("item4");
        mTabLayout.addTab(tab4);
        tab4.setTag(new Integer(4));

        TabLayout.Tab tab5 = mTabLayout.newTab().setText("item5");
        mTabLayout.addTab(tab5);
        tab5.setTag(new Integer(5));
    }


    private void initTextView(){
        mTextView = (TextView)this.findViewById(R.id.bt_mtx);
        mTextView.setText(getTextContent());
    }

    private void updateText(){
        mTextView.setText(getTextContent());
    }

    //get text content by selected tab item
    private final String getTextContent(){
        String content =  "User choose ITEM" +   String.valueOf(selectedTabIndex );
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
        buttonBackGroundColor = (Integer)v.getTag();
        updateButtonBackGroundColor();
    }

    private void updateButtonBackGroundColor(){
        btnBackground.setBackgroundColor(buttonBackGroundColor);
    }

}


