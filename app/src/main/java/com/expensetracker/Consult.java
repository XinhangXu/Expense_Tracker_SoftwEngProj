package com.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.expensetracker.Database.List_adapter_consult;

import java.util.ArrayList;

public class Consult extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        mListView = findViewById(R.id.listView_consult);

        Consultperson consultperson01 = new Consultperson("John", "Financial consulting");
        Consultperson consultperson02 = new Consultperson("Mike", "Business consulting");
        Consultperson consultperson03 = new Consultperson("Kim", "Financial law expert");
        Consultperson consultperson04 = new Consultperson("Robot", "Statistic consulting");
        Consultperson consultperson05 = new Consultperson("Smith", "Data analyst ");
        Consultperson consultperson06 = new Consultperson("Sim", "Financial consulting");
        Consultperson consultperson07 = new Consultperson("Lee", "Business consulting");
        Consultperson consultperson08 = new Consultperson("Breatrice", "Law consulting");

        ArrayList<Consultperson> peopleList = new ArrayList<>();
        peopleList.add(consultperson01);
        peopleList.add(consultperson02);
        peopleList.add(consultperson03);
        peopleList.add(consultperson04);
        peopleList.add(consultperson05);
        peopleList.add(consultperson06);
        peopleList.add(consultperson07);
        peopleList.add(consultperson08);

        List_adapter_consult mAdapter = new List_adapter_consult(Consult.this, R.layout.list_consult, peopleList);
        mListView.setAdapter(mAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Consult.this, "Selected " , Toast.LENGTH_LONG).show();
/*                Intent intent = new Intent(getApplicationContext(), EditRecord.class);
                startActivity(intent);
                finish();*/
            }
        });



    }
}
