package com.example.lesson_api.services;

import android.os.StrictMode;

import com.example.lesson_api.models.State;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DataService {

    private static ArrayList<State> arrState = new ArrayList<State>();

    public static ArrayList<State> getArrState(){
        String sURL = "https://restcountries.com/v2/all?fields=name,nativeName,borders,flag";
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url = new URL(sURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonArray rootobj = root.getAsJsonArray();
            for (JsonElement je : rootobj){

                JsonObject obj = je.getAsJsonObject();
                JsonElement entriesname = obj.get("name");
                JsonElement entriesnative = obj.get("nativeName");
                JsonElement entriesborders = obj.get("borders");
                JsonElement entriesflags = obj.get("flag");

                String name = entriesname.toString().replace("\"","");
                String nativen = entriesnative.toString().replace("\"","");
                String flags = entriesflags.toString().replace("\"","");

                ArrayList<String> arrBorders = new ArrayList<>();
                if ( entriesborders!= null) {
                    JsonArray entriesborderArray = entriesborders.getAsJsonArray();
                    for ( JsonElement j : entriesborderArray){
                        String s = j.toString().replace("\"","");
                        arrBorders.add(s);

                    }

                }
                arrState.add(new State(name,nativen,flags,arrBorders));
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrState;
    }
}
