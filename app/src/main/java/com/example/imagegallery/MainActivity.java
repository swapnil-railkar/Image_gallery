package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public int[] images={R.drawable.add,R.drawable.b723bc52a4d351c90e7c7629dadd51c7,
            R.drawable.b723bc52a4d351c90e7c7629dadd51c7,R.drawable.clock,R.drawable.gundam,
            R.drawable.locked,R.drawable.message,R.drawable.share,R.drawable.nature};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    private void getData()
    {
        final Call<PostList> postlist=AtgApi.getService().getPostList();
        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list= response.body();
                recyclerView.setAdapter(new ImageAdapter(MainActivity.this, (List<ClipData.Item>) list.getPhotos()));
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();
            }
        });
    }
}