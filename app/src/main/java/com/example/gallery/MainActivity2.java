package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    int pos;
    Gallery gallery;
    ImageView fullimage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pos=getIntent().getIntExtra("pos",0);

        gallery=findViewById(R.id.gallery);
        fullimage=findViewById(R.id.fullimage);

        galleryadapter galleryadapter=new galleryadapter(getApplicationContext(),MainActivity.images);
        gallery.setAdapter(galleryadapter);

        Glide.with(this).load(MainActivity.images.get(pos))
                .placeholder(R.drawable.ic_launcher_background).centerCrop().into(fullimage);

        gallery.setOnItemClickListener((parent, view, position, id) -> {
            Glide.with(this).load(MainActivity.images.get(position))
                    .placeholder(R.drawable.ic_launcher_background).centerCrop()
                    .into(fullimage);
        });

    }
}