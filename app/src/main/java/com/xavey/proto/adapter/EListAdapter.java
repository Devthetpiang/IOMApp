package com.xavey.proto.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.helper.AppValues;

import java.util.HashMap;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class EListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
public enum ITEM_TYPE {e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20};

private final LayoutInflater mLayoutInflater;
private static Context mContext = null;
    private final int mParentIndex;

    private String[] mTitles;

    public EListAdapter(Context context, int parentIndex) {
        mTitles = context.getResources().getStringArray(R.array.E_Titles);
        mContext = context;
        mParentIndex = parentIndex;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.e2.ordinal()) {
            return new E2ViewHolder(mLayoutInflater.inflate(R.layout.card_e2, parent, false));
        } else if (viewType == ITEM_TYPE.e3.ordinal()) {
            return new E3ViewHolder(mLayoutInflater.inflate(R.layout.card_e3, parent, false));
        }else if (viewType == ITEM_TYPE.e4.ordinal()) {
            return new E4ViewHolder(mLayoutInflater.inflate(R.layout.card_e4, parent, false));
        }else if (viewType == ITEM_TYPE.e5.ordinal()) {
            return new E5ViewHolder(mLayoutInflater.inflate(R.layout.card_e5, parent, false));
        }else if (viewType == ITEM_TYPE.e6.ordinal()) {
            return new E6ViewHolder(mLayoutInflater.inflate(R.layout.card_e6, parent, false));
        }else if (viewType == ITEM_TYPE.e7.ordinal()) {
            return new E7ViewHolder(mLayoutInflater.inflate(R.layout.card_e7, parent, false));
        }else if (viewType == ITEM_TYPE.e8.ordinal()) {
            return new E8ViewHolder(mLayoutInflater.inflate(R.layout.card_e8, parent, false));
        }else if (viewType == ITEM_TYPE.e9.ordinal()) {
            return new E9ViewHolder(mLayoutInflater.inflate(R.layout.card_e9, parent, false));
        }else if (viewType == ITEM_TYPE.e10.ordinal()) {
            return new E10ViewHolder(mLayoutInflater.inflate(R.layout.card_e10, parent, false));
        }else if (viewType == ITEM_TYPE.e11.ordinal()) {
            return new E11ViewHolder(mLayoutInflater.inflate(R.layout.card_e11, parent, false));
        }else if (viewType == ITEM_TYPE.e12.ordinal()) {
            return new E12ViewHolder(mLayoutInflater.inflate(R.layout.card_e12, parent, false));
        }else if (viewType == ITEM_TYPE.e13.ordinal()) {
            return new E13ViewHolder(mLayoutInflater.inflate(R.layout.card_e13, parent, false));
        }else if (viewType == ITEM_TYPE.e14.ordinal()) {
            return new E14ViewHolder(mLayoutInflater.inflate(R.layout.card_e14, parent, false));
        }else if (viewType == ITEM_TYPE.e15.ordinal()) {
            return new E15ViewHolder(mLayoutInflater.inflate(R.layout.card_e15, parent, false));
        }else if (viewType == ITEM_TYPE.e16.ordinal()) {
            return new E16ViewHolder(mLayoutInflater.inflate(R.layout.card_e16, parent, false));
        }else if (viewType == ITEM_TYPE.e17.ordinal()) {
            return new E17ViewHolder(mLayoutInflater.inflate(R.layout.card_e17, parent, false));
        }else if (viewType == ITEM_TYPE.e18.ordinal()) {
            return new E18ViewHolder(mLayoutInflater.inflate(R.layout.card_e18, parent, false));
        }else if (viewType == ITEM_TYPE.e19.ordinal()) {
            return new E19ViewHolder(mLayoutInflater.inflate(R.layout.card_e19, parent, false));
        }else if (viewType == ITEM_TYPE.e20.ordinal()) {
            return new E20ViewHolder(mLayoutInflater.inflate(R.layout.card_e20, parent, false));
        }else{
            return null;
        }
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof E2ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e2")) {
                ((E2ViewHolder) holder).et_e2.setText(AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e2"));
            }
        } else if (holder instanceof E3ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e3")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e3");
                ((E3ViewHolder) holder).sp_e3.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E4ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e4")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e4");
                ((E4ViewHolder) holder).sp_e4.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E5ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e5")) {
                ((E5ViewHolder) holder).et_e5.setText(AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e5"));
            }
        }
        else if (holder instanceof E6ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e6")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e6");
                ((E6ViewHolder) holder).sp_e6.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E7ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e7")) {
                ((E7ViewHolder) holder).et_e7.setText(AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e7"));
            }
        }else if (holder instanceof E8ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e8")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e8");
                ((E8ViewHolder) holder).sp_e8.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E9ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e9")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e9");
                ((E9ViewHolder) holder).sp_e9.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof E10ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e10")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e10");
                ((E10ViewHolder) holder).sp_e10.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E11ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e11")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e11");
                ((E11ViewHolder) holder).sp_e11.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E12ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e12")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e12");
                ((E12ViewHolder) holder).sp_e12.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E13ViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e13")) {
                ((E13ViewHolder) holder).et_e13.setText(AppValues.getInstance().getCurrentRecords().get("e_" + String.valueOf(mParentIndex) + "_e13"));
            }
        }
        else if (holder instanceof E14ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e14")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e14");
                ((E14ViewHolder) holder).sp_e14.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E15ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e15")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e15");
                ((E15ViewHolder) holder).sp_e15.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E16ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e16")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e16");
                ((E16ViewHolder) holder).sp_e16.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E17ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e17")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e17");
                ((E17ViewHolder) holder).sp_e17.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E18ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e18")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e18");
                ((E18ViewHolder) holder).sp_e18.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E19ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e19")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e19");
                ((E19ViewHolder) holder).sp_e19.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof E20ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_"+String.valueOf(mParentIndex)+"_e20")) {
                String val = AppValues.getInstance().getCurrentRecords().get("e_"+String.valueOf(mParentIndex)+"_e20");
                ((E20ViewHolder) holder).sp_e20.setSelection(Integer.parseInt(val));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return ITEM_TYPE.e2.ordinal();
            case 1:
                return ITEM_TYPE.e3.ordinal();
            case 2:
                return ITEM_TYPE.e4.ordinal();
            case 3:
                return ITEM_TYPE.e5.ordinal();
            case 4:
                return ITEM_TYPE.e6.ordinal();
            case 5:
                return ITEM_TYPE.e7.ordinal();
            case 6:
                return ITEM_TYPE.e8.ordinal();
            case 7:
                return ITEM_TYPE.e9.ordinal();
            case 8:
                return ITEM_TYPE.e10.ordinal();
            case 9:
                return ITEM_TYPE.e11.ordinal();
            case 10:
                return ITEM_TYPE.e12.ordinal();
            case 11:
                return ITEM_TYPE.e13.ordinal();
            case 12:
                return ITEM_TYPE.e14.ordinal();
            case 13:
                return ITEM_TYPE.e15.ordinal();
            case 14:
                return ITEM_TYPE.e16.ordinal();
            case 15:
                return ITEM_TYPE.e17.ordinal();
            case 16:
                return ITEM_TYPE.e18.ordinal();
            case 17:
                return ITEM_TYPE.e19.ordinal();
            case 18:
                return ITEM_TYPE.e20.ordinal();
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class E2ViewHolder extends RecyclerView.ViewHolder {
        EditText et_e2;

        E2ViewHolder(View view) {
            super(view);
            this.et_e2 = (EditText)view.findViewById(R.id.et_e2);
        }
    }
    public static class E3ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e3;

        E3ViewHolder(View view) {
            super(view);
            this.sp_e3 = (Spinner)view.findViewById(R.id.sp_e3);
        }
    }
    public static class E4ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e4;

        E4ViewHolder(View view) {
            super(view);
            this.sp_e4 = (Spinner)view.findViewById(R.id.sp_e4);
        }
    }
    public static class E5ViewHolder extends RecyclerView.ViewHolder {
        EditText et_e5;

        E5ViewHolder(View view) {
            super(view);
            this.et_e5 = (EditText)view.findViewById(R.id.et_e5);
        }
    }
    public static class E6ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e6;

        E6ViewHolder(View view) {
            super(view);
            this.sp_e6 = (Spinner)view.findViewById(R.id.sp_e6);
     }
    }
    public static class E7ViewHolder extends RecyclerView.ViewHolder {
            EditText et_e7;
        TextView tv_a1_ref;

        E7ViewHolder(View view) {
            super(view);
            this.et_e7 = (EditText)view.findViewById(R.id.et_e7);
            this.tv_a1_ref = (TextView)view.findViewById(R.id.tv_a1_ref);
            tv_a1_ref.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                    builder1.setMessage("Write your message here.");
                    builder1.setCancelable(true);
                    StringBuilder sb = new StringBuilder();
                    HashMap<String,String> thisRecords=AppValues.getInstance().getCurrentRecords();
                    if(thisRecords.containsKey("a1_1_a1_b")){
                        sb.append("Line 1. " + thisRecords.get("a1_1_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_2_a1_b")){
                        sb.append("Line 2. " + thisRecords.get("a1_2_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_3_a1_b")){
                        sb.append("Line 3. " + thisRecords.get("a1_3_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_4_a1_b")){
                        sb.append("Line 4. " + thisRecords.get("a1_4_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_5_a1_b")){
                        sb.append("Line 5. " + thisRecords.get("a1_5_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_6_a1_b")){
                        sb.append("Line 6. " + thisRecords.get("a1_6_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_7_a1_b")){
                        sb.append("Line 7. " + thisRecords.get("a1_7_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_8_a1_b")){
                        sb.append("Line 8. " + thisRecords.get("a1_8_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_9_a1_b")){
                        sb.append("Line 9. " + thisRecords.get("a1_9_a1_b")+"\n");
                    }
                    if(thisRecords.containsKey("a1_10_a1_b")){
                        sb.append("Line 10. " + thisRecords.get("a1_10_a1_b")+"\n");
                    }

                    if(sb!=null){builder1.setMessage(sb.toString());}
                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            });
        }
    }
    public static class E8ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e8;

        E8ViewHolder(View view) {
            super(view);
            this.sp_e8 = (Spinner)view.findViewById(R.id.sp_e8);
        }
    }
    public static class E9ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e9;

        E9ViewHolder(View view) {
            super(view);
            this.sp_e9 = (Spinner)view.findViewById(R.id.sp_e9);
        }
    }
    public static class E10ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e10;

        E10ViewHolder(View view) {
            super(view);
            this.sp_e10 = (Spinner)view.findViewById(R.id.sp_e10);
        }
    }
    public static class E11ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e11;

        E11ViewHolder(View view) {
            super(view);
            this.sp_e11 = (Spinner)view.findViewById(R.id.sp_e11);
        }
    }

    public static class E12ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e12;

        E12ViewHolder(View view) {
            super(view);
            this.sp_e12 = (Spinner)view.findViewById(R.id.sp_e12);
        }
    }
    public static class E13ViewHolder extends RecyclerView.ViewHolder {
        EditText et_e13;

        E13ViewHolder(View view) {
            super(view);
            this.et_e13 = (EditText)view.findViewById(R.id.et_e13);
        }
    }
    public static class E14ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e14;

        E14ViewHolder(View view) {
            super(view);
            this.sp_e14 = (Spinner)view.findViewById(R.id.sp_e14);
        }
    }
    public static class E15ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e15;

        E15ViewHolder(View view) {
            super(view);
            this.sp_e15 = (Spinner)view.findViewById(R.id.sp_e15);
        }
    }
    public static class E16ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e16;

        E16ViewHolder(View view) {
            super(view);
            this.sp_e16 = (Spinner)view.findViewById(R.id.sp_e16);
        }
    }
    public static class E17ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e17;

        E17ViewHolder(View view) {
            super(view);
            this.sp_e17 = (Spinner)view.findViewById(R.id.sp_e17);
        }
    }
    public static class E18ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e18;

        E18ViewHolder(View view) {
            super(view);
            this.sp_e18 = (Spinner)view.findViewById(R.id.sp_e18);
        }
    }
    public static class E19ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e19;

        E19ViewHolder(View view) {
            super(view);
            this.sp_e19 = (Spinner)view.findViewById(R.id.sp_e19);
        }
    }
    public static class E20ViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_e20;

        E20ViewHolder(View view) {
            super(view);
            this.sp_e20 = (Spinner)view.findViewById(R.id.sp_e20);
        }
    }


}
