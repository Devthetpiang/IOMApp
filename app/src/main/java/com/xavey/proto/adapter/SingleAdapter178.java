package com.xavey.proto.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.xavey.proto.R;
import com.xavey.proto.fragment.A1Fragment;
import com.xavey.proto.fragment.EFragment;
import com.xavey.proto.fragment.G4Fragment;
import com.xavey.proto.fragment.H2ToH16Fragment;
import com.xavey.proto.fragment.SingleFragment;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class SingleAdapter178 extends FragmentPagerAdapter {
    private static String[] mTitleArray;
    SparseArray<Fragment>regFragments = new SparseArray<Fragment>();


    public SingleAdapter178(FragmentManager fragmentManager, String[] titleList) {
        super(fragmentManager);
        mTitleArray =  titleList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        Fragment fragment = (Fragment) super.instantiateItem(container,position);
        regFragments.put(position,fragment);
        return fragment;
    }

     // Returns total number of pages
    @Override
    public int getCount() {
        return mTitleArray.length;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        if(regFragments.get(position)!=null){
            return regFragments.get(position);
        }
        switch (position) {
            case 0:
                return SingleFragment.newInstance(R.layout.fragment_pre_178);
            case 1:
                return SingleFragment.newInstance(R.layout.fragment_q1_178);
            case 2:
                return SingleFragment.newInstance(R.layout.fragment_q2_178);
            case 3:
                return SingleFragment.newInstance(R.layout.fragment_q3a_178);
            case 4:
                return SingleFragment.newInstance(R.layout.fragment_q3b_178);
            case 5:
                return SingleFragment.newInstance(R.layout.fragment_q4_178);
            case 6:
                return SingleFragment.newInstance(R.layout.fragment_q5_178);
            case 7:
                return SingleFragment.newInstance(R.layout.fragment_q6_178);
            case 8:
                return SingleFragment.newInstance(R.layout.fragment_q7_178);
            case 9:
                return SingleFragment.newInstance(R.layout.fragment_q8_178);
            case 10:
                return SingleFragment.newInstance(R.layout.fragment_q9_178);
            case 11:
                return SingleFragment.newInstance(R.layout.fragment_q10_178);
            case 12:
                return SingleFragment.newInstance(R.layout.fragment_q11_178);
            case 13:
                return SingleFragment.newInstance(R.layout.fragment_q12_178);
            case 14:
                return SingleFragment.newInstance(R.layout.fragment_q13_178);
            case 15:
                return SingleFragment.newInstance(R.layout.fragment_q14_178);
            case 16:
                return SingleFragment.newInstance(R.layout.fragment_q15_178);
            case 17:
                return SingleFragment.newInstance(R.layout.fragment_q16_178);
            case 18:
                return SingleFragment.newInstance(R.layout.fragment_q17_178);
            case 19:
                return SingleFragment.newInstance(R.layout.fragment_q18_178);
            case 20:
                return SingleFragment.newInstance(R.layout.fragment_q19_178);
            case 21:
                return SingleFragment.newInstance(R.layout.fragment_q20_178);
            case 22:
                return SingleFragment.newInstance(R.layout.fragment_q21_178);
            case 23:
                return SingleFragment.newInstance(R.layout.fragment_submit);
            default:
                return null;
        }
    }

    public Fragment getRegFragment(int position){
        return regFragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleArray[position];
    }

}
