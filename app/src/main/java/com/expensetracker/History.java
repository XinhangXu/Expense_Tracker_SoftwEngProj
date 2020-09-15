package com.expensetracker;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.expensetracker.Database.DataModel;
import com.expensetracker.Database.DatabaseClass;
import com.expensetracker.Database.list_adapter;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase database;
    ArrayList<DataModel> list;
    list_adapter listAdapter;
    DatabaseClass databaseClass;
    Button bt_switch_income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = (ListView) findViewById(R.id.list_view);
        bt_switch_income = (Button) findViewById(R.id.bt_viewIncome);

        // switch to activity HisoryIn (view income record
/*        bt_switch_income.setOnClickListener((v)->{
            Intent intent = new Intent(this, Historyin.class);
            startActivity(intent);
            //finish();
        });*/

        bt_switch_income.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(History.this, "Button Works", Toast.LENGTH_LONG).show();
                try{
                    Intent intent = new Intent(getApplicationContext(), Historyincm.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        list=new ArrayList<>();
        databaseClass=new DatabaseClass(History.this);
        listAdapter=new list_adapter(this,R.layout.list_row,list);
        listView.setAdapter(listAdapter);

        database=databaseClass.getReadableDatabase();

        Cursor cr=database.rawQuery("Select * from expense ",null);

        StringBuilder stringBuilder=new StringBuilder();
        while (cr.moveToNext()) {
            int id=cr.getInt(0);
            String amount=cr.getString(1);
            String category=cr.getString(2);
            String description=cr.getString(3);
            String date=cr.getString(4);
            String image=cr.getString(5);
            String spinner=cr.getString(6);
            list.add(new DataModel(id,amount,category,description,date,image,spinner));
        }
    }
}