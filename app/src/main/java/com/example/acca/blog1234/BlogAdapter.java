package com.example.acca.blog1234;

import android.content.Context;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;


public class BlogAdapter extends ArrayAdapter<BlogArticle>{
    public BlogAdapter(@NonNull Context context, int resource, @NonNull List<BlogArticle> articles) {
        super(context, 0, articles);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.blog_list_item, parent, false);
        }
        BlogArticle currentArticle = getItem(position);

        ImageView BlogImageView = listItemView.findViewById(R.id.BlogImageView);
        assert currentArticle != null;
        String imageUri = currentArticle.image;
        Picasso.get().load(imageUri).into(BlogImageView);


        TextView nameView = listItemView.findViewById(R.id.nameView);
        nameView.setText(currentArticle.getName());

        TextView descriptionView = listItemView.findViewById(R.id.descriptionView);
        descriptionView.setText(currentArticle.getDescription());

        TextView idView = listItemView.findViewById(R.id.idView);
        idView.setText(currentArticle.getId());

        TextView dateView = listItemView.findViewById(R.id.dateView);
        dateView.setText(currentArticle.getDate());

        return listItemView;
    }

}
