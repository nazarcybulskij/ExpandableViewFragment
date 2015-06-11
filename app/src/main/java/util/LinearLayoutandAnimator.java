package util;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by nazar on 11.06.15.
 */
public class LinearLayoutandAnimator {

    View header;
    View content;
    ValueAnimator animator;


    public LinearLayoutandAnimator(View header, View content, ValueAnimator animator) {
        this.header = header;
        this.content = content;
        this.animator = animator;
    }


    public View getHeader() {
        return header;
    }

    public void setHeader(View header) {
        this.header = header;
    }

    public View getContent() {
        return content;
    }

    public void setContent(View content) {
        this.content = content;
    }

    public ValueAnimator getAnimator() {
        return animator;
    }

    public void setAnimator(ValueAnimator animator) {
        this.animator = animator;
    }





}
