package com.example.acca.blog1234;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MarketingFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<BlogArticle>>{

    public static final String LOG_TAG = MarketingFragment.class.getName();
    private static final String MARKETING_REQUEST_CALL = "http://aapgsuez.net/android/android-app/blog-marketing.php";
    private static final int MARKETING_LOADER_ID = 2;

    private BlogAdapter blogAdapter ;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);

        ListView marketingListViw = rootView.findViewById(R.id.list);

        blogAdapter = new BlogAdapter(getActivity(),0,new ArrayList<BlogArticle>());
        marketingListViw.setAdapter(blogAdapter);
       /** marketingListViw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BlogArticle clickedArticle = blogAdapter.getItem(position);
                String marketingUrl = clickedArticle.getId();

                Intent websiteIntent = new Intent(getActivity(),webView.class);
                websiteIntent.putExtra("url",marketingUrl);
                startActivity(websiteIntent);
            }
        });*/

        return rootView;
    }

    @NonNull
    @Override
    public Loader<List<BlogArticle>> onCreateLoader(int id, @Nullable Bundle args) {
        return new BlogLoader(getContext(),MARKETING_REQUEST_CALL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<BlogArticle>> loader, List<BlogArticle> blogArticles) {
        /**View loadingIndicator = getView().findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText("Check your internet connection");
        blogAdapter.clear();
*/
        if (blogArticles != null && !blogArticles.isEmpty()){
            blogAdapter.addAll(blogArticles);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<BlogArticle>> loader) {

        blogAdapter.clear(); }

}
