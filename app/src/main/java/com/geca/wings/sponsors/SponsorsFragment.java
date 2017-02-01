package com.geca.wings.sponsors;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.geca.wings.MainActivity;
import com.geca.wings.R;
import com.geca.wings.gallery.GalleryImage;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

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
import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;


public class SponsorsFragment extends Fragment{

    private ListView lvMovies;
    private ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.sponsors, container, false);
        progressBar = (SmoothProgressBar)v.findViewById(R.id.progressbar);
        ((MainActivity) getActivity()).setActionBarTitle("Sponsors");
        LinearLayout errorLayout = (LinearLayout)v.findViewById(R.id.error);
        LinearLayout contLayout = (LinearLayout)v.findViewById(R.id.content);
        if (!com.geca.wings.NetworkUtil.isNetworkConnected(getActivity())){

            errorLayout.setVisibility(View.VISIBLE);
            contLayout.setVisibility(View.GONE);
        }else {
            // Create default options which will be used for every
            //  displayImage(...) call if no options will be passed to this method
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.drawable.wingslogos)
                    .showImageOnFail(R.drawable.wingslogos)
                    .resetViewBeforeLoading(true)
                    .cacheOnDisk(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .considerExifParams(true)
                    .displayer(new FadeInBitmapDisplayer(300))
                    .displayer(new RoundedBitmapDisplayer(10))
                    .build();

            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext().getApplicationContext())
                    .defaultDisplayImageOptions(options)
                    .threadPriority(Thread.NORM_PRIORITY - 2)
                    .denyCacheImageMultipleSizesInMemory()
                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                    .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                    .tasksProcessingOrder(QueueProcessingType.LIFO)

                    .build();
            ImageLoader.getInstance().init(config); // Do it on Application start

            lvMovies = (ListView) v.findViewById(R.id.lvMovies);

//                new JSONTask().execute("http://jsonparsing.parseapp.com/jsonData/moviesDemoList.txt");
//                new JSONTask().execute("http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt");
            new JSONTask().execute("http://wings2k16.comlu.com/Sponsors.json");
        }
        return v;
    }





    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }
    public class JSONTask extends AsyncTask<String,String, List<GalleryImage> > {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected List<GalleryImage> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("sponsors");

                List<GalleryImage> galleryImageList = new ArrayList<>();

                Gson gson = new Gson();
                for(int i=0; i<parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    GalleryImage galleryImage = gson.fromJson(finalObject.toString(), GalleryImage.class);
//                    galleryImage.setMovie(finalObject.getString("movie"));
//                    galleryImage.setYear(finalObject.getInt("year"));
//                    galleryImage.setRating((float) finalObject.getDouble("rating"));
//                    galleryImage.setDirector(finalObject.getString("director"));
//
//                    galleryImage.setDuration(finalObject.getString("duration"));
//                    galleryImage.setTagline(finalObject.getString("tagline"));
//                    galleryImage.setImage(finalObject.getString("image"));
//                    galleryImage.setStory(finalObject.getString("story"));
//
//                    List<GalleryImage.Cast> castList = new ArrayList<>();
//                    for(int j=0; j<finalObject.getJSONArray("cast").length(); j++){
//                        GalleryImage.Cast cast = new GalleryImage.Cast();
//                        cast.setName(finalObject.getJSONArray("cast").getJSONObject(j).getString("name"));
//                        castList.add(cast);
//                    }
//                    galleryImage.setCastList(castList);
                    // adding the final object in the list
                    galleryImageList.add(galleryImage);
                }
                return galleryImageList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  null;
        }

        @Override
        protected void onPostExecute(List<GalleryImage> result) {
            super.onPostExecute(result);
            //progressBar.setVisibility(View.GONE);
            if(result!=null) {

                MovieAdapter adapter = new MovieAdapter(getContext().getApplicationContext(), R.layout.custom_sponsors_row, result);
                lvMovies.setAdapter(adapter);
            }
            // TODO need to set data to the list
        }
    }



    public class MovieAdapter extends ArrayAdapter {

        private List<GalleryImage> galleryImageList;
        private int resource;
        private LayoutInflater inflater;
        public MovieAdapter(Context context, int resource, List<GalleryImage> objects) {
            super(context, resource, objects);
            progressBar.setVisibility(View.GONE);
            galleryImageList = objects;
            this.resource = resource;
            inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView == null){
                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);
                holder.ivMovieIcon = (ImageView)convertView.findViewById(R.id.ivIcon);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }



            final ProgressBar progressBar = (SmoothProgressBar)convertView.findViewById(R.id.progressbar);

            // Then later, when you want to display image
            ImageLoader.getInstance().displayImage(galleryImageList.get(position).getImage(), holder.ivMovieIcon, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    progressBar.setVisibility(View.GONE);
                }
            });


            return convertView;
        }


        class ViewHolder{
            private ImageView ivMovieIcon;

        }

    }
}


