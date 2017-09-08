package com.xavey.proto.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xavey.proto.R;
import com.xavey.proto.adapter.EListAdapter;
import com.xavey.proto.adapter.H2ToH16ListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class H2ToH16Fragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @Bind(R.id.h2h16_1)
    RecyclerView h2h16_1;
    @Bind(R.id.h2h16_2)
    RecyclerView h2h16_2;
    @Bind(R.id.h2h16_3)
    RecyclerView h2h16_3;

    private int type = TYPE_LINEAR_LAYOUT;

    public static H2ToH16Fragment newInstance() {
        H2ToH16Fragment fragment = new H2ToH16Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_h2h16, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //if (type == TYPE_GRID_LAYOUT) {
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity());
        h2h16_1.setLayoutManager(linearLayoutManager1);
        h2h16_2.setLayoutManager(linearLayoutManager2);
        h2h16_3.setLayoutManager(linearLayoutManager3);

        h2h16_1.setAdapter(new H2ToH16ListAdapter(getActivity(),1));
        h2h16_2.setAdapter(new H2ToH16ListAdapter(getActivity(),2));
        h2h16_3.setAdapter(new H2ToH16ListAdapter(getActivity(),3));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
