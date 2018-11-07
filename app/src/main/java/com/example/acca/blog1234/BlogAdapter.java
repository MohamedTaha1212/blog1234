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

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.blog_list_item, parent, false);
        }
        BlogArticle currentArticle = getItem(position);

        ImageView BlogImageView = (ImageView)  listItemView.findViewById(R.id.BlogImageView);
        assert currentArticle != null;
        String imageUri = currentArticle.image;
        Picasso.get().load(imageUri).into(BlogImageView);


        TextView nameView = (TextView)  listItemView.findViewById(R.id.nameView);
        nameView.setText(currentArticle.getName());

        TextView descriptionView = (TextView)  listItemView.findViewById(R.id.descriptionView);
        descriptionView.setText(currentArticle.getDescription());

        TextView idView = (TextView)  listItemView.findViewById(R.id.idView);
        idView.setText(currentArticle.getId());

        TextView dateView = (TextView)  listItemView.findViewById(R.id.dateView);
        dateView.setText(currentArticle.getDate());

        return listItemView;
    }

    /*
            cardView.setImageResource(R.drawable.activation);
    public Bitmap getBitmapFromURL(String src){
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input)

            return myBitmap;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }*/
}
