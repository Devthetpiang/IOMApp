package com.xavey.proto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xavey.proto.MainActivity;
import com.xavey.proto.R;
import com.xavey.proto.api.model.SyncStatus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 5/8/15.
 */
public class RecordAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<SyncStatus> mSSs;
    private LayoutInflater mInflater;

    public RecordAdapter(Collection<SyncStatus> ss, Context context) {
        this.mSSs = new ArrayList<SyncStatus>(ss);
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return mSSs == null ? 0 : mSSs.size();
    }

    public List<SyncStatus> getItems() {
        return mSSs;
    }

    public SyncStatus getItem(int position) {
        return mSSs == null ? null : mSSs.get(position);
    }

    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        final SyncStatus ss = mSSs.get(position);
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.item_dashboard, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        if(ss.getSynced()){
            holder.btnSync.setVisibility(View.GONE);
        }

        holder.tvCount.setText(String.valueOf(ss.getTotalCount()) + " Interviews,");
        //holder.tvStatus.setText(ss.getSynced()? "Uploaded" : "Un-uploaded,");
        holder.tvGroup.setText(ss.getGroup());

        holder.btnSync.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        syncData(ss.getGroup());
                    }

                }
        );

        return view;
    }

    private void syncData(String group){
        if(group.toLowerCase().equals("completed")){
            ((MainActivity)mContext).SyncDocs(false, true);
        }
        else{
            ((MainActivity)mContext).SyncDocs(false,false);
        }
    }

    static class ViewHolder{
        @Bind(R.id.tvCount)
        TextView tvCount;
        @Bind(R.id.tvStatus)
        TextView tvStatus;
        @Bind(R.id.tvGroup)
        TextView tvGroup;
        @Bind(R.id.btnSync)
        Button btnSync;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }

    }
}
