package com.tamvan.kisah25nabi.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tamvan.kisah25nabi.R;
import com.tamvan.kisah25nabi.holder.Story;

/**
 * Created by Rofie on 10/29/2016.
 */
public class CustomViewListCerita extends BaseAdapter {

    private Story[] dataStory;
    private Context context;
    private LayoutInflater layoutInflater;
    public CustomViewListCerita(Context context,Story[] dataStory) {
        this.context = context;
        this.dataStory = dataStory;
    }

    @Override
    public int getCount() {
        return dataStory.length;
    }

    @Override
    public Object getItem(int position) {
        return dataStory[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = convertView;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        customView = layoutInflater.inflate(R.layout.cv_list_story,parent,false);

        Story i = (Story)getItem(position);

        TextView textViewTitle = (TextView)customView.findViewById(R.id.textViewTitleList);
        textViewTitle.setText(i.get_title());

        customView.setTag(i);
        return customView;
    }
}
