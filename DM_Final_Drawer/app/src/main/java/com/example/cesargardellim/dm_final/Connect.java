package com.example.cesargardellim.dm_final;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cesargardellim on 05/03/18.
 */

public class Connect {

    //https://api.myjson.com/bins/14bzih

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request
    public List<Restaurant> sendGet() throws Exception {


        
        String url = " https://api.myjson.com/bins/h8wdv"; // Location array
        //String url = "https://api.myjson.com/bins/ermvh"; // Location String
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //System.out.println(response.toString());

        List<Restaurant> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public List<Restaurant> findAllItems(JSONArray response) {

        List<Restaurant> found = new LinkedList<Restaurant>();

        try {


            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);

                found.add(new Restaurant(obj.getString("Name"), obj.getString("Hours"),
                                            obj.getString("Telefone"), obj.getString("Options"),
                                            obj.getString("Location")));


                /*
                found.add(new Restaurant(obj.getString("Name"), obj.getString("Hours"),
                        obj.getString("Telefone"), obj.getString("Options"),
                        obj.getJSONArray("Location")));

                */

            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;
    }











} // Connect
