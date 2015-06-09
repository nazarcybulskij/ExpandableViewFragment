package com.volpis.test.expandableviewfragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.expandablelayout.library.ExpandableLayout;

import java.util.Collection;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import view.MyGridView;


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






    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ButterKnife.inject(getActivity());
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View view = inflater.inflate(R.layout.fragment_main, container, false);

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

    @OnItemClick(R.id.gridview_men_age)
    void onItemSelected(int position) {
        Toast.makeText(getActivity(),""+position,Toast.LENGTH_SHORT).show();
    }

}
