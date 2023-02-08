package com.example.gallery;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class imageAdapter extends BaseAdapter {

    MainActivity mainActivity;
    public imageAdapter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        MainActivity.images=getAllShownImagesPath(mainActivity);

    }

    @Override
    public int getCount() {
        return MainActivity.images.size();
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

        ImageView img;
        if(convertView==null)
        {
            img= new ImageView(mainActivity);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setLayoutParams(new ViewGroup.LayoutParams(570,600));
        }
        else {
            img=(ImageView) convertView;
        }

        Glide.with(mainActivity).load(MainActivity.images.get(position))
                .placeholder(R.drawable.ic_launcher_background).centerCrop().into(img);

        return img;
    }

    private ArrayList<String> getAllShownImagesPath(Activity activity) {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(absolutePathOfImage);
        }
        return listOfAllImages;
    }
}


