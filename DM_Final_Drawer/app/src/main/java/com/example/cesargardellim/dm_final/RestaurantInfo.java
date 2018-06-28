package com.example.cesargardellim.dm_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;



/**
 * Created by cesargardellim on 12/03/18.
 */

public class RestaurantInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_info);


        Intent in = getIntent();
        int idTest = in.getIntExtra("id",0);
        String name = in.getStringExtra("name");
        String hours = in.getStringExtra("hours");
        String telefone = in.getStringExtra("telefone");
        String options = in.getStringExtra("options");
        String location = in.getStringExtra("location");

        hours = "Funcionamento: " + hours;
        telefone = "Telefone: " + telefone;
        options = "Opções: " + options;
        location = "Localização: " + location;

        //TextView txvTeste = (TextView)findViewById(R.id.txvTeste);
        //txvTeste.setText(idTest);

        ListView LVNamesInfo = (ListView)findViewById(R.id.LVNamesInfo);

        List<String> test = new LinkedList<String>();
        setTitle(name);
        //test.add(name);
        test.add(hours);
        test.add(telefone);
        test.add(options);
        test.add(location);

        ArrayAdapter<String> adapterTest = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,test    );
        LVNamesInfo.setAdapter(adapterTest);


    }// onCreate



}//RestaurantInfo
