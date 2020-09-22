package com.expensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    Button bt_save;
    EditText txt_name, txt_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        bt_save = findViewById(R.id.bt_save_setting);
        txt_name = findViewById(R.id.editText_new_name);
        txt_pwd = findViewById(R.id.editText_new_pwd);

        UserNamePwd userNamePwd = new UserNamePwd();

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNamePwd.setName(txt_name.getText().toString());
                userNamePwd.setPwd(txt_pwd.getText().toString());
                Toast.makeText(Setting.this, "Changes Saved", Toast.LENGTH_LONG).show();
            }
        });

    }
}
