package com.xavey.proto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.helper.AppValues;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class H2ToH16ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
public enum ITEM_TYPE {h2,h3,h4,h5,h6,h7,
            h8,h8a,h9,h10,h11,h12,h13,h14,h15,h16};

private final LayoutInflater mLayoutInflater;
private final Context mContext;
    private final int mParentIndex;
    private String[] mTitles;

    public H2ToH16ListAdapter(Context context, int parentIndex) {
        mTitles = context.getResources().getStringArray(R.array.H_Titles);
        mContext = context;
        mParentIndex = parentIndex;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.h2.ordinal()) {
            return new H2ViewHolder(mLayoutInflater.inflate(R.layout.card_h2, parent, false));
        } else if (viewType == ITEM_TYPE.h3.ordinal()) {
            return new H3ViewHolder(mLayoutInflater.inflate(R.layout.card_h3, parent, false));
        }else if (viewType == ITEM_TYPE.h4.ordinal()) {
            return new H4ViewHolder(mLayoutInflater.inflate(R.layout.card_h4, parent, false));
        }else if (viewType == ITEM_TYPE.h5.ordinal()) {
            return new H5ViewHolder(mLayoutInflater.inflate(R.layout.card_h5, parent, false));
        }else if (viewType == ITEM_TYPE.h6.ordinal()) {
            return new H6ViewHolder(mLayoutInflater.inflate(R.layout.card_h6, parent, false));
        }else if (viewType == ITEM_TYPE.h7.ordinal()) {
            return new H7ViewHolder(mLayoutInflater.inflate(R.layout.card_h7, parent, false));
        }else if (viewType == ITEM_TYPE.h8.ordinal()) {
            return new H8ViewHolder(mLayoutInflater.inflate(R.layout.card_h8, parent, false));
        }else if (viewType == ITEM_TYPE.h8a.ordinal()) {
            return new H8ViewHolder(mLayoutInflater.inflate(R.layout.card_h8_a, parent, false));
        }else if (viewType == ITEM_TYPE.h9.ordinal()) {
            return new H9ViewHolder(mLayoutInflater.inflate(R.layout.card_h9, parent, false));
        }else if (viewType == ITEM_TYPE.h10.ordinal()) {
            return new H10ViewHolder(mLayoutInflater.inflate(R.layout.card_h10, parent, false));
        }else if (viewType == ITEM_TYPE.h11.ordinal()) {
            return new H11ViewHolder(mLayoutInflater.inflate(R.layout.card_h11, parent, false));
        }else if (viewType == ITEM_TYPE.h12.ordinal()) {
            return new H12ViewHolder(mLayoutInflater.inflate(R.layout.card_h12, parent, false));
        }else if (viewType == ITEM_TYPE.h13.ordinal()) {
            return new H13ViewHolder(mLayoutInflater.inflate(R.layout.card_h13, parent, false));
        }else if (viewType == ITEM_TYPE.h14.ordinal()) {
            return new H14ViewHolder(mLayoutInflater.inflate(R.layout.card_h14, parent, false));
        }else if (viewType == ITEM_TYPE.h15.ordinal()) {
            return new H15ViewHolder(mLayoutInflater.inflate(R.layout.card_h15, parent, false));
        }else if (viewType == ITEM_TYPE.h16.ordinal()) {
            return new H16ViewHolder(mLayoutInflater.inflate(R.layout.card_h16, parent, false));
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof H2ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h2_"+String.valueOf(mParentIndex)+"_h2")) {
                ((H2ViewHolder) holder).et_h2.setText(AppValues.getInstance().getCurrentRecords().get("h2_" + String.valueOf(mParentIndex) + "_h2"));
            }
        }else if (holder instanceof H3ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h3_"+String.valueOf(mParentIndex)+"_h3")) {
                ((H3ViewHolder) holder).et_h3.setText(AppValues.getInstance().getCurrentRecords().get("h3_" + String.valueOf(mParentIndex) + "_h3"));
            }
        }else if (holder instanceof H4ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h4_"+String.valueOf(mParentIndex)+"_h4")) {
                ((H4ViewHolder) holder).et_h4.setText(AppValues.getInstance().getCurrentRecords().get("h4_" + String.valueOf(mParentIndex) + "_h4_a"));
            }
        }
        else if (holder instanceof H5ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h5_"+String.valueOf(mParentIndex)+"_h5")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h5_"+String.valueOf(mParentIndex)+"_h5");
                ((H5ViewHolder) holder).sp_h5.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H6ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h6_"+String.valueOf(mParentIndex)+"_h6")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h6_"+String.valueOf(mParentIndex)+"_h6");
                ((H6ViewHolder) holder).sp_h6.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H7ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h8_"+String.valueOf(mParentIndex)+"_h7")) {
                ((H7ViewHolder) holder).et_h7.setText(AppValues.getInstance().getCurrentRecords().get("h8_" + String.valueOf(mParentIndex) + "_h7"));
            }
        }
        else if (holder instanceof H8ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h8_"+String.valueOf(mParentIndex)+"_h8")) {
                ((H8ViewHolder) holder).et_h8.setText(AppValues.getInstance().getCurrentRecords().get("h8_" + String.valueOf(mParentIndex) + "_h8"));
            }
        }
        else if (holder instanceof H8AViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("h8_"+String.valueOf(mParentIndex)+"_h8_a")) {
                ((H8AViewHolder) holder).et_h8a.setText(AppValues.getInstance().getCurrentRecords().get("h8_" + String.valueOf(mParentIndex) + "_h8_a"));
            }
        }
        else if (holder instanceof H9ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h9_"+String.valueOf(mParentIndex)+"_h9")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h9_"+String.valueOf(mParentIndex)+"_h9");
                ((H9ViewHolder) holder).sp_h9.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H10ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h10_"+String.valueOf(mParentIndex)+"_h10")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h10_"+String.valueOf(mParentIndex)+"_h10");
                ((H10ViewHolder) holder).sp_h10.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H11ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h11_"+String.valueOf(mParentIndex)+"_h11")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h11_"+String.valueOf(mParentIndex)+"_h11");
                ((H11ViewHolder) holder).sp_h11.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H12ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h12_"+String.valueOf(mParentIndex)+"_h12")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h12_"+String.valueOf(mParentIndex)+"_h12");
                ((H12ViewHolder) holder).sp_h12.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H13ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e3_"+String.valueOf(mParentIndex)+"_h13")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e3_"+String.valueOf(mParentIndex)+"_h13");
                ((H13ViewHolder) holder).sp_h13.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H14ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h14_"+String.valueOf(mParentIndex)+"_h14")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h14_"+String.valueOf(mParentIndex)+"_h14");
                ((H14ViewHolder) holder).sp_h14.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H15ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h15_"+String.valueOf(mParentIndex)+"_h15")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h15_"+String.valueOf(mParentIndex)+"_h15");
                ((H15ViewHolder) holder).sp_h15.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof H16ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("h16_"+String.valueOf(mParentIndex)+"_h16")) {
                String val = AppValues.getInstance().getCurrentRecords().get("h16_"+String.valueOf(mParentIndex)+"_h16");
                ((H16ViewHolder) holder).sp_h16.setSelection(Integer.parseInt(val));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return ITEM_TYPE.h2.ordinal();
            case 1:
                return ITEM_TYPE.h3.ordinal();
            case 2:
                return ITEM_TYPE.h4.ordinal();
            case 3:
                return ITEM_TYPE.h5.ordinal();
            case 4:
                return ITEM_TYPE.h6.ordinal();
            case 5:
                return ITEM_TYPE.h7.ordinal();
            case 6:
                return ITEM_TYPE.h8.ordinal();
            case 7:
                return ITEM_TYPE.h9.ordinal();
            case 8:
                return ITEM_TYPE.h10.ordinal();
            case 9:
                return ITEM_TYPE.h11.ordinal();
            case 10:
                return ITEM_TYPE.h12.ordinal();
            case 11:
                return ITEM_TYPE.h13.ordinal();
            case 12:
                return ITEM_TYPE.h14.ordinal();
            case 13:
                return ITEM_TYPE.h15.ordinal();
            case 14:
                return ITEM_TYPE.h16.ordinal();
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class H2ViewHolder extends RecyclerView.ViewHolder {
        EditText et_h2;

        H2ViewHolder(View view) {
            super(view);
            this.et_h2 = (EditText)view.findViewById(R.id.et_h2);
        }
    }
    public static class H3ViewHolder extends RecyclerView.ViewHolder {
        EditText et_h3;

        H3ViewHolder(View view) {
            super(view);
            this.et_h3 = (EditText)view.findViewById(R.id.et_h3);
        }
    }
    public static class H4ViewHolder extends RecyclerView.ViewHolder {
        EditText et_h4;

        H4ViewHolder(View view) {
            super(view);
            this.et_h4 = (EditText)view.findViewById(R.id.et_h4);
        }
    }
    public static class H5ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h5;

        H5ViewHolder(View view) {
            super(view);
            this.sp_h5 = (Spinner)view.findViewById(R.id.sp_h5);
        }
    }
    public static class H6ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h6;

        H6ViewHolder(View view) {
            super(view);
            this.sp_h6 = (Spinner)view.findViewById(R.id.sp_h6);
        }
    }
    public static class H7ViewHolder extends RecyclerView.ViewHolder {
        EditText et_h7;

        H7ViewHolder(View view) {
            super(view);
            this.et_h7 = (EditText)view.findViewById(R.id.et_h7);
        }
    }
    public static class H8ViewHolder extends RecyclerView.ViewHolder {
        EditText et_h8;

        H8ViewHolder(View view) {
            super(view);
            this.et_h8 = (EditText)view.findViewById(R.id.et_h8);
        }
    }
    public static class H8AViewHolder extends RecyclerView.ViewHolder {
        EditText et_h8a;

        H8AViewHolder(View view) {
            super(view);
            this.et_h8a = (EditText)view.findViewById(R.id.et_h8_a);
        }
    }
    public static class H9ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h9;

        H9ViewHolder(View view) {
            super(view);
            this.sp_h9 = (Spinner)view.findViewById(R.id.sp_h9);
        }
    }
    public static class H10ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h10;

        H10ViewHolder(View view) {
            super(view);
            this.sp_h10 = (Spinner)view.findViewById(R.id.sp_h10);
        }
    }
    public static class H11ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h11;

        H11ViewHolder(View view) {
            super(view);
            this.sp_h11 = (Spinner)view.findViewById(R.id.sp_h11);
        }
    }

    public static class H12ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h12;

        H12ViewHolder(View view) {
            super(view);
            this.sp_h12 = (Spinner)view.findViewById(R.id.sp_h12);
        }
    }
    public static class H13ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h13;

        H13ViewHolder(View view) {
            super(view);
            this.sp_h13 = (Spinner)view.findViewById(R.id.sp_h13);
        }
    }
    public static class H14ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h14;

        H14ViewHolder(View view) {
            super(view);
            this.sp_h14 = (Spinner)view.findViewById(R.id.sp_h14);
        }
    }
    public static class H15ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h15;

        H15ViewHolder(View view) {
            super(view);
            this.sp_h15 = (Spinner)view.findViewById(R.id.sp_h15);
        }
    }
    public static class H16ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_h16;

        H16ViewHolder(View view) {
            super(view);
            this.sp_h16 = (Spinner)view.findViewById(R.id.sp_h16);
        }
    }

}
