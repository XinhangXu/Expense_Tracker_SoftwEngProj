package com.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Info.setText("It will be disable in: 5");

        // on click login method
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
  }

    //validate the username and password
    private void validate(String userName, String userPassword){
        if((userName.equals("a"))&&(userPassword.equals("a"))){
            Intent intent = new Intent(Login.this, Second.class);
            startActivity(intent);
        } else{
            // to count the number of attempts
            counter--;
            // to disable login button
            Info.setText("It will be disable in: "+ String.valueOf(counter));
            if(counter ==0){
                Login.setEnabled(false);
            }
        }
    }
}
