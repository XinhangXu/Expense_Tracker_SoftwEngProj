package com.expensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Profile extends AppCompatActivity {
    TextView t,version, features, developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //About application texts
        t = findViewById(R.id.textprofile);
        t.setText("Summary\n\n"+"Expense Tracker help you record income and outcome efficiently. \n");
        version = findViewById(R.id.textVersion);
        version.setText("Version 2.1\n");
        features = findViewById(R.id.textFeatures);
        features.setText("Features\n\n"+"•\tBased on Android Studio\n"
                                    +"•\tFriendly user interface & simple design\n"
                                    +"•\tAdd new incomes & expenses\n"
                                    +"•\tSave incomes & expenses\n"
                                    +"•\tCreate user own description\n"
                                    +"•\tAble to select date and save data\n"
                                    +"•\tUpload images and save images\n"
                                    +"•\tExpense Tracker");
    }
}
