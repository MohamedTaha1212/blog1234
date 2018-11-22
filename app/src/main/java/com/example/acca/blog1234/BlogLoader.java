package com.example.acca.blog1234;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.util.List;


public class BlogLoader extends AsyncTaskLoader<List<BlogArticle>> {
    private static String mUrl;

    BlogLoader(Context context, String burl) {
        super(context);
        mUrl = burl ;
    }
    protected void OnStartLoading() {

        forceLoad();
    }


    public List<BlogArticle> loadInBackground() {
        if (mUrl == null){
            return null;}
        List<BlogArticle> blogArticles =   BlogQuery.fetchBlogData(mUrl);
        return blogArticles;
    }
}
