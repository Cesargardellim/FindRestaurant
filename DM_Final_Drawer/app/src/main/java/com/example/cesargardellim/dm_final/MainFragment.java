package com.example.cesargardellim.dm_final;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by cesargardellim on 27/06/18.
 */

public class MainFragment extends Fragment {

    RestaurantList RestaurantList = new RestaurantList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);



    }//onCreate


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        //These 2 lines are required to allow the app to make request from the internet
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        RestaurantList.getRestaurants();

        //Creating a list with the name of the Restaurants



        //Component variables
        final Button btnSearch = (Button)getView().findViewById(R.id.btnSearch);
        final ListView LVNames = (ListView) getView().findViewById(R.id.LVNames);

        final List<String> RestaurantsName = RestaurantList.returnAllRestaurantsName();
        final List<String> RestaurantsHours = RestaurantList.returnAllRestaurantsHours();
        final List<String> RestaurantsOptions = RestaurantList.returnAllRestaurantsOptions();
        final List<String> RestaurantsTelefone = RestaurantList.returnAllRestaurantsTelefone();
        final List<String> RestaurantsLocation = RestaurantList.returnAllRestaurantsLocation();


        
        //Onclick button function test
        // It will set the ListView from the xml to create a list with the name of the restaurants
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //ScrollView SVNames = (ScrollView)findViewById(R.id.SVNames);

                ArrayAdapter<String> adapterTest = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,RestaurantsName);
                LVNames.setAdapter(adapterTest);

            }
        }); // onClickListener btnSearch



        /*
            function to open a new activity
         */
        LVNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String name = RestaurantsName.get(position);
                String hours = RestaurantsHours.get(position);
                String telefone = RestaurantsTelefone.get(position);
                String options = RestaurantsOptions.get(position);
                String location = RestaurantsLocation.get(position);
                // se for a partir de uma activity
                Intent intent = new Intent(getActivity(), /* activity a ser chamada */ RestaurantInfo.class);
                // set no intent o id ou a position do item selecionado
                intent.putExtra("id", position);
                intent.putExtra("name",name);
                intent.putExtra("hours",hours);
                intent.putExtra("telefone",telefone);
                intent.putExtra("options",options);
                intent.putExtra("location",location);
                startActivity(intent);
            }
        });
    }
}
