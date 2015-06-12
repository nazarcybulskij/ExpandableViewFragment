package adapter;

import android.content.Context;
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

    // id по позиции
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

        ((TextView)view.findViewById(R.id.tvText)).setText(item.getTitle());



        return view;
    }
}
