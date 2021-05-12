package com.example.imagegallery;

import android.content.ClipData;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class AtgApi {

    public static final String key = "6f102c62f41998d151e5a1b48713cf13";
    public static final String url = "https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&per_page=20&page=1";
    public static PostService postService=null;

    public static PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
            postService=retrofit.create(PostService.class);
        }
        return postService;
    }
    public interface PostService {
        @GET(url+"&api_key=" + key+"&format=json&nojsoncallback=1&extras=url_s")
        Call<PostList> getPostList();
    }

}
