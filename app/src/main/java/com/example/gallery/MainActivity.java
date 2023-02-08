package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    public static ArrayList<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.grid);

        gridView.setAdapter(new imageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(null!= images && !images.isEmpty())
                {
//                    Toast.makeText(getApplicationContext(),"position"+position+""+images.get(position),Toast.LENGTH_SHORT).show();
                }

                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });

    }
}