package com.volpis.test.expandableviewfragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import adapter.ItemAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import model.Item;
import util.LinearLayoutandAnimator;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
//    @InjectView(R.id.info)
//    ExpandableLayout mELInfo;
//    @InjectView(R.id.textview_header_info)
//    TextView mTVInfo;
//
    @InjectView(R.id.gridview_men_age)
    GridView mGVMenAge;
    @InjectView(R.id.gridview_woman_age)
    GridView mGVWomanAge;
    @InjectView(R.id.gridview_schoolboy_age)
    GridView mGVSchoolbouAge;

    String[] data = {"", "", "", "", "",""};
    ItemAdapter adapter_schoolboy;
    ItemAdapter adapter_woman;
    ItemAdapter adapter_men;
//
//    @InjectView(R.id.table)
//    LinearLayout table;

        LayoutInflater mInflater;

//        @InjectView(R.id.expandable_hto)
//        View mLinearLayoutHto;
        @InjectView(R.id.header_hto)
        View mLinearLayoutHeaderHto;

        @InjectView(R.id.expandable_men)
        View mLinearLayoutMen;
        @InjectView(R.id.header_men)
        View mLinearLayoutHeaderMen;

        @InjectView(R.id.expandable_woman)
        View mLinearLayoutWoman;
        @InjectView(R.id.header_woman)
        View mLinearLayoutHeaderWomen;

        @InjectView(R.id.expandable_scoolboy)
        View mLinearLayoutScoolboy;
        @InjectView(R.id.header_scoolboy)
        View mLinearLayoutHeaderScoolboy;

       @InjectView(R.id.image_norm_men)
        ImageView mIVNormMen;



        List<LinearLayoutandAnimator> mLinearLayoutList=new ArrayList<LinearLayoutandAnimator>();






    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            mInflater = inflater;
            View view = mInflater.inflate(R.layout.fragment_main, container, false);

            ButterKnife.inject(this, view);

            requestGet();

           // mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderHto, mLinearLayoutHto, null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderMen, mLinearLayoutMen,null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderWomen, mLinearLayoutWoman, null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderScoolboy, mLinearLayoutScoolboy, null));

            addDrawListener();

            return view;


    }

        private void addDrawListener() {

              for (int i=0;i<mLinearLayoutList.size();i++){

                      final int finalI = i;
                      ViewTreeObserver.OnPreDrawListener drawListener = new ViewTreeObserver.OnPreDrawListener() {

                              @Override
                              public boolean onPreDraw() {
                                      mLinearLayoutList.get(finalI).getContent().getViewTreeObserver().removeOnPreDrawListener(this);
                                      mLinearLayoutList.get(finalI).getContent().setVisibility(View.GONE);


                                      final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                                      final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                                      mLinearLayoutList.get(finalI).getContent().measure(widthSpec, heightSpec);

                                      mLinearLayoutList.get(finalI).setAnimator(slideAnimator(0, mLinearLayoutList.get(finalI).getContent().getMeasuredHeight(), mLinearLayoutList.get(finalI).getContent()));

                                      return true;
                              }
                      };


                      mLinearLayoutList.get(finalI).getContent().getViewTreeObserver().addOnPreDrawListener(drawListener);


              }





        }

        @OnClick(R.id.textview_header_info)
    public void infoclicked(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Title");
        alertDialog.setMessage("Here is a really long message.");
        AlertDialog alert = alertDialog.create();
        alert.show();
    }


    boolean state = false;
    @OnClick(R.id.header_hto)
    public void headerclick(View v){

            if (state){
                    for (LinearLayoutandAnimator temp:mLinearLayoutList){
                            //expand(temp.getContent());
                            expand(temp.getHeader());
                    }

            }else{
                    for (LinearLayoutandAnimator temp:mLinearLayoutList){
                           // temp.getHeader().setVisibility(View.GONE);
                          //  temp.getContent().setVisibility(View.GONE);
                            collapse(temp.getContent());
                            collapse(temp.getHeader());


                    }

            }


            state=!state;
//            if (mLinearLayoutHto.getVisibility() == View.GONE) {
//                    expand(mLinearLayoutHto);
//            } else {
//                    collapse(mLinearLayoutHto);
//            }
    }

        @OnClick(R.id.header_men)
        public void headerMenclick(View v){
                if (mLinearLayoutMen.getVisibility() == View.GONE) {
                        expand(mLinearLayoutMen);
                } else {
                        collapse(mLinearLayoutMen);
                }
        }

        @OnClick(R.id.header_woman)
        public void headerWomanclick(View v) {
                if (mLinearLayoutWoman.getVisibility() == View.GONE) {
                        expand(mLinearLayoutWoman);
                } else {
                        collapse(mLinearLayoutWoman);
                }
        }

        @OnClick(R.id.header_scoolboy)
        public void headerScoolboyclick(View v) {
                if (mLinearLayoutScoolboy.getVisibility() == View.GONE) {
                        expand(mLinearLayoutScoolboy);
                } else {
                        collapse(mLinearLayoutScoolboy);
                }
        }

    @OnItemClick(R.id.gridview_men_age)
    void onItemMenSelected(int position) {





    }


    @OnItemClick(R.id.gridview_woman_age)
    void onItemWomanSelected(int position) {



    }

    @OnItemClick(R.id.gridview_schoolboy_age)
    void onItemSchoolboySelected(int position) {



    }








    private void expand(View layout) {
                //set Visible
                layout.setVisibility(View.VISIBLE);
		        // Remove and used in preDrawListener
		        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		        layout.measure(widthSpec, heightSpec);

		        ValueAnimator mAnimator = slideAnimator(0, layout.getMeasuredHeight(),layout);
                mAnimator.start();

//                for (LinearLayoutandAnimator temp:mLinearLayoutList){
//                        if (layout.equals(temp.getContent())) {
//                                temp.getAnimator().start();
//                                return;
//                        }
//                }

                //mAnimator.start();
        }








        private void collapse( final View layout) {
                int finalHeight = layout.getHeight();

                ValueAnimator mAnimator = slideAnimator(finalHeight, 0, layout);

                mAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationEnd(Animator animator) {
                                //Height=0, but it set visibility to GONE
                                layout.setVisibility(View.GONE);

                        }

                        @Override
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {
                        }
                });
                mAnimator.start();
        }


        private ValueAnimator slideAnimator(int start, int end, final View layout) {

                ValueAnimator animator = ValueAnimator.ofInt(start, end);


                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //Update Height
                        int value = (Integer) valueAnimator.getAnimatedValue();

                        ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
                        layoutParams.height = value;
                        layout.setLayoutParams(layoutParams);
                    }
                });
                return animator;
        }


    public void requestGet() {

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "http://vsporte.cc41365.tmweb.ru/gto_what/list";
;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        model.Response responseObject = gson.fromJson( response, model.Response.class );
                        ArrayList<Item>  mens = new ArrayList<Item>();
                        ArrayList<Item>  woman = new ArrayList<Item>();
                        ArrayList<Item>  childr = new ArrayList<Item>();

                        int current_id=-1;
                        for (Item temp:responseObject.getData()){
                             if (temp.getTitle().equals("Школьники"))
                                    current_id = temp.getId();

                            if (current_id==temp.getParent_id())
                                childr.add(temp);

                        }


                        Collections.sort(childr);



                        adapter_schoolboy = new ItemAdapter(getActivity(),childr);
                        mGVSchoolbouAge.setAdapter(adapter_schoolboy);




                        current_id=-1;
                        for (Item temp:responseObject.getData()){
                            if (temp.getTitle().equals("Женщины"))
                                current_id = temp.getId();

                            if (current_id==temp.getParent_id())
                                woman.add(temp);


                        }

                        Collections.sort(woman);

                        adapter_woman =  new ItemAdapter(getActivity(),woman);
                        mGVWomanAge.setAdapter(adapter_woman);


                        current_id=-1;
                        for (Item temp:responseObject.getData()) {
                            if (temp.getTitle().equals("Мужчины"))
                                current_id = temp.getId();

                            if (current_id == temp.getParent_id())
                                mens.add(temp);
                        }

                        Collections.sort(mens);


                        adapter_men =  new ItemAdapter(getActivity(),mens);
                        mGVMenAge.setAdapter(adapter_men);



                            //Toast.makeText(getActivity(), "Response is: " + response.toString(), Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "That didn't work!", Toast.LENGTH_SHORT).show();


            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }











    }
