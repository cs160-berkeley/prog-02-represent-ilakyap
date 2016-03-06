package com.cs160.joleary.catnip;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by IlakyaWork on 3/4/2016.
 */
public class RepresentativeActivity extends Activity {

    private SensorManager mSensorManager;
    private Sensor mSensor;

    public static class Screen {
        public String mTitle;
        public String mText;

        public Screen (String title, String text) {
            mTitle = title;
            mText = text;
        }
    }

    Screen rep = new Screen("Name One", "Democrat");
    Screen rep2 = new Screen ("Name Two", "Democrat");
    Screen hr1 = new Screen ("Name Three", "Republican");
    Screen voteStatsOne = new Screen("2012 Vote", "State: CA, County: San Bernadino, Obama: 70%, Romey: 30%");

    Screen rep3 = new Screen("Name Three", "Democrat");
    Screen rep4 = new Screen ("Name Four", "Democrat");
    Screen hr2 = new Screen ("Name Five", "Democrat");
    Screen voteStatsTwo = new Screen("2012 Vote", "State: AL, County: County1, Obama: 30%, Romey: 70%");

    Screen rep5 = new Screen("Name Four", "Democrat");
    Screen rep6 = new Screen ("Name Five", "Democrat");
    Screen hr3 = new Screen ("Name Six", "Democrat");
    Screen voteStatsThree = new Screen("2012 Vote", "State: VI, County: County2, Obama: 30%, Romey: 70%");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.representative_activity);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String location = extras.getString("LOCATION");

        if (location.equals("98594")) {
            Screen[][] screens = {{rep, rep2, hr1, voteStatsOne}};
            final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
            pager.setAdapter(new SampleGridPagerAdapter(this, getFragmentManager(), location, screens));
        }
        if (location.equals("95128")) {
            Screen[][] screens = {{rep3, rep4, hr2, voteStatsTwo}};
            final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
            pager.setAdapter(new SampleGridPagerAdapter(this, getFragmentManager(), location, screens));
        }
        if (location.equals("95384")) {
            Screen[][] screens = {{rep5, rep6, hr3, voteStatsThree}};
            final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
            pager.setAdapter(new SampleGridPagerAdapter(this, getFragmentManager(), location, screens));
        }

    }




}
