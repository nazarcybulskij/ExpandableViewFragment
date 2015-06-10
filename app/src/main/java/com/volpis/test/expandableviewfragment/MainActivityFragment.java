package com.volpis.test.expandableviewfragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.expandablelayout.library.ExpandableLayout;
import com.google.gson.Gson;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import model.Response;
import view.MyGridView;
import view.TableTowNorm;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    @InjectView(R.id.info)
    ExpandableLayout mELInfo;
    @InjectView(R.id.textview_header_info)
    TextView mTVInfo;

    @InjectView(R.id.gridview_men_age)
    GridView mGVMenAge;
    @InjectView(R.id.gridview_woman_age)
    GridView mGVWomanAge;
    @InjectView(R.id.gridview_schoolboy_age)
    GridView mGVSchoolbouAge;

    String[] data = {"a", "b", "c", "d", "e","f"};
    ArrayAdapter<String> adapter;

    @InjectView(R.id.table)
    LinearLayout table;

    LayoutInflater mInflater;






    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ButterKnife.inject(getActivity());
        //return inflater.inflate(R.layout.fragment_main, container, false);
        mInflater = inflater;

        View view = mInflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, view);

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_age, R.id.tvText, data);
        mGVMenAge.setAdapter(adapter);
        mGVWomanAge.setAdapter(adapter);
        mGVSchoolbouAge.setAdapter(adapter);
        return view;


    }

    @OnClick(R.id.info)
    public void infoclicked(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Title");
        alertDialog.setMessage("Here is a really long message.");
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    @OnClick(R.id.textview_header_info)
    public void infoTVclicked(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Title");
        alertDialog.setMessage("Here is a really long message.");
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    int mIntCurrentPosution_age= 0;

    @OnItemClick(R.id.gridview_men_age)
    void onItemSelected(int position) {
        Toast.makeText(getActivity(),""+position,Toast.LENGTH_SHORT).show();
        final FrameLayout parent = (FrameLayout)mGVMenAge.getParent().getParent();
        if (mIntCurrentPosution_age == position) {
            parent.performClick();
            createTable();
//            table.setText(mIntCurrentPosution_age + "");
        }else{
            parent.performClick();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    table.setText(mIntCurrentPosution_age+"");
                    createTable();
                    parent.performClick();
                }
            },500);


        }




        mIntCurrentPosution_age=position;

    }

     public  void createTable(){

         table.removeAllViews();
         //TableRow tr=new TableRow(getActivity());
         //View view = mInflater.inflate(R.layout.item_age, null, false);

         // btnTag.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
         //btnTag.setText("Button ");
         //tr.addView(view);


         //table.addView(tr);

         createCompetisionRow();





     }


    public  void createCompetisionRow(){

        Gson gson = new Gson();
        Response response = gson.fromJson( responsestr, Response.class );

        TableRow tr=new TableRow(getActivity());
        TableTowNorm rowview=new TableTowNorm(getActivity(),response.getList_competisions().get(0));

        //tr.addView(rowview);

        table.addView(rowview);





    }




    String responsestr ="{\n" +
            "  \"all_competisions\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"competisions\": [\n" +
            "        {\n" +
            "          \"name\": \"Run\",\n" +
            "          \"vik1\": [\n" +
            "            15,\n" +
            "            16,\n" +
            "            17\n" +
            "          ],\n" +
            "          \"vik2\": [\n" +
            "            16,\n" +
            "            17,\n" +
            "            18\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"competisions\": [\n" +
            "        {\n" +
            "          \"name\": \"Jump\",\n" +
            "          \"vik1\": [\n" +
            "            220,\n" +
            "            225,\n" +
            "            235\n" +
            "          ],\n" +
            "          \"vik2\": [\n" +
            "            210,\n" +
            "            215,\n" +
            "            225\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"competisions\": [\n" +
            "        {\n" +
            "          \"name\": \"Pidtjaguvannja\",\n" +
            "          \"vik1\": [\n" +
            "            220,\n" +
            "            235,\n" +
            "            225\n" +
            "          ],\n" +
            "          \"vik2\": [\n" +
            "            210,\n" +
            "            215,\n" +
            "            225\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Or ryvok giri\",\n" +
            "          \"vik1\": [\n" +
            "            20,\n" +
            "            30,\n" +
            "            40\n" +
            "          ],\n" +
            "          \"vik2\": [\n" +
            "            20,\n" +
            "            30,\n" +
            "            40\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4,\n" +
            "      \"competisions\": [\n" +
            "        {\n" +
            "          \"name\": \"Turist pohod\",\n" +
            "          \"vik1\": null,\n" +
            "          \"vik2\": null,\n" +
            "          \"description\": \"V sootvetstv s trebovanijami\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"count_in_age_category\": {\n" +
            "    \"vik1\": [\n" +
            "      9,\n" +
            "      9,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"vik2\": [\n" +
            "      9,\n" +
            "      9,\n" +
            "      9\n" +
            "    ]\n" +
            "  },\n" +
            "  \"count_of_competisions_to_do\": {\n" +
            "    \"vik1\": [\n" +
            "      7,\n" +
            "      6,\n" +
            "      7\n" +
            "    ],\n" +
            "    \"vik2\": [\n" +
            "      5,\n" +
            "      6,\n" +
            "      7\n" +
            "    ]\n" +
            "  }\n" +
            "}";


}
