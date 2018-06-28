package com.example.cesargardellim.dm_final;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.EventListener;
import java.util.List;

import static android.R.attr.button;
import static com.example.cesargardellim.dm_final.R.id.LVNames;
import static com.example.cesargardellim.dm_final.R.id.btnSearch;

public class MainActivity extends AppCompatActivity {



    RestaurantList RestaurantList = new RestaurantList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Find Restaurant");


        //These 2 lines are required to allow the app to make request from the internet
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        RestaurantList.getRestaurants();

        //Creating a list with the name of the Restaurants



        //Component variables
        final Button btnSearch = (Button)findViewById(R.id.btnSearch);
        final ListView LVNames = (ListView) findViewById(R.id.LVNames);

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

                ArrayAdapter<String> adapterTest = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,RestaurantsName);
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
                Intent intent = new Intent(getApplicationContext(), /* activity a ser chamada */ RestaurantInfo.class);
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




    }//onCreate
}//MainActivity
