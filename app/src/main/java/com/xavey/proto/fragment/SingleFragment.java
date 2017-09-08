package com.xavey.proto.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.xavey.proto.MainActivity;
import com.xavey.proto.Question175Activity;
import com.xavey.proto.Question178Activity;
import com.xavey.proto.R;
import com.xavey.proto.control.ProtoSpinner;
import com.xavey.proto.helper.AppValues;


import butterknife.ButterKnife;

/**
 * Created by tinmaungaye on 3/20/16.
 */
public class SingleFragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;

    public Context context;
    private int type = TYPE_LINEAR_LAYOUT;



    public static SingleFragment newInstance(int layoutID) {
        SingleFragment fragment = new SingleFragment();
        Bundle args = new Bundle();
        args.putInt("layoutID",layoutID);
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
        View rootView = inflater.inflate(getArguments().getInt("layoutID"), container, false);
        ButterKnife.bind(this, rootView);

        Button button = (Button) rootView.findViewById(R.id.btn_submmit);
        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {
           //     Question175Activity a=new Question175Activity();
                @Override
                public void onClick(View v) {
                 //   ((Question178Activity)getActivity()).doForm(true);
                    if(AppValues.getInstance().getWorkingForm()==175)
                    {((Question175Activity)getActivity()).doForm(true);}

                    else if (AppValues.getInstance().getWorkingForm()==178)
                    {((Question178Activity)getActivity()).doForm(true);}

                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //if (type == TYPE_GRID_LAYOUT) {
        if(view.findViewById(R.id.tv_g1)!=null){
            TextView tv = (TextView)view.findViewById(R.id.tv_g1);
            int count = 0;
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_1_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_2_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_3_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_4_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_5_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_6_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_7_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_8_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_9_a1_b")){
                count++;
            }
            if(AppValues.getInstance().getCurrentRecords().containsKey("a1_10_a1_b")){
                count++;
            }
            tv.setText(String.format(getResources().getString(R.string.dynamic_g1),count));
        }

        if(view.findViewById(R.id.sp_pre_state)!=null && view.findViewById(R.id.sp_pre_village)!=null
                && view.findViewById(R.id.sp_pre_township)!=null) {
            final ProtoSpinner sp_pre_state = (ProtoSpinner) view.findViewById(R.id.sp_pre_state);
            final ProtoSpinner sp_pre_township = (ProtoSpinner) view.findViewById(R.id.sp_pre_township);
            final ProtoSpinner sp_pre_village = (ProtoSpinner) view.findViewById(R.id.sp_pre_village);

            sp_pre_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (sp_pre_state.getSelectedItemPosition() > 0) {
                        if (sp_pre_state.getSelectedItemPosition() == 1) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.township_1, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_township.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 2) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.township_2, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_township.setAdapter(adapter);
                        }
                    }
                    else {
                        sp_pre_township.setAdapter(null);
                    }
                    //recall after override
                    sp_pre_state.OnItemSelected(parent,view,position,id);
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            sp_pre_township.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     if (sp_pre_township.getSelectedItemPosition() > 0 && sp_pre_state.getSelectedItemPosition()>0) {
                        if (sp_pre_state.getSelectedItemPosition() == 1 && sp_pre_township.getSelectedItemPosition() == 1) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_1_1, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 1 && sp_pre_township.getSelectedItemPosition() == 2) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_1_2, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 1 && sp_pre_township.getSelectedItemPosition() == 3) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_1_3, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 1 && sp_pre_township.getSelectedItemPosition() == 4) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_1_4, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        }else if (sp_pre_state.getSelectedItemPosition() == 2 && sp_pre_township.getSelectedItemPosition() == 1) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_2_1, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 2 && sp_pre_township.getSelectedItemPosition() == 2) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_2_2, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 2 && sp_pre_township.getSelectedItemPosition() == 3) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_2_3, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        } else if (sp_pre_state.getSelectedItemPosition() == 2 && sp_pre_township.getSelectedItemPosition() == 4) {
                            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                    getActivity(), R.array.village_2_4, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp_pre_village.setAdapter(adapter);
                        }
                    }
                    else {
                        sp_pre_village.setAdapter(null);
                    }
                    //recall after override
                    sp_pre_township.OnItemSelected(parent,view,position,id);
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
