package com.edu.sra.trainings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.sra.trainings.utils.MyUtils;

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
                login();
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

    private void login() {

        /*
        EntityUser savedUser = MyUtils.getUserData(getApplicationContext());

        if (savedUser.getUserName().length() == 0) {
            Toast.makeText(getApplicationContext(), " Please Register... ",
                    Toast.LENGTH_LONG).show();
            return;

        } */

        String userName = mEtUserName.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();


        boolean isLoginSuccess = MyUtils.checkUser(getApplicationContext(), userName, password);

        //if (userName.equalsIgnoreCase(savedUser.getUserName()) && password.equals(savedUser.getUserPassword())) {

        if (isLoginSuccess) {
            Intent intent = new Intent(LoginActivity.this, UserDetails.class);
            startActivity(intent);

        } else {


            Toast.makeText(getApplicationContext(), " Wrong Credentials", Toast.LENGTH_LONG).show();

        }



    }
}
