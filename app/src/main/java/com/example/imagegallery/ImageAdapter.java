package com.example.imagegallery;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private Photos photos;
    private List<Photo> items;
    public ImageAdapter(Context context, Photos photos)
    {
        this.context=context;
        this.photos=photos;
        items=photos.getPhoto();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater imageInflator=LayoutInflater.from(context);
        View view=imageInflator.inflate(R.layout.image_list_layout,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        /*path to get URL of image is :
        Photos->getPhoto()->List<Photo>->get(position)->Photo->getUrls()*/
       Photo image=items.get(position);
       String url=image.getUrlS();

       //Updating Imageview with contents of the URL
       Glide.with(context).load(url).into(holder.image);
    }

    //method to get item count
    @Override
    public int getItemCount() {
        return items.size();
    }

    //View holder class
    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
        }
    }
}
