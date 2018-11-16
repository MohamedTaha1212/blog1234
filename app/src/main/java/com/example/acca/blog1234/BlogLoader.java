package com.example.acca.blog1234;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import java.util.List;


public class BlogLoader extends AsyncTaskLoader<List<BlogArticle>> {
    private String mUrl;

    public BlogLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url ;
    }
    protected void OnStartLoading() {

        forceLoad();
    }
    @Nullable
    @Override
    public  List<BlogArticle> loadInBackground() {
        if (mUrl==null){
            return null;}
        List<BlogArticle> blog =  new BlogQuery.fetchBlogData(mUrl);
        return blog;
    }
}
