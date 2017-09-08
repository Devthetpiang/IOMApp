package com.xavey.proto.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.helper.AppValues;

import org.w3c.dom.Text;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class A1ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  implements EditText.OnEditorActionListener {
    public enum ITEM_TYPE {a1b, a1c, a1d, a1e, a1f, a1g}
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final int mParentIndex;
    private String[] mTitles;

    TextView  tv_a1_1;
    TextView  tv_a1_2;
    TextView  tv_a1_3;
    TextView  tv_a1_4;
    TextView  tv_a1_5;
    TextView  tv_a1_6;
    TextView  tv_a1_7;
    TextView  tv_a1_8;
    TextView  tv_a1_9;
    TextView  tv_a1_10;

    public A1ListAdapter(Context context,int parentIndex) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        mContext = context;
        mParentIndex = parentIndex;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        //if(AppValues.getInstance().getA1ViewHolders().get(parent.getId() + viewType + ITEM_TYPE.values().length)!=null){
        //    vh = AppValues.getInstance().getA1ViewHolders().get(parent.getId()+viewType);
        //}
        //else{
            if (viewType == ITEM_TYPE.a1b.ordinal()) {
                vh = new a1bViewHolder(mLayoutInflater.inflate(R.layout.card_a1_b, parent, false));
            } else if (viewType == ITEM_TYPE.a1c.ordinal()) {
                vh =  new a1cViewHolder(mLayoutInflater.inflate(R.layout.card_a1_c, parent, false));
            }else if (viewType == ITEM_TYPE.a1d.ordinal()) {
                vh = new a1dViewHolder(mLayoutInflater.inflate(R.layout.card_a1_d, parent, false));
            }else if (viewType == ITEM_TYPE.a1e.ordinal()) {
                vh = new a1eViewHolder(mLayoutInflater.inflate(R.layout.card_a1_e, parent, false));
            }else if (viewType == ITEM_TYPE.a1f.ordinal()) {
                vh = new a1fViewHolder(mLayoutInflater.inflate(R.layout.card_a1_f, parent, false));
            }else if (viewType == ITEM_TYPE.a1g.ordinal()) {
                vh = new a1gViewHolder(mLayoutInflater.inflate(R.layout.card_a1_g, parent, false));
            }else{
                vh = null;
            }
            //AppValues.getInstance().getA1ViewHolders().put(parent.getId()+viewType, vh);
        //}
        vh.setIsRecyclable(false);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof a1bViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_b")) {
                ((a1bViewHolder) holder).et_a1_b.setText(AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_b"));
            }
        } else if (holder instanceof a1cViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_c")) {
                String val = AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_c");
                ((a1cViewHolder) holder).sp_a1_c.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof a1dViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_d")) {
                String val = AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_d");
                ((a1dViewHolder) holder).sp_a1_d.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof a1eViewHolder) {
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_e")) {
                ((a1eViewHolder) holder).et_a1_e.setText(AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_e"));
            }
        }
        else if (holder instanceof a1fViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_f")) {
                String val = AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_f");
                ((a1fViewHolder) holder).sp_a1_f.setSelection(Integer.parseInt(val));
            }
        }
        else if (holder instanceof a1gViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("a1_"+String.valueOf(mParentIndex)+"_a1_g")) {
                String val = AppValues.getInstance().getCurrentRecords().get("a1_"+String.valueOf(mParentIndex)+"_a1_g");
                ((a1gViewHolder) holder).sp_a1_g.setSelection(Integer.parseInt(val));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return ITEM_TYPE.a1b.ordinal();
            case 1:
                return ITEM_TYPE.a1c.ordinal();
            case 2:
                return ITEM_TYPE.a1d.ordinal();
            case 3:
                return ITEM_TYPE.a1e.ordinal();
            case 4:
                return ITEM_TYPE.a1f.ordinal();
            case 5:
                return ITEM_TYPE.a1g.ordinal();
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class a1bViewHolder extends RecyclerView.ViewHolder {
        EditText et_a1_b;

        a1bViewHolder(View view) {
            super(view);
            et_a1_b = (EditText)view.findViewById(R.id.et_a1_b);
           }
    }
    public static class a1cViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_a1_c;
        a1cViewHolder(View view) {
            super(view);
            sp_a1_c=(Spinner)view.findViewById(R.id.sp_a1_c);
        }
    }
    public static class a1dViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_a1_d;
        a1dViewHolder(View view) {
            super(view);
            sp_a1_d=(Spinner)view.findViewById(R.id.sp_a1_d);
        }
    }
    public static class a1eViewHolder extends RecyclerView.ViewHolder {
        EditText et_a1_e;
        a1eViewHolder(View view) {
            super(view);
            et_a1_e=(EditText)view.findViewById(R.id.et_a1_e);
        }
    }
    public static class a1fViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_a1_f;
        a1fViewHolder(View view) {
            super(view);
            sp_a1_f=(Spinner)view.findViewById(R.id.sp_a1_f);
        }
    }
    public static class a1gViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_a1_g;
        a1gViewHolder(View view) {
            super(view);
            sp_a1_g=(Spinner)view.findViewById(R.id.sp_a1_g);
        }
    }


    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Log.d("a", "a");
        return false;
    }

}
