package util;

import android.animation.ValueAnimator;
import android.widget.LinearLayout;

/**
 * Created by nazar on 11.06.15.
 */
public class LinearLayoutandAnimator {

    LinearLayout header;
    LinearLayout content;
    ValueAnimator animator;


    public LinearLayoutandAnimator(LinearLayout header, LinearLayout content, ValueAnimator animator) {
        this.header = header;
        this.content = content;
        this.animator = animator;
    }


    public LinearLayout getHeader() {
        return header;
    }

    public void setHeader(LinearLayout header) {
        this.header = header;
    }

    public LinearLayout getContent() {
        return content;
    }

    public void setContent(LinearLayout content) {
        this.content = content;
    }

    public ValueAnimator getAnimator() {
        return animator;
    }

    public void setAnimator(ValueAnimator animator) {
        this.animator = animator;
    }





}
