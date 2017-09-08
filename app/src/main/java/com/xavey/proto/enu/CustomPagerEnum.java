package com.xavey.proto.enu;

import com.xavey.proto.R;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public enum CustomPagerEnum {

    RED(R.string.page_question_e1, R.layout.fragment_a1),
    BLUE(R.string.page_question_e2, R.layout.fragment_b1);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
