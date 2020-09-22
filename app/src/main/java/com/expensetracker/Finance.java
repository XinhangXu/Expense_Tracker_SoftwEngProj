package com.expensetracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.expensetracker.Database.DataModel;
import com.expensetracker.Database.DatabaseClass;
import com.expensetracker.spinner_category.CategoryAdapter;
import com.expensetracker.spinner_category.CategoryItems;

import java.util.ArrayList;
import java.util.List;

public class Finance extends AppCompatActivity {

    TextView textView_total_income, textView_total_expense, textView_category_expense, textView_financial_suggestion;
    Spinner spinner_category;
    private CategoryAdapter mCategoryAdapter;
    String clickedCategoryName;
    private ArrayList<CategoryItems> mCategoryList;
    public static DatabaseClass databaseClass;
    SQLiteDatabase database;
    String mList; //to store all expense amount records from db


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        textView_total_income = findViewById(R.id.txt_total_income);
        textView_total_expense = findViewById(R.id.txt_total_expense);
        textView_category_expense = findViewById(R.id.txt_category_expense);
        textView_financial_suggestion = findViewById(R.id.txt_financial_suggestion);
        spinner_category = findViewById(R.id.spinner_category_finance);
        databaseClass = new DatabaseClass(Finance.this);

        initList_spinnerList();
        //create spinner
        mCategoryAdapter = new CategoryAdapter(this, mCategoryList);
        spinner_category.setAdapter(mCategoryAdapter);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoryItems categoryItems = (CategoryItems) parent.getItemAtPosition(position);
                clickedCategoryName = categoryItems.getCategoryName(); //clickedTypeName
                //Toast.makeText(AddRecord.this, clickedCategoryName + " SELECTED", Toast.LENGTH_SHORT).show();
                textView_category_expense.setText("Suggestion for category " + clickedCategoryName );
                textView_financial_suggestion.setText("You spent reasonable amount of " + clickedCategoryName);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        database=databaseClass.getReadableDatabase();
        Cursor cr=database.rawQuery("Select * from expense ",null);
        while (cr.moveToNext()) {
            mList = cr.getString(1);
        }


// Have not implemented some functions:
        // Get total expense from database
        // Get a certain category total expense




    }


    private void initList_spinnerList(){
        mCategoryList = new ArrayList<>();
        mCategoryList.add(new CategoryItems("Food", R.drawable.food_ctgry_icon));
        mCategoryList.add(new CategoryItems("Clothes", R.drawable.clothes_ctgry_icon));
        mCategoryList.add(new CategoryItems("Education", R.drawable.education_ctgry_icon));
        mCategoryList.add(new CategoryItems("Exercise", R.drawable.exercise_ctgry_icon));
        mCategoryList.add(new CategoryItems("Entertainment", R.drawable.entertainment_ctgry_icon));
        mCategoryList.add(new CategoryItems("Family", R.drawable.family_ctgry_icon));
        mCategoryList.add(new CategoryItems("Grocery", R.drawable.groccery_ctgry_icon));
        mCategoryList.add(new CategoryItems("Snack", R.drawable.snack_ctgry_icon));
        mCategoryList.add(new CategoryItems("Hospital", R.drawable.hospital_ctgry_icon));
        mCategoryList.add(new CategoryItems("House", R.drawable.house_ctgry_icon));
        mCategoryList.add(new CategoryItems("Car", R.drawable.car_ctgry_icon));
        mCategoryList.add(new CategoryItems("Transportation", R.drawable.transportation_ctgry_icon));
        mCategoryList.add(new CategoryItems("Travel", R.drawable.travel_ctgry_icon));
        mCategoryList.add(new CategoryItems("Telephone", R.drawable.telephone_ctgry_icon));
        mCategoryList.add(new CategoryItems("Socialize", R.drawable.social_ctgry_icon));
        /////////////////////////// copy
        /////////////////////////// change img
    }




}
