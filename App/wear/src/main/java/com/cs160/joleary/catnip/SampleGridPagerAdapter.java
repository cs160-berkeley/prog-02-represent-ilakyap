package com.cs160.joleary.catnip;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;

import java.util.List;

/**
 * Created by IlakyaWork on 3/4/2016.
 */
public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {

    private Context mContext;
    private String location;
    RepresentativeActivity.Screen[][] mScreens;

    public SampleGridPagerAdapter(Context ctx, FragmentManager fm, String mlocation, RepresentativeActivity.Screen reps[][]) {
        super(fm);
        mContext = ctx;
        location = mlocation;
        mScreens = reps;
    }

    // Obtain the UI fragment at the specified position
    @Override
    public Fragment getFragment(int row, int col) {
        RepresentativeActivity.Screen rep = mScreens[row][col];

        CardFragment fragment = CardFragment.create(rep.mTitle, rep.mText);
        //Page page = PAGES[row][col];
        //String title =
        //        page.titleRes != 0 ? mContext.getString(page.titleRes) : null;
        //String text =
           //     page.textRes != 0 ? mContext.getString(page.textRes) : null;
        // Advanced settings (card gravity, card expansion/scrolling)
        //fragment.setCardGravity(page.cardGravity);
        //fragment.setExpansionEnabled(page.expansionEnabled);
        //fragment.setExpansionDirection(page.expansionDirection);
        //fragment.setExpansionFactor(page.expansionFactor);
        return fragment;
    }

    @Override
    public int getRowCount() {
        return mScreens.length;
    }

    @Override
    public int getColumnCount(int row) {
        return mScreens[row].length;
    }

    @Override
    public Drawable getBackgroundForRow(int row) {
        return GridPagerAdapter.BACKGROUND_NONE;
    }



}
