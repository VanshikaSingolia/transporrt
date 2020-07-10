package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mNextBtn;
    private Button mSkipBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager=(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout=(LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn=(Button) findViewById(R.id.nextbutton);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });


    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
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
                mNextBtn.setEnabled(true);
                mNextBtn.setText("Next");
            }
            else if(i==mDots.length-1) {
                mNextBtn.setEnabled(true);
                mNextBtn.setText("Get started");
            }
           else {
                mNextBtn.setEnabled(true);
                mNextBtn.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}


