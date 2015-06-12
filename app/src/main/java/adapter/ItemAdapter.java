package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.volpis.test.expandableviewfragment.R;

import java.util.ArrayList;

import model.Item;

/**
 * Created by nazar on 12.06.15.
 */
public class ItemAdapter  extends BaseAdapter{


    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Item> objects;

    int clickedposution;

    public ItemAdapter(Context context, ArrayList<Item> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objects.size();
    }


    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_age, parent, false);
        }

        Item item = (Item)getItem(position);
        TextView tv= (TextView) view.findViewById(R.id.tvText);
        tv.setText(item.getTitle());

        if (position == clickedposution){
            tv.setBackgroundColor(ctx.getResources().getColor(android.R.color.holo_orange_light));
        }else{
            tv.setBackgroundColor(ctx.getResources().getColor(android.R.color.holo_blue_dark));
        }



        return view;
    }


    public int getClickedposution() {
        return clickedposution;
    }

    public void setClickedposution(int clickedposution) {
        this.clickedposution = clickedposution;
    }

}
