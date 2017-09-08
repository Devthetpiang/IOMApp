package com.xavey.proto.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.xavey.proto.R;
import com.xavey.proto.fragment.A1Fragment;
import com.xavey.proto.fragment.EFragment;
import com.xavey.proto.fragment.G4Fragment;
import com.xavey.proto.fragment.H2ToH16Fragment;
import com.xavey.proto.fragment.SingleFragment;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class SingleAdapter extends FragmentPagerAdapter {
    private static String[] mTitleArray;
    SparseArray<Fragment>regFragments = new SparseArray<Fragment>();


    public SingleAdapter(FragmentManager fragmentManager, String[] titleList) {
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
    public android.support.v4.app.Fragment getItem(int position) {
        if(regFragments.get(position)!=null){
            return regFragments.get(position);
        }
        switch (position) {
            case 0:
                return SingleFragment.newInstance(R.layout.fragment_sc_a);
            case 1:
                return SingleFragment.newInstance(R.layout.fragment_sc_b);
            case 2:
                return SingleFragment.newInstance(R.layout.fragment_sc_c);
            case 3:
                return SingleFragment.newInstance(R.layout.fragment_sc_d);
            case 4:
                return SingleFragment.newInstance(R.layout.fragment_sc_e);
            case 5:
                return SingleFragment.newInstance(R.layout.fragment_pre);
            case 6:
                return A1Fragment.newInstance();
            case 7:
                return SingleFragment.newInstance(R.layout.fragment_b1);
            case 8:
                return SingleFragment.newInstance(R.layout.fragment_b2);
            case 9:
                return SingleFragment.newInstance(R.layout.fragment_b3);
            case 10:
                return SingleFragment.newInstance(R.layout.fragment_b4);
            case 11:
                return SingleFragment.newInstance(R.layout.fragment_b5);
            case 12:
                return SingleFragment.newInstance(R.layout.fragment_b6);
            case 13:
                return SingleFragment.newInstance(R.layout.fragment_b7);
            case 14:
                return SingleFragment.newInstance(R.layout.fragment_b8);
            case 15:
                return SingleFragment.newInstance(R.layout.fragment_b9);
            case 16:
                return SingleFragment.newInstance(R.layout.fragment_b10);
            case 17:
                return SingleFragment.newInstance(R.layout.fragment_b11);
            case 18:
                return SingleFragment.newInstance(R.layout.fragment_b12);
            case 19:
                return SingleFragment.newInstance(R.layout.fragment_c1);
            case 20:
                return SingleFragment.newInstance(R.layout.fragment_c2);
            case 21:
                return SingleFragment.newInstance(R.layout.fragment_c3);
            case 22:
                return SingleFragment.newInstance(R.layout.fragment_c4);
            case 23:
                return SingleFragment.newInstance(R.layout.fragment_c5);
            case 24:
                return SingleFragment.newInstance(R.layout.fragment_c6);
            case 25:
                return SingleFragment.newInstance(R.layout.fragment_c7);
            case 26:
                return SingleFragment.newInstance(R.layout.fragment_c8);
            case 27:
                return SingleFragment.newInstance(R.layout.fragment_c9);
            case 28:
                return SingleFragment.newInstance(R.layout.fragment_c10);
            case 29:
                return SingleFragment.newInstance(R.layout.fragment_c11);
            case 30:
                return SingleFragment.newInstance(R.layout.fragment_c12);
            case 31:
                return SingleFragment.newInstance(R.layout.fragment_c13);
            case 32:
                return SingleFragment.newInstance(R.layout.fragment_c14);
            case 33:
                return SingleFragment.newInstance(R.layout.fragment_c15);
            case 34:
                return SingleFragment.newInstance(R.layout.fragment_d1);
            case 35:
                return SingleFragment.newInstance(R.layout.fragment_d2);
            case 36:
                return SingleFragment.newInstance(R.layout.fragment_d3);
            case 37:
                return SingleFragment.newInstance(R.layout.fragment_d4);
            case 38:
                return SingleFragment.newInstance(R.layout.fragment_d5);
            case 39:
                return SingleFragment.newInstance(R.layout.fragment_d6);
            case 40:
                return SingleFragment.newInstance(R.layout.fragment_d7);
            case 41:
                return SingleFragment.newInstance(R.layout.fragment_d8);
            case 42:
                return SingleFragment.newInstance(R.layout.fragment_d9);
            case 43:
                return SingleFragment.newInstance(R.layout.fragment_d10);
            case 44:
                return SingleFragment.newInstance(R.layout.fragment_d11);
            case 45:
                return EFragment.newInstance();
            case 46:
                return SingleFragment.newInstance(R.layout.fragment_f1);
            case 47:
                return SingleFragment.newInstance(R.layout.fragment_f2);
            case 48:
                return SingleFragment.newInstance(R.layout.fragment_f3);
            case 49:
                return SingleFragment.newInstance(R.layout.fragment_f4);
            case 50:
                return SingleFragment.newInstance(R.layout.fragment_f5);
            case 51:
                return SingleFragment.newInstance(R.layout.fragment_f6);
            case 52:
                return SingleFragment.newInstance(R.layout.fragment_f7);
            case 53:
                return SingleFragment.newInstance(R.layout.fragment_f8);
            case 54:
                return SingleFragment.newInstance(R.layout.fragment_f9);
            case 55:
                return SingleFragment.newInstance(R.layout.fragment_g1);
            case 56:
                return SingleFragment.newInstance(R.layout.fragment_g2);
            case 57:
                return SingleFragment.newInstance(R.layout.fragment_g3);
            case 58:
                return G4Fragment.newInstance();
            case 59:
                return SingleFragment.newInstance(R.layout.fragment_h1);
            case 60:
                return H2ToH16Fragment.newInstance();
            case 61:
                return SingleFragment.newInstance(R.layout.fragment_i1);
            case 62:
                return SingleFragment.newInstance(R.layout.fragment_i2);
            case 63:
                return SingleFragment.newInstance(R.layout.fragment_i3);
            case 64:
                return SingleFragment.newInstance(R.layout.fragment_i4);
            case 65:
                return SingleFragment.newInstance(R.layout.fragment_i5);
            case 66:
                return SingleFragment.newInstance(R.layout.fragment_i6);
            case 67:
                return SingleFragment.newInstance(R.layout.fragment_i7);
            case 68:
                return SingleFragment.newInstance(R.layout.fragment_i8);
            case 69:
                return SingleFragment.newInstance(R.layout.fragment_i9);
            case 70:
                return SingleFragment.newInstance(R.layout.fragment_i10);
            case 71:
                return SingleFragment.newInstance(R.layout.fragment_i11);
            case 72:
                return SingleFragment.newInstance(R.layout.fragment_i12);
            case 73:
                return SingleFragment.newInstance(R.layout.fragment_i13);
            case 74:
                return SingleFragment.newInstance(R.layout.fragment_j1);
            case 75:
                return SingleFragment.newInstance(R.layout.fragment_j2);
            case 76:
                return SingleFragment.newInstance(R.layout.fragment_j3);
            case 77:
                return SingleFragment.newInstance(R.layout.fragment_j4);
            case 78:
                return SingleFragment.newInstance(R.layout.fragment_j5);
            case 79:
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
