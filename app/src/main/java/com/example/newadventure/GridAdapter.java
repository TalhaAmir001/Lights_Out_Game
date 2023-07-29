package com.example.newadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    Context context;
    int[] lightId;
    LayoutInflater layoutInflater;
    public ImageView lightPosition;

    public GridAdapter(Context context, int[] lightId) {
        this.context = context;
        this.lightId = lightId;
    }

    @Override
    public int getCount() {
        return lightId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.grid_item, null, false);
        }

        lightPosition = view.findViewById(R.id.mainLight_IV_Id);

        lightPosition.setImageResource(lightId[i]);

        return view;
    }
}
