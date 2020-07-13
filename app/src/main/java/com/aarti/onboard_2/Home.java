package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.text.Html;

import android.widget.LinearLayout;
import android.widget.TextView;


public class Home extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;


    private FeaturesAdapter featuresAdapter;


    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSlideViewPager=(ViewPager) findViewById(R.id.v_p);
        mDotLayout=(LinearLayout) findViewById(R.id.dots);


        featuresAdapter=new FeaturesAdapter(this);


        mSlideViewPager.setAdapter(featuresAdapter);


        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);






    }

    public void addDotsIndicator(int position)
    {
        mDots = new TextView[5];
        mDotLayout.removeAllViews();

        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i ){
            addDotsIndicator(i);

            mCurrentPage=i;

            if(i==0) {

            }
            else if(i==mDots.length-1) {

            }
            else {

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}

