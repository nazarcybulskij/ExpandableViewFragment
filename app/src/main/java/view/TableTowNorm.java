package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.volpis.test.expandableviewfragment.R;

import model.Competision;
import model.Norm;

/**
 * Created by nazar on 10.06.15.
 */
public class TableTowNorm extends LinearLayout {

    Competision mCompetision;


    public TableTowNorm(Context context,Competision competision) {
        super(context);
        mCompetision = competision;
        initView();
    }


    public TableTowNorm(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public TableTowNorm(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        View view = inflate(getContext(), R.layout.table_norm, null);
        addView(view);
        //

        if (mCompetision!=null){
            if (mCompetision.getListNorm().size()==1) {
                TextView textView = (TextView) view.findViewById(R.id.name);
                textView.setText(mCompetision.getListNorm().get((0)).getName());
            }

            if (mCompetision.getListNorm().size()==2) {
               // ((TextView) findViewById(R.id.name)).setText(mCompetision.getListNorm().get((0)).getName());
               // ((TextView) findViewById(R.id.name2)).setText(mCompetision.getListNorm().get((1)).getName());
            }


            }
        //

    }

}
