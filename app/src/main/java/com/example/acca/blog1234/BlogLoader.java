package com.example.acca.blog1234;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class BlogLoader extends AsyncTaskLoader<List<BlogArticle>> {
    public BlogLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<BlogArticle> loadInBackground() {
        List<BlogArticle> objectList =new ArrayList<BlogArticle>();
        return objectList;
    }
}
