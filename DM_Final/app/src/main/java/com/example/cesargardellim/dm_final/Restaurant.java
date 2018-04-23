package com.example.cesargardellim.dm_final;

import org.json.JSONArray;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cesargardellim on 05/03/18.
 */

public class Restaurant {

    private String Name;
    private String Hours;
    private String Telefone;
    private String Options;
    //private List<String> Location;
    private String Location;


    public Restaurant(String Name, String Hours, String Telefone, String Options, String Location){
        this.Name = Name;
        this.Hours = Hours;
        this.Telefone = Telefone;
        this.Options = Options;
        this.Location =  Location;

        /*
        if(Location!=null){
            for(String location: (List<String>)Location){
                this.Location.add(location.toString());
            }
        }
        */

    }//constructor

    public String getName(){
        return this.Name;
    }

    public String getHours(){
        return this.Hours;
    }

    public String getTelefone(){
        return this.Telefone;
    }

    public String getOptions(){
        return this.Options;
    }

    //public List<String> getLocation() {return this.Location;}

    public String getLocation() {return this.Location;}





} // Restaurant
