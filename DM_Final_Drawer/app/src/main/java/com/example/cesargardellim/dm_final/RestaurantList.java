package com.example.cesargardellim.dm_final;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cesargardellim on 06/03/18.
 */

public class RestaurantList {

    List<Restaurant> Restaurants = new LinkedList<Restaurant>();
    Connect con = new Connect();

    public void getRestaurants(){
        try {
            Restaurants = con.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnAllRestaurantsName(){
        List<String> RestaurantName = new LinkedList<String>();
        for(Restaurant rest:Restaurants){
            RestaurantName.add(rest.getName());
        }
        return RestaurantName;
    } // returnAllRestaurants

    public List<String> returnAllRestaurantsHours(){
        List<String> RestaurantHours = new LinkedList<String>();
        for(Restaurant rest: Restaurants){
            RestaurantHours.add(rest.getHours());
        }
        return RestaurantHours;
    }

    public List<String> returnAllRestaurantsTelefone(){
        List<String> RestaurantTelefone = new LinkedList<String>();
        for(Restaurant rest: Restaurants){
            RestaurantTelefone.add(rest.getTelefone());
        }
        return RestaurantTelefone;
    }

    public List<String> returnAllRestaurantsOptions(){
        List<String> RestaurantOptions = new LinkedList<String>();
        for(Restaurant rest: Restaurants){
            RestaurantOptions.add(rest.getOptions());
        }
        return RestaurantOptions;
    }


    public List<String> returnAllRestaurantsLocation(){
        List<String> RestaurantLocation = new LinkedList<String>();
        for(Restaurant rest: Restaurants){
            RestaurantLocation.add(rest.getLocation());
        }
        return RestaurantLocation;
    }

   /*  Comentando as functions para poder testar o app
        de maneira simples, mais tarde eu acrescento
        essas functions também.

    public List<String> returnMusicsByBand(String band){
        List<String> found = new LinkedList<String>();
        for(Music music: musics){
            if(music.getBand().equals(band)) found.add(music.getMusicName());
        }
        return found;
    }

    public String returnChords(String band, String musicName){
        for(Music music: musics){
            if(music.getBand().equals(band) && music.getMusicName().equals(musicName)) return music.getChords();
        }
        return "Sorry...";
    }

    */


} //RestaurantList
