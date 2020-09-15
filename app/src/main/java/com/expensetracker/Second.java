package com.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // on click image method for income class
        ImageView imageIncome = (ImageView) findViewById(R.id.incomeImage);
        imageIncome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                 Toast.makeText(Second.this,"Enter your new income", Toast.LENGTH_LONG).show();
                 Intent intent = new Intent(Second.this, Income.class);
                 startActivity(intent);
            }
        });

        //on click image method for expense class
       ImageView imageExpense = (ImageView) findViewById(R.id.expenseImage);
        imageExpense.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               Toast.makeText(Second.this,"Enter your new expense", Toast.LENGTH_LONG).show();
               Intent intent = new Intent(getApplicationContext(), Expense.class);
               startActivity(intent);
            }
        });

        //on click image method for history class
        ImageView history = (ImageView) findViewById(R.id.record_view_img);
        history.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Second.this,"You clicked on record history", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(), History.class);
                startActivity(intent1);
            }
        });

        //on click image method for Finance class
        ImageView fin_sugg = (ImageView) findViewById(R.id.financial_suggestion_img);
        fin_sugg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Second.this,"You clicked on financial suggestion", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getApplicationContext(), Finance.class);
                startActivity(intent2);
            }
        });


        //on click image method for Consult class
        ImageView book_cons = (ImageView) findViewById(R.id.book_consult_img);
        book_cons.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Second.this,"You clicked on book consulting", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(getApplicationContext(), Consult.class);
                startActivity(intent3);
            }
        });



        //on click image method for Invest class
        ImageView invest_adv = (ImageView) findViewById(R.id.invest_advice_img);
        invest_adv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Second.this,"You clicked on investment advice", Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(getApplicationContext(), Invest.class);
                startActivity(intent4);
            }
        });

        //on click image method for Setting class
        ImageView setting = (ImageView) findViewById(R.id.setting_img);
        setting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Second.this,"You clicked on setting", Toast.LENGTH_LONG).show();
                Intent intent5 = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent5);
            }
        });


        //on click image method for about application
        ImageView imageSettings = (ImageView) findViewById(R.id.about_app_img);
        imageSettings.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               Toast.makeText(Second.this,"You clicked on about Expense Tracker application", Toast.LENGTH_LONG).show();
                Intent intent6 = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent6);
            }
        });




    }

}


