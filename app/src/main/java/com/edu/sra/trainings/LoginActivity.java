package com.edu.sra.trainings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEtUserName,mEtPassword;
    private Button mbtnLogin,mBtnSingup;
    private String TGA="LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        mEtPassword=(EditText)findViewById(R.id.id_et_password);
        mEtUserName=(EditText)findViewById(R.id.id_et_username);
        mbtnLogin=(Button) findViewById(R.id.id_btn_login);
        mBtnSingup=(Button)findViewById(R.id.id_btn_signup);
        mBtnSingup.setOnClickListener(this);
        mbtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.id_btn_login :

                break;
            case R.id.id_btn_signup :
                showSignUp();
                break;
        }
    }

    private void showSignUp(){

        Intent intent= new Intent(LoginActivity.this,ActivitySingUp.class);
        startActivity(intent);
    }
}
