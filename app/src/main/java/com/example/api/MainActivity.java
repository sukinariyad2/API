package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    String API_URL="http://10.0.2.2:0000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new syncData().execute();


}
     public class syncData extends AsyncTask<String,String,String>
     {
         @Override
         protected void onPreExecute() {
             super.onPreExecute();
         }

         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
             Toast.makeText(getApplicationContext(), ""+s, Toast.LENGTH_SHORT).show();
         }

         @Override
         protected String doInBackground(String... strings) {
             StringBuilder builder=new StringBuilder();
             try {
                 URL url=new URL(API_URL);
                 HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                 connection.setRequestMethod("GET");
                 connection.connect();
                 BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 while (true)
                 {String readLine=reader.readLine();
                     String data=readLine;
                     if(data==null)
                     {break;}
                     builder.append(data);
             }catch (Exception e)
             {e.printStackTrace();}
             return builder.toString();
         }}}
}