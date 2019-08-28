package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import dev.abhishekkumar.jokeandroidlib.JokeActivity;

public class EndpointAsyncTask extends AsyncTask<Context,Void,String> {
    public static MyApi myApiService = null;
    private Context context;


    @Override
    protected String doInBackground(Context...params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.31.98:8888/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke",result);
        context.startActivity(intent);
    }
}
