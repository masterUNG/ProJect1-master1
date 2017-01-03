package com.example.n56j.project1;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by ASUSS on 3/1/2560.
 */

public class SynRoom extends AsyncTask<Void, Void, String>{

    //explicit
    private static final String urlJSON = "http://swiftcodingthai.com/pbru/php_get_room.php";
    private Context context;

    public SynRoom(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}//mainclass
