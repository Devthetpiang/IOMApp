package com.xavey.proto.fragment;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.adapter.EListAdapter;
import com.xavey.proto.helper.AppValues;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class EFragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @Bind(R.id.tv_e)
    TextView tv_e;
    @Bind(R.id.rv_e_1)
    RecyclerView e_1;
    @Bind(R.id.rv_e_2)
    RecyclerView e_2;
    @Bind(R.id.rv_e_3)
    RecyclerView e_3;
    @Bind(R.id.rv_e_4)
    RecyclerView e_4;
    @Bind(R.id.rv_e_5)
    RecyclerView e_5;
    @Bind(R.id.rv_e_6)
    RecyclerView e_6;
    @Bind(R.id.rv_e_7)
    RecyclerView e_7;
    @Bind(R.id.rv_e_8)
    RecyclerView e_8;
    @Bind(R.id.rv_e_9)
    RecyclerView e_9;
    @Bind(R.id.rv_e_10)
    RecyclerView e_10;
    @Bind(R.id.rv_e_11)
    RecyclerView e_11;
    @Bind(R.id.rv_e_12)
    RecyclerView e_12;
    @Bind(R.id.rv_e_13)
    RecyclerView e_13;

    @Bind(R.id.tv_e_1)
    TextView tv_e_1;
    @Bind(R.id.tv_e_2)
    TextView tv_e_2;
    @Bind(R.id.tv_e_3)
    TextView tv_e_3;
    @Bind(R.id.tv_e_4)
    TextView tv_e_4;
    @Bind(R.id.tv_e_5)
    TextView tv_e_5;
    @Bind(R.id.tv_e_6)
    TextView tv_e_6;
    @Bind(R.id.tv_e_7)
    TextView tv_e_7;
    @Bind(R.id.tv_e_8)
    TextView tv_e_8;
    @Bind(R.id.tv_e_9)
    TextView tv_e_9;
    @Bind(R.id.tv_e_10)
    TextView tv_e_10;
    @Bind(R.id.tv_e_11)
    TextView tv_e_11;
    @Bind(R.id.tv_e_12)
    TextView tv_e_12;
    @Bind(R.id.tv_e_13)
    TextView tv_e_13;

    private int type = TYPE_LINEAR_LAYOUT;

    public static EFragment newInstance() {
        EFragment fragment = new EFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_e, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //if (type == TYPE_GRID_LAYOUT) {

        int count = 0;
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_1_1")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_1_1"));
        }
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_1_2")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_1_2"));
        }
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_2_1")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_2_1"));
        }
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_2_2")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_2_2"));
        }
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_3_1")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_3_1"));
        }
        if(AppValues.getInstance().getCurrentRecords().containsKey("b12_3_2")){
            count += Integer.parseInt(AppValues.getInstance().getCurrentRecords().get("b12_3_2"));
        }

        tv_e.setText(String.format(getResources().getString(R.string.dynamic_e),count));

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
        linearLayoutManager7.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(getActivity());
        linearLayoutManager8.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager9 = new LinearLayoutManager(getActivity());
        linearLayoutManager9.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager10 = new LinearLayoutManager(getActivity());
        linearLayoutManager10.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager11 = new LinearLayoutManager(getActivity());
        linearLayoutManager11.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager12 = new LinearLayoutManager(getActivity());
        linearLayoutManager12.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager13 = new LinearLayoutManager(getActivity());
        linearLayoutManager13.setOrientation(LinearLayoutManager.HORIZONTAL);
        e_1.setLayoutManager(linearLayoutManager1);
        e_2.setLayoutManager(linearLayoutManager2);
        e_3.setLayoutManager(linearLayoutManager3);
        e_4.setLayoutManager(linearLayoutManager4);
        e_5.setLayoutManager(linearLayoutManager5);
        e_6.setLayoutManager(linearLayoutManager6);
        e_7.setLayoutManager(linearLayoutManager7);
        e_8.setLayoutManager(linearLayoutManager8);
        e_9.setLayoutManager(linearLayoutManager9);
        e_10.setLayoutManager(linearLayoutManager10);
        e_11.setLayoutManager(linearLayoutManager11);
        e_12.setLayoutManager(linearLayoutManager12);
        e_13.setLayoutManager(linearLayoutManager13);
        //} else if (type == TYPE_STAGGERED_GRID_LAYOUT) {
        //    mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        //} else {
        //    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //}
        e_1.setAdapter(new EListAdapter(getActivity(),1));
        e_2.setAdapter(new EListAdapter(getActivity(),2));
        e_3.setAdapter(new EListAdapter(getActivity(),3));
        e_4.setAdapter(new EListAdapter(getActivity(),4));
        e_5.setAdapter(new EListAdapter(getActivity(),5));
        e_6.setAdapter(new EListAdapter(getActivity(),6));
        e_7.setAdapter(new EListAdapter(getActivity(),7));
        e_8.setAdapter(new EListAdapter(getActivity(),8));
        e_9.setAdapter(new EListAdapter(getActivity(),9));
        e_10.setAdapter(new EListAdapter(getActivity(),10));
        e_11.setAdapter(new EListAdapter(getActivity(), 11));
        e_12.setAdapter(new EListAdapter(getActivity(), 12));
        e_13.setAdapter(new EListAdapter(getActivity(), 13));

        e_1.addOnScrollListener(onScrollListener);
        e_2.addOnScrollListener(onScrollListener);
        e_3.addOnScrollListener(onScrollListener);
        e_4.addOnScrollListener(onScrollListener);
        e_5.addOnScrollListener(onScrollListener);
        e_6.addOnScrollListener(onScrollListener);
        e_7.addOnScrollListener(onScrollListener);
        e_8.addOnScrollListener(onScrollListener);
        e_9.addOnScrollListener(onScrollListener);
        e_10.addOnScrollListener(onScrollListener);
        e_11.addOnScrollListener(onScrollListener);
        e_12.addOnScrollListener(onScrollListener);
        e_13.addOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView,
                               int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (AppValues.getInstance().getCurrentRecords().containsKey("e_1_e2")) {
                tv_e_1.setText(String.format(getResources().getString(R.string.dynamic_line1),
                        AppValues.getInstance().getCurrentRecords().get("e_1_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_2_e2")) {
                tv_e_2.setText(String.format(getResources().getString(R.string.dynamic_line2),
                        AppValues.getInstance().getCurrentRecords().get("e_2_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_3_e2")) {
                tv_e_3.setText(String.format(getResources().getString(R.string.dynamic_line3),
                        AppValues.getInstance().getCurrentRecords().get("e_3_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_4_e2")) {
                tv_e_4.setText(String.format(getResources().getString(R.string.dynamic_line4),
                        AppValues.getInstance().getCurrentRecords().get("e_4_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_5_e2")) {
                tv_e_5.setText(String.format(getResources().getString(R.string.dynamic_line5),
                        AppValues.getInstance().getCurrentRecords().get("e_5_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_6_e2")) {
                tv_e_6.setText(String.format(getResources().getString(R.string.dynamic_line6),
                        AppValues.getInstance().getCurrentRecords().get("e_6_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_7_e2")) {
                tv_e_7.setText(String.format(getResources().getString(R.string.dynamic_line7),
                        AppValues.getInstance().getCurrentRecords().get("e_7_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_8_e2")) {
                tv_e_8.setText(String.format(getResources().getString(R.string.dynamic_line8),
                        AppValues.getInstance().getCurrentRecords().get("e_8_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_9_e2")) {
                tv_e_9.setText(String.format(getResources().getString(R.string.dynamic_line9),
                        AppValues.getInstance().getCurrentRecords().get("e_9_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_10_e2")) {
                tv_e_10.setText(String.format(getResources().getString(R.string.dynamic_line10),
                        AppValues.getInstance().getCurrentRecords().get("e_10_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_11_e2")) {
                tv_e_11.setText(String.format(getResources().getString(R.string.dynamic_line11),
                        AppValues.getInstance().getCurrentRecords().get("e_11_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_12_e2")) {
                tv_e_12.setText(String.format(getResources().getString(R.string.dynamic_line12),
                        AppValues.getInstance().getCurrentRecords().get("e_12_e2")));
            }
            if (AppValues.getInstance().getCurrentRecords().containsKey("e_13_e2")) {
                tv_e_13.setText(String.format(getResources().getString(R.string.dynamic_line13),
                        AppValues.getInstance().getCurrentRecords().get("e_13_e2")));
            }

            String sp = AppValues.getInstance().getCurrentRecords().get(recyclerView.getResources().getResourceEntryName(recyclerView.getId()) + "_e6");
            if(sp!=null && (Integer.parseInt(sp)==2|| Integer.parseInt(sp)==3)){
                if(recyclerView.findViewById(R.id.et_e7) != null) {
                    recyclerView.findViewById(R.id.et_e7).setEnabled(false);
                }
                if(recyclerView.findViewById(R.id.sp_e8) != null) {
                    recyclerView.findViewById(R.id.sp_e8).setEnabled(true);
                }
            }
            else if(sp!=null && (Integer.parseInt(sp)==4 || Integer.parseInt(sp)==5 || Integer.parseInt(sp)==6
                    || Integer.parseInt(sp)==7 || Integer.parseInt(sp)==8 ||Integer.parseInt(sp)==9)){
                if(recyclerView.findViewById(R.id.et_e7) != null) {
                    recyclerView.findViewById(R.id.et_e7).setEnabled(false);
                }
                if(recyclerView.findViewById(R.id.sp_e8) != null) {
                    recyclerView.findViewById(R.id.sp_e8).setEnabled(false);
                }
            }
            else{
                if(recyclerView.findViewById(R.id.et_e7) != null) {
                    recyclerView.findViewById(R.id.et_e7).setEnabled(true);
                }
                if(recyclerView.findViewById(R.id.sp_e8) != null) {
                    recyclerView.findViewById(R.id.sp_e8).setEnabled(true);
                }
            }

            String e5 = AppValues.getInstance().getCurrentRecords().get(recyclerView.getResources().getResourceEntryName(recyclerView.getId()) + "_e5");
            if(e5!=null){
                if(Integer.parseInt(e5) > 14){
                    if(recyclerView.findViewById(R.id.sp_e12) != null) {
                        recyclerView.findViewById(R.id.sp_e12).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.et_e13) != null) {
                        recyclerView.findViewById(R.id.et_e13).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e14) != null) {
                        recyclerView.findViewById(R.id.sp_e14).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e15) != null) {
                        recyclerView.findViewById(R.id.sp_e15).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e16) != null) {
                        recyclerView.findViewById(R.id.sp_e16).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e17) != null) {
                        recyclerView.findViewById(R.id.sp_e17).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e18) != null) {
                        recyclerView.findViewById(R.id.sp_e18).setEnabled(true);
                    }
                    if(recyclerView.findViewById(R.id.sp_e19) != null) {
                        recyclerView.findViewById(R.id.sp_e19).setEnabled(true);
                    }
                }
                else{
                    if(recyclerView.findViewById(R.id.sp_e12) != null) {
                        recyclerView.findViewById(R.id.sp_e12).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.et_e13) != null) {
                        recyclerView.findViewById(R.id.et_e13).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e14) != null) {
                        recyclerView.findViewById(R.id.sp_e14).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e15) != null) {
                        recyclerView.findViewById(R.id.sp_e15).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e16) != null) {
                        recyclerView.findViewById(R.id.sp_e16).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e17) != null) {
                        recyclerView.findViewById(R.id.sp_e17).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e18) != null) {
                        recyclerView.findViewById(R.id.sp_e18).setEnabled(false);
                    }
                    if(recyclerView.findViewById(R.id.sp_e19) != null) {
                        recyclerView.findViewById(R.id.sp_e19).setEnabled(false);
                    }
                }
            }

        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
