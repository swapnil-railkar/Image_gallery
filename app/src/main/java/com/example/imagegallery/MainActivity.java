package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public int[] images={R.drawable.add,R.drawable.b723bc52a4d351c90e7c7629dadd51c7,
            R.drawable.b723bc52a4d351c90e7c7629dadd51c7,R.drawable.clock,R.drawable.gundam,
            R.drawable.locked,R.drawable.message,R.drawable.share,R.drawable.nature};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        ImageAdapter imgadapter=new ImageAdapter(images);
        recyclerView.setAdapter(imgadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}