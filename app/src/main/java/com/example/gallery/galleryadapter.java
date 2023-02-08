package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class galleryadapter extends BaseAdapter {

     Context context;
     ArrayList<String> images;
    public galleryadapter(Context context, ArrayList<String> images) {
        this.context=context;
        this.images=images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView= new ImageView(context);

        Glide.with(context).load(MainActivity.images.get(position)).placeholder(R.drawable.ic_launcher_background).centerCrop().into(imageView);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,200));

        return imageView;
    }
}
