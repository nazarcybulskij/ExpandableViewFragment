package com.volpis.test.expandableviewfragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
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
//    @InjectView(R.id.gridview_men_age)
//    GridView mGVMenAge;
//    @InjectView(R.id.gridview_woman_age)
//    GridView mGVWomanAge;
//    @InjectView(R.id.gridview_schoolboy_age)
//    GridView mGVSchoolbouAge;
//
//    String[] data = {"a", "b", "c", "d", "e","f"};
//    ArrayAdapter<String> adapter;
//
//    @InjectView(R.id.table)
//    LinearLayout table;

        LayoutInflater mInflater;
        @InjectView(R.id.expandable_hto)
        LinearLayout mLinearLayoutHto;
        @InjectView(R.id.header_hto)
        LinearLayout mLinearLayoutHeaderHto;

        @InjectView(R.id.expandable_men)
        LinearLayout mLinearLayoutMen;
        @InjectView(R.id.header_men)
        LinearLayout mLinearLayoutHeaderMen;

        @InjectView(R.id.expandable_woman)
        LinearLayout mLinearLayoutWoman;
        @InjectView(R.id.header_woman)
        LinearLayout mLinearLayoutHeaderWomen;

        @InjectView(R.id.expandable_scoolboy)
        LinearLayout mLinearLayoutScoolboy;
        @InjectView(R.id.header_scoolboy)
        LinearLayout mLinearLayoutHeaderScoolboy;

        List<LinearLayoutandAnimator> mLinearLayoutList=new ArrayList<LinearLayoutandAnimator>();






    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            mInflater = inflater;
            View view = mInflater.inflate(R.layout.fragment_main, container, false);

            ButterKnife.inject(this, view);

            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderHto, mLinearLayoutHto, null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderMen, mLinearLayoutMen,null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderWomen, mLinearLayoutWoman,null));
            mLinearLayoutList.add(new LinearLayoutandAnimator(mLinearLayoutHeaderScoolboy, mLinearLayoutScoolboy,null));



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

    @OnClick(R.id.header_hto)
    public void headerclick(View v){
            if (mLinearLayoutHto.getVisibility() == View.GONE) {
                    expand(mLinearLayoutHto);
            } else {
                    collapse(mLinearLayoutHto);
            }
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







        private void expand(LinearLayout layout) {
                //set Visible
                layout.setVisibility(View.VISIBLE);
		        /* Remove and used in preDrawListener
		        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		        mLinearLayoutHto.measure(widthSpec, heightSpec);

		        mAnimator = slideAnimator(0, mLinearLayoutHto.getMeasuredHeight());
		        */
                for (LinearLayoutandAnimator temp:mLinearLayoutList){
                        if (layout.equals(temp.getContent())) {
                                temp.getAnimator().start();
                                return;
                        }
                }

                //mAnimator.start();
        }

        private void collapse(final LinearLayout layout) {
                int finalHeight = layout.getHeight();

                ValueAnimator mAnimator = slideAnimator(finalHeight, 0,layout);

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


        private ValueAnimator slideAnimator(int start, int end, final LinearLayout layout) {

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
