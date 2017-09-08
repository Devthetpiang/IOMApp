package com.xavey.proto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
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
public class G4ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public enum ITEM_TYPE {g4a,g4a1,g4a2,g4b,g4c,g4d,
        g4e,g4f,g4g,g4h,g4i,g4j,g4k,g4l,g4m,g4ma,g4mb,g4mc,g4md,
        g4n,g4o,g4p,g4q,g4r,g4s,g4sa,g4sb,g4sc};

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final int mParentIndex;

    private String[] mTitles;

    public G4ListAdapter(Context context, int parentIndex) {
        mTitles = context.getResources().getStringArray(R.array.G4_Titles);
        mContext = context;
        mParentIndex = parentIndex;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.g4a.ordinal()) {
            return new G4AViewHolder(mLayoutInflater.inflate(R.layout.card_g4_a, parent, false));
        } else if (viewType == ITEM_TYPE.g4a1.ordinal()) {
            return new G4A1ViewHolder(mLayoutInflater.inflate(R.layout.card_g4_a1, parent, false));
        }else if (viewType == ITEM_TYPE.g4a2.ordinal()) {
            return new G4A2ViewHolder(mLayoutInflater.inflate(R.layout.card_g4_a2, parent, false));
        }else if (viewType == ITEM_TYPE.g4b.ordinal()) {
            return new G4BViewHolder(mLayoutInflater.inflate(R.layout.card_g4_b, parent, false));
        }else if (viewType == ITEM_TYPE.g4c.ordinal()) {
            return new G4CViewHolder(mLayoutInflater.inflate(R.layout.card_g4_c, parent, false));
        }else if (viewType == ITEM_TYPE.g4d.ordinal()) {
            return new G4DViewHolder(mLayoutInflater.inflate(R.layout.card_g4_d, parent, false));
        }else if (viewType == ITEM_TYPE.g4e.ordinal()) {
            return new G4EViewHolder(mLayoutInflater.inflate(R.layout.card_g4_e, parent, false));
        }else if (viewType == ITEM_TYPE.g4f.ordinal()) {
            return new G4FViewHolder(mLayoutInflater.inflate(R.layout.card_g4_f, parent, false));
        }else if (viewType == ITEM_TYPE.g4g.ordinal()) {
            return new G4GViewHolder(mLayoutInflater.inflate(R.layout.card_g4_g, parent, false));
        }else if (viewType == ITEM_TYPE.g4h.ordinal()) {
            return new G4HViewHolder(mLayoutInflater.inflate(R.layout.card_g4_h, parent, false));
        }else if (viewType == ITEM_TYPE.g4i.ordinal()) {
            return new G4IViewHolder(mLayoutInflater.inflate(R.layout.card_g4_i, parent, false));
        }else if (viewType == ITEM_TYPE.g4j.ordinal()) {
            return new G4JViewHolder(mLayoutInflater.inflate(R.layout.card_g4_j, parent, false));
        }else if (viewType == ITEM_TYPE.g4k.ordinal()) {
            return new G4KViewHolder(mLayoutInflater.inflate(R.layout.card_g4_k, parent, false));
        }else if (viewType == ITEM_TYPE.g4l.ordinal()) {
            return new G4LViewHolder(mLayoutInflater.inflate(R.layout.card_g4_l, parent, false));
        }else if (viewType == ITEM_TYPE.g4m.ordinal()) {
            return new G4MViewHolder(mLayoutInflater.inflate(R.layout.card_g4_m, parent, false));
        }else if (viewType == ITEM_TYPE.g4ma.ordinal()) {
            return new G4MAViewHolder(mLayoutInflater.inflate(R.layout.card_g4_m_a, parent, false));
        }else if (viewType == ITEM_TYPE.g4mb.ordinal()) {
            return new G4MBViewHolder(mLayoutInflater.inflate(R.layout.card_g4_m_b, parent, false));
        }else if (viewType == ITEM_TYPE.g4mc.ordinal()) {
            return new G4MCViewHolder(mLayoutInflater.inflate(R.layout.card_g4_m_c, parent, false));
        }else if (viewType == ITEM_TYPE.g4md.ordinal()) {
            return new G4MDViewHolder(mLayoutInflater.inflate(R.layout.card_g4_m_d, parent, false));
        }else if (viewType == ITEM_TYPE.g4n.ordinal()) {
            return new G4NViewHolder(mLayoutInflater.inflate(R.layout.card_g4_n, parent, false));
        }else if (viewType == ITEM_TYPE.g4o.ordinal()) {
            return new G4OViewHolder(mLayoutInflater.inflate(R.layout.card_g4_o, parent, false));
        }else if (viewType == ITEM_TYPE.g4p.ordinal()) {
            return new G4PViewHolder(mLayoutInflater.inflate(R.layout.card_g4_p, parent, false));
        }else if (viewType == ITEM_TYPE.g4q.ordinal()) {
            return new G4QViewHolder(mLayoutInflater.inflate(R.layout.card_g4_q, parent, false));
        }else if (viewType == ITEM_TYPE.g4r.ordinal()) {
            return new G4RViewHolder(mLayoutInflater.inflate(R.layout.card_g4_r, parent, false));
        }else if (viewType == ITEM_TYPE.g4s.ordinal()) {
            return new G4SViewHolder(mLayoutInflater.inflate(R.layout.card_g4_s, parent, false));
        }else if (viewType == ITEM_TYPE.g4sa.ordinal()) {
            return new G4SAViewHolder(mLayoutInflater.inflate(R.layout.card_g4_s_a, parent, false));
        }else if (viewType == ITEM_TYPE.g4sb.ordinal()) {
            return new G4SBViewHolder(mLayoutInflater.inflate(R.layout.card_g4_s_b, parent, false));
        }else if (viewType == ITEM_TYPE.g4sc.ordinal()) {
            return new G4SCViewHolder(mLayoutInflater.inflate(R.layout.card_g4_s_c, parent, false));
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof G4AViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_a")) {
                ((G4AViewHolder) holder).et_g4_a.setText(AppValues.getInstance().getCurrentRecords().get("g4_" + String.valueOf(mParentIndex) + "_g4_a"));
            }
        }else if (holder instanceof G4A1ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_a_1")) {
                ((G4A1ViewHolder) holder).et_g4_a_1.setText(AppValues.getInstance().getCurrentRecords().get("g4_" + String.valueOf(mParentIndex) + "_g4_a_1"));
            }
        }else if (holder instanceof G4A2ViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_a_2")) {
                ((G4A2ViewHolder) holder).et_g4_a_2.setText(AppValues.getInstance().getCurrentRecords().get("g4_" + String.valueOf(mParentIndex) + "_g4_a_2"));
            }
        }else if (holder instanceof G4BViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_b")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_b");
                ((G4BViewHolder) holder).sp_g4_b.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4CViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_c")) {
                ((G4CViewHolder) holder).et_g4_c.setText(AppValues.getInstance().getCurrentRecords().get("g4_" + String.valueOf(mParentIndex) + "_g4_c"));
            }
        }else if (holder instanceof G4DViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_d")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_d");
                ((G4DViewHolder) holder).sp_g4_d.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4EViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_e")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_e");
                ((G4EViewHolder) holder).sp_g4_e.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4FViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_f")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_f");
                ((G4FViewHolder) holder).sp_g4_f.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4GViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_g")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_g");
                ((G4GViewHolder) holder).sp_g4_g.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4HViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_h")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_h");
                ((G4HViewHolder) holder).sp_g4_h.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4IViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_i")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_i");
                ((G4IViewHolder) holder).sp_g4_i.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4JViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_j")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_j");
                ((G4JViewHolder) holder).sp_g4_j.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4KViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_k")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_k");
                ((G4KViewHolder) holder).sp_g4_k.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4LViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_l")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_l");
                ((G4LViewHolder) holder).sp_g4_l.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4MAViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_m_a")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_m_a");
                ((G4MAViewHolder) holder).sp_g4_m_a.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4MBViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_m_b")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_m_b");
                ((G4MBViewHolder) holder).sp_g4_m_b.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4MCViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_m_c")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_m_c");
                ((G4MCViewHolder) holder).sp_g4_m_c.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4MDViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_m_d")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_m_d");
                ((G4MDViewHolder) holder).sp_g4_m_d.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4NViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_n")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_n");
                ((G4NViewHolder) holder).sp_g4_n.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4OViewHolder) {
        if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_o")) {
            String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_o");
            ((G4OViewHolder) holder).sp_g4_o.setSelection(Integer.parseInt(val));
        }
        }else if (holder instanceof G4PViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_p")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_p");
                ((G4PViewHolder) holder).sp_g4_p.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4QViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_q")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_q");
                ((G4QViewHolder) holder).sp_g4_q.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4RViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_r")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_r");
                ((G4RViewHolder) holder).sp_g4_r.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4SAViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_s_a")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_s_a");
                ((G4SAViewHolder) holder).sp_g4_s_a.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4SBViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_s_b")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_s_b");
                ((G4SBViewHolder) holder).sp_g4_s_b.setSelection(Integer.parseInt(val));
            }
        }else if (holder instanceof G4SCViewHolder) {
            if (AppValues.getInstance().getCurrentRecords().containsKey("g4_"+String.valueOf(mParentIndex)+"_g4_s_c")) {
                String val = AppValues.getInstance().getCurrentRecords().get("g4_"+String.valueOf(mParentIndex)+"_g4_s_c");
                ((G4SCViewHolder) holder).sp_g4_s_c.setSelection(Integer.parseInt(val));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return ITEM_TYPE.g4a.ordinal();
            case 1:
                return ITEM_TYPE.g4a1.ordinal();
            case 2:
                return ITEM_TYPE.g4a2.ordinal();
            case 3:
                return ITEM_TYPE.g4b.ordinal();
            case 4:
                return ITEM_TYPE.g4c.ordinal();
            case 5:
                return ITEM_TYPE.g4d.ordinal();
            case 6:
                return ITEM_TYPE.g4e.ordinal();
            case 7:
                return ITEM_TYPE.g4f.ordinal();
            case 8:
                return ITEM_TYPE.g4g.ordinal();
            case 9:
                return ITEM_TYPE.g4h.ordinal();
            case 10:
                return ITEM_TYPE.g4i.ordinal();
            case 11:
                return ITEM_TYPE.g4j.ordinal();
            case 12:
                return ITEM_TYPE.g4k.ordinal();
            case 13:
                return ITEM_TYPE.g4l.ordinal();
            case 14:
                return ITEM_TYPE.g4m.ordinal();
            case 15:
                return ITEM_TYPE.g4ma.ordinal();
            case 16:
                return ITEM_TYPE.g4mb.ordinal();
            case 17:
                return ITEM_TYPE.g4mc.ordinal();
            case 18:
                return ITEM_TYPE.g4md.ordinal();
            case 19:
                return ITEM_TYPE.g4n.ordinal();
            case 20:
                return ITEM_TYPE.g4o.ordinal();
            case 21:
                return ITEM_TYPE.g4p.ordinal();
            case 22:
                return ITEM_TYPE.g4q.ordinal();
            case 23:
                return ITEM_TYPE.g4r.ordinal();
            case 24:
                return ITEM_TYPE.g4s.ordinal();
            case 25:
                return ITEM_TYPE.g4sa.ordinal();
            case 26:
                return ITEM_TYPE.g4sb.ordinal();
            case 27:
                return ITEM_TYPE.g4sc.ordinal();
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class G4AViewHolder extends RecyclerView.ViewHolder {
        EditText et_g4_a;

        G4AViewHolder(View view) {
            super(view);
            this.et_g4_a = (EditText)view.findViewById(R.id.et_g4_a);
        }
    }
    public static class G4A1ViewHolder extends RecyclerView.ViewHolder {
        EditText et_g4_a_1;

        G4A1ViewHolder(View view) {
            super(view);
            this.et_g4_a_1 = (EditText)view.findViewById(R.id.et_g4_a1);
        }
    }
    public static class G4A2ViewHolder extends RecyclerView.ViewHolder {
        EditText et_g4_a_2;

        G4A2ViewHolder(View view) {
            super(view);
            this.et_g4_a_2 = (EditText)view.findViewById(R.id.et_g4_a2);
        }
    }
    public static class G4BViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_b;

        G4BViewHolder(View view) {
            super(view);
            this.sp_g4_b = (Spinner)view.findViewById(R.id.sp_g4_b);
        }
    }
    public static class G4CViewHolder extends RecyclerView.ViewHolder {
        EditText et_g4_c;

        G4CViewHolder(View view) {
            super(view);
            this.et_g4_c = (EditText)view.findViewById(R.id.et_g4_c);
        }
    }
    public static class G4DViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_d;

        G4DViewHolder(View view) {
            super(view);
            this.sp_g4_d = (Spinner)view.findViewById(R.id.sp_g4_d);
        }
    }
    public static class G4EViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_e;

        G4EViewHolder(View view) {
            super(view);
            this.sp_g4_e = (Spinner)view.findViewById(R.id.sp_g4_e);
        }
    }
    public static class G4FViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_f;

        G4FViewHolder(View view) {
            super(view);
            this.sp_g4_f = (Spinner)view.findViewById(R.id.sp_g4_f);
        }
    }
    public static class G4GViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_g;

        G4GViewHolder(View view) {
            super(view);
            this.sp_g4_g = (Spinner)view.findViewById(R.id.sp_g4_g);
        }
    }
    public static class G4HViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_h;

        G4HViewHolder(View view) {
            super(view);
            this.sp_g4_h = (Spinner)view.findViewById(R.id.sp_g4_h);
        }
    }

    public static class G4IViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_i;

        G4IViewHolder(View view) {
            super(view);
            this.sp_g4_i = (Spinner)view.findViewById(R.id.sp_g4_i);
        }
    }
    public static class G4JViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_j;

        G4JViewHolder(View view) {
            super(view);
            this.sp_g4_j = (Spinner)view.findViewById(R.id.sp_g4_j);
        }
    }
    public static class G4KViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_k;

        G4KViewHolder(View view) {
            super(view);
            this.sp_g4_k = (Spinner)view.findViewById(R.id.sp_g4_k);
        }
    }
    public static class G4LViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_l;

        G4LViewHolder(View view) {
            super(view);
            this.sp_g4_l = (Spinner)view.findViewById(R.id.sp_g4_l);
        }
    }
    public static class G4MViewHolder extends RecyclerView.ViewHolder {

        G4MViewHolder(View view) {
            super(view);
        }
    }
    public static class G4MAViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_m_a;

        G4MAViewHolder(View view) {
            super(view);
            this.sp_g4_m_a = (Spinner)view.findViewById(R.id.sp_g4_m_a);
        }
    }
    public static class G4MBViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_m_b;

        G4MBViewHolder(View view) {
            super(view);
            this.sp_g4_m_b = (Spinner)view.findViewById(R.id.sp_g4_m_b);
        }
    }
    public static class G4MCViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_m_c;

        G4MCViewHolder(View view) {
            super(view);
            this.sp_g4_m_c = (Spinner)view.findViewById(R.id.sp_g4_m_c);
        }
    }
    public static class G4MDViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_m_d;

        G4MDViewHolder(View view) {
            super(view);
            this.sp_g4_m_d = (Spinner)view.findViewById(R.id.sp_g4_m_d);
        }
    }
    public static class G4NViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_n;

        G4NViewHolder(View view) {
            super(view);
            this.sp_g4_n = (Spinner)view.findViewById(R.id.sp_g4_n);
        }
    }
    public static class G4OViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_o;

        G4OViewHolder(View view) {
            super(view);
            this.sp_g4_o = (Spinner)view.findViewById(R.id.sp_g4_o);
        }
    }
    public static class G4PViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_p;

        G4PViewHolder(View view) {
            super(view);
            this.sp_g4_p = (Spinner)view.findViewById(R.id.sp_g4_p);
        }

    }
    public static class G4QViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_q;


        G4QViewHolder(View view) {
            super(view);
            this.sp_g4_q = (Spinner)view.findViewById(R.id.sp_g4_q);

        }
    }
    public static class G4RViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_r;


        G4RViewHolder(View view) {
            super(view);
            this.sp_g4_r = (Spinner)view.findViewById(R.id.sp_g4_r);
        }
    }
    public static class G4SViewHolder extends RecyclerView.ViewHolder {

        G4SViewHolder(View view) {
            super(view);
        }
    }
    public static class G4SAViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_s_a;

        G4SAViewHolder(View view) {
            super(view);
            this.sp_g4_s_a = (Spinner)view.findViewById(R.id.sp_g4_s_a);
        }
    }
    public static class G4SBViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_s_b;

        G4SBViewHolder(View view) {
            super(view);
            this.sp_g4_s_b = (Spinner)view.findViewById(R.id.sp_g4_s_b);
        }
    }
    public static class G4SCViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_g4_s_c;

        G4SCViewHolder(View view) {
            super(view);
            this.sp_g4_s_c = (Spinner)view.findViewById(R.id.sp_g4_s_c);
        }
    }

}
