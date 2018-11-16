package com.example.acca.blog1234;



import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.example.acca.blog1234.SoftSkillsFragment.LOG_TAG;

public class BlogQuery  {

        public static List<BlogArticle> fetchBlogData(String requestUrl) {
           // Create URL object
           URL url = createUrl(requestUrl);

           // Perform HTTP request to the URL and receive a JSON response back
           String jsonResponse = null;
           try {
               jsonResponse = makeHttpRequest(url);
           } catch (IOException e) {
               Log.e(LOG_TAG, "Problem making the HTTP request.", e);
           }

           // Extract relevant fields from the JSON response and create an {@link Article} object
           List<BlogArticle> blog = extractFeatureFromJson(jsonResponse);

           // Return the {@link Article} object as the result fo the {@link TsunamiAsyncTask}
           return blog;
        }

        private static URL createUrl(String stringUrl) {
            URL url;
            try {
                url = new URL(stringUrl);
            } catch (MalformedURLException exception) {
               Log.e(LOG_TAG, "Error with creating URL", exception);
                return null;
            }
            return url;
        }

        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private static String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";

            // If the URL is null, then return early.
            if (url == null) {
                return jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();

                // If the request was successful (response code 200),
                // then read the input stream and parse the response.
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                   Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem retrieving the blogArticle JSON results.", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private static String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

        /**
         * Return an {@link BlogArticle} object by parsing out information
         * about the first article from the input articlesJSON string.
         */
        private static List<BlogArticle> extractFeatureFromJson(String blogJSON) {
            // If the JSON string is empty or null, then return early.
            if (TextUtils.isEmpty(blogJSON)) {
                return null;
            }
            List<BlogArticle> blog = new ArrayList<>();
            try {
                JSONObject baseJsonResponse = new JSONObject(blogJSON);
                JSONArray BlogArray = baseJsonResponse.getJSONArray("Blog Articles");

                // If there are results in the Articles array
                for (int i = 0; i< BlogArray.length(); i++  ){
                    // Extract out the first feature (which is an blogArticle)
                    JSONObject currentblog = BlogArray.getJSONObject(i);

                    // Extract out the id, name, and description values
                    String id = currentblog.getString("id");
                    String name = currentblog.getString("name");
                    String description = currentblog.getString("description");
                    String date = currentblog.getString("date");
                    String image = currentblog.getString("image");


                    // Create a new {@link Article} object
                    BlogArticle blogArticle = new BlogArticle(id,name,description,date,image);
                    blog.add(blogArticle);
                }
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Problem parsing the Articles JSON results", e);
            }
            return blog;
        }
}
/**
 public static final String LOG_TAG = MainActivity.class.getSimpleName();

 private static final String AAPG_ARTICLES_REQUEST_URL =
 "http://www.aapgsuez.net/sarticles.php";
 */

/**
 public void updateUi(BlogArticle blogArticle) {
 // Display the blogArticle title in the UI
 TextView idTextView = (TextView) findViewById(R.id.idView);
 idTextView.setText(blogArticle.id);

 // Display the blogArticle date in the UI
 TextView nameTextView = (TextView) findViewById(R.id.nameView);
 nameTextView.setText(blogArticle.name);

 // Display whether or not there was a tsunami alert in the UI
 TextView descriptionTextView = (TextView) findViewById(R.id.descriptionView);
 descriptionTextView.setText(blogArticle.description);

 TextView dateTextView = (TextView) findViewById(R.id.dateView);
 descriptionTextView.setText(blogArticle.date);

 ImageView articlesImageView = (ImageView) findViewById(R.id.BlogImageView);
 String imageUri = blogArticle.image;

 Picasso.get().load(imageUri).into(articlesImageView);
 }

 */


/** @Override
protected BlogArticle doInBackground(URL... urls) {
// Create URL object
URL url = createUrl(AAPG_ARTICLES_REQUEST_URL);

// Perform HTTP request to the URL and receive a JSON response back
String jsonResponse = "";
try {
jsonResponse = makeHttpRequest(url);
} catch (IOException e) {
Log.e(LOG_TAG, "Problem making the HTTP request.", e);
}

// Extract relevant fields from the JSON response and create an {@link } object
BlogArticle blogArticle = extractFeatureFromJson(jsonResponse);

// Return the {@link } object as the result fo the {@link }
return blogArticle;// Create URL object
URL url = createUrl(AAPG_ARTICLES_REQUEST_URL);

// Perform HTTP request to the URL and receive a JSON response back
String jsonResponse = "";
try {
jsonResponse = makeHttpRequest(url);
} catch (IOException e) {
Log.e(LOG_TAG, "Problem making the HTTP request.", e);
}

// Extract relevant fields from the JSON response and create an {@link } object
BlogArticle blogArticle = extractFeatureFromJson(jsonResponse);

// Return the {@link } object as the result fo the {@link }
return blogArticle;
}
 */