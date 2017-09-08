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
import com.xavey.proto.adapter.G4ListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class G4Fragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @Bind(R.id.g4_1)
    RecyclerView g4_1;
    @Bind(R.id.g4_2)
    RecyclerView g4_2;
    @Bind(R.id.g4_3)
    RecyclerView g4_3;
    @Bind(R.id.g4_4)
    RecyclerView g4_4;
    @Bind(R.id.g4_5)
    RecyclerView g4_5;
    @Bind(R.id.g4_6)
    RecyclerView g4_6;

    private int type = TYPE_LINEAR_LAYOUT;

    public static G4Fragment newInstance() {
        G4Fragment fragment = new G4Fragment();
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
        View rootView = inflater.inflate(R.layout.fragment_g4, container, false);
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
        linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity());
        linearLayoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(getActivity());
        linearLayoutManager6.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(getActivity());
        g4_1.setLayoutManager(linearLayoutManager1);
        g4_2.setLayoutManager(linearLayoutManager2);
        g4_3.setLayoutManager(linearLayoutManager3);
        g4_4.setLayoutManager(linearLayoutManager4);
        g4_5.setLayoutManager(linearLayoutManager5);
        g4_6.setLayoutManager(linearLayoutManager6);

        g4_1.setAdapter(new G4ListAdapter(getActivity(),1));
        g4_2.setAdapter(new G4ListAdapter(getActivity(),2));
        g4_3.setAdapter(new G4ListAdapter(getActivity(),3));
        g4_4.setAdapter(new G4ListAdapter(getActivity(),4));
        g4_5.setAdapter(new G4ListAdapter(getActivity(),5));
        g4_6.setAdapter(new G4ListAdapter(getActivity(),6));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
