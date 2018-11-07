package com.example.acca.blog1234;

import android.widget.ImageView;


public class BlogArticle {

    public final String id;

    public final String name;

    public final String description;

    public final String date;

    public final String image;


    public BlogArticle (String BlogArticleId, String BlogArticleName, String BlogArticleDescription,String BlogArticleDate, String BlogArticleImage) {
        id = BlogArticleId;
        name = BlogArticleName;
        description = BlogArticleDescription;
        date = BlogArticleDate;
        image = BlogArticleImage;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getId(){return id;}
    public String getDate(){return date;}



}



