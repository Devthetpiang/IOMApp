package com.xavey.proto.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xavey.proto.R;
import com.xavey.proto.adapter.A1ListAdapter;
import com.xavey.proto.helper.AppValues;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class A1Fragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    @Bind(R.id.rv_a1_1)
    RecyclerView rv_a1_1;
    @Bind(R.id.rv_a1_2)
    RecyclerView rv_a1_2;
    @Bind(R.id.rv_a1_3)
    RecyclerView rv_a1_3;
    @Bind(R.id.rv_a1_4)
    RecyclerView rv_a1_4;
    @Bind(R.id.rv_a1_5)
    RecyclerView rv_a1_5;
    @Bind(R.id.rv_a1_6)
    RecyclerView rv_a1_6;
    @Bind(R.id.rv_a1_7)
    RecyclerView rv_a1_7;
    @Bind(R.id.rv_a1_8)
    RecyclerView rv_a1_8;
    @Bind(R.id.rv_a1_9)
    RecyclerView rv_a1_9;
    @Bind(R.id.rv_a1_10)
    RecyclerView rv_a1_10;

    @Bind(R.id.tv_a1_1)
    TextView tv_a1_1;
    @Bind(R.id.tv_a1_2)
    TextView tv_a1_2;
    @Bind(R.id.tv_a1_3)
    TextView tv_a1_3;
    @Bind(R.id.tv_a1_4)
    TextView tv_a1_4;
    @Bind(R.id.tv_a1_5)
    TextView tv_a1_5;
    @Bind(R.id.tv_a1_6)
    TextView tv_a1_6;
    @Bind(R.id.tv_a1_7)
    TextView tv_a1_7;
    @Bind(R.id.tv_a1_8)
    TextView tv_a1_8;
    @Bind(R.id.tv_a1_9)
    TextView tv_a1_9;
    @Bind(R.id.tv_a1_10)
    TextView tv_a1_10;
    private int type = TYPE_LINEAR_LAYOUT;

    public static A1Fragment newInstance() {
        A1Fragment fragment = new A1Fragment();
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
        View rootView = inflater.inflate(R.layout.fragment_a1, container, false);
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
        linearLayoutManager7.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(getActivity());
        linearLayoutManager8.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager9 = new LinearLayoutManager(getActivity());
        linearLayoutManager9.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager10 = new LinearLayoutManager(getActivity());
        linearLayoutManager10.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_a1_1.setLayoutManager(linearLayoutManager1);
        rv_a1_2.setLayoutManager(linearLayoutManager2);
        rv_a1_3.setLayoutManager(linearLayoutManager3);
        rv_a1_4.setLayoutManager(linearLayoutManager4);
        rv_a1_5.setLayoutManager(linearLayoutManager5);
        rv_a1_6.setLayoutManager(linearLayoutManager6);
        rv_a1_7.setLayoutManager(linearLayoutManager7);
        rv_a1_8.setLayoutManager(linearLayoutManager8);
        rv_a1_9.setLayoutManager(linearLayoutManager9);
        rv_a1_10.setLayoutManager(linearLayoutManager10);
        //} else if (type == TYPE_STAGGERED_GRID_LAYOUT) {
        //    mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        //} else {
        //    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //}
        rv_a1_1.setAdapter(new A1ListAdapter(getActivity(),1));
        rv_a1_2.setAdapter(new A1ListAdapter(getActivity(),2));
        rv_a1_3.setAdapter(new A1ListAdapter(getActivity(),3));
        rv_a1_4.setAdapter(new A1ListAdapter(getActivity(),4));
        rv_a1_5.setAdapter(new A1ListAdapter(getActivity(),5));
        rv_a1_6.setAdapter(new A1ListAdapter(getActivity(),6));
        rv_a1_7.setAdapter(new A1ListAdapter(getActivity(),7));
        rv_a1_8.setAdapter(new A1ListAdapter(getActivity(),8));
        rv_a1_9.setAdapter(new A1ListAdapter(getActivity(),9));
        rv_a1_10.setAdapter(new A1ListAdapter(getActivity(), 10));

        rv_a1_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_b")) {
                    tv_a1_1.setText(String.format(getResources().getString(R.string.dynamic_line1),
                            AppValues.getInstance().getCurrentRecords().get("a1_1_a1_b")));                }
                return false;
            }
        });

        rv_a1_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (AppValues.getInstance().getCurrentRecords().containsKey("a1_2_a1_b")) {
                    tv_a1_2.setText(String.format(getResources().getString(R.string.dynamic_line2),
                            AppValues.getInstance().getCurrentRecords().get("a1_2_a1_b")));                }
                return false;
            }
        });

        rv_a1_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (AppValues.getInstance().getCurrentRecords().containsKey("a1_3_a1_b")) {
                    tv_a1_3.setText(String.format(getResources().getString(R.string.dynamic_line3),
                            AppValues.getInstance().getCurrentRecords().get("a1_3_a1_b")));                }
                return false;
            }
        });

        rv_a1_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_4_a1_b")) {
                    tv_a1_4.setText(String.format(getResources().getString(R.string.dynamic_line4),
                            AppValues.getInstance().getCurrentRecords().get("a1_4_a1_b")));                }
                return false;
            }
        });

        rv_a1_5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_5_a1_b")) {
                    tv_a1_5.setText(String.format(getResources().getString(R.string.dynamic_line5),
                            AppValues.getInstance().getCurrentRecords().get("a1_5_a1_b")));                }
                return false;
            }
        });

        rv_a1_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_6_a1_b")) {
                    tv_a1_6.setText(String.format(getResources().getString(R.string.dynamic_line6),
                            AppValues.getInstance().getCurrentRecords().get("a1_6_a1_b")));                }
                return false;
            }
        });

        rv_a1_7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_7_a1_b")) {
                    tv_a1_7.setText(String.format(getResources().getString(R.string.dynamic_line7),
                            AppValues.getInstance().getCurrentRecords().get("a1_7_a1_b")));                }
                return false;
            }
        });

        rv_a1_8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_8_a1_b")) {
                    tv_a1_6.setText(String.format(getResources().getString(R.string.dynamic_line6),
                            AppValues.getInstance().getCurrentRecords().get("a1_6_a1_b")));                }
                return false;
            }
        });

        rv_a1_7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_7_a1_b")) {
                    tv_a1_7.setText(String.format(getResources().getString(R.string.dynamic_line7),
                            AppValues.getInstance().getCurrentRecords().get("a1_7_a1_b")));
                }
                return false;
            }
        });

        rv_a1_8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_8_a1_b")) {
                    tv_a1_8.setText(String.format(getResources().getString(R.string.dynamic_line8),
                            AppValues.getInstance().getCurrentRecords().get("a1_8_a1_b")));
                }
                return false;
            }
        });

        rv_a1_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_9_a1_b")) {
                    tv_a1_9.setText(String.format(getResources().getString(R.string.dynamic_line9),
                            AppValues.getInstance().getCurrentRecords().get("a1_9_a1_b")));
                }
                return false;
            }
        });

        rv_a1_10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(AppValues.getInstance().getCurrentRecords().containsKey("a1_10_a1_b")) {
                    tv_a1_10.setText(String.format(getResources().getString(R.string.dynamic_line10),
                            AppValues.getInstance().getCurrentRecords().get("a1_10_a1_b")));
                }
                return false;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
