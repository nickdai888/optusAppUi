package com.optus.optusuidemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nick on 16/8/2.
 */

public class ViewPagerFragment extends Fragment {

    private int page;
    private int color;
    public static final String GETPAGE="get_page";
    public static final String GETCOLOR="get_color";

    public static ViewPagerFragment getInstance(int page,int color){
        Bundle args = new Bundle();
        args.putInt(GETPAGE, page);
        args.putInt(GETCOLOR, color);
        ViewPagerFragment pageFragment = new ViewPagerFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page=getArguments().getInt(GETPAGE);
        color=getArguments().getInt(GETCOLOR);
    }


    private void showToast(){
        Context context = getActivity().getApplicationContext();
        CharSequence text = String.valueOf("Page " + page);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_fragment);
        textView.setText("Page" + page);
        view.setBackgroundResource(color);
        view.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                showToast();
            }
        });
        return view;
    }

}
