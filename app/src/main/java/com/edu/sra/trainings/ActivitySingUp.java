package com.edu.sra.trainings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class ActivitySingUp extends AppCompatActivity implements View.OnClickListener{

    private EditText mEtUserName,mEtPassword,mEtEmail;
    private Button mBtnLogin,mBtnClear;
    private RadioButton mRbMail,mRbFemale;
    private Spinner mSpCountries;
    private CheckBox mCbTerms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_singup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findIds();


    }

    private void findIds(){


        mEtEmail=(EditText)findViewById(R.id.id_et_mail);
        mEtPassword=(EditText)findViewById(R.id.id_et_password_signup);
        mEtUserName=(EditText)findViewById(R.id.id_et_username_signup);
        mBtnClear=(Button) findViewById(R.id.id_btn_clear);
        mBtnLogin=(Button) findViewById(R.id.id_btn_login_signup);
        mRbFemale=(RadioButton) findViewById(R.id.id_rb_femaile);
        mRbMail=(RadioButton)findViewById(R.id.id_rb_maile);
        mCbTerms=(CheckBox) findViewById(R.id.id_checkbox);
        mSpCountries=(Spinner)findViewById(R.id.id_sp_countries);
        mBtnClear.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.id_btn_clear:
                clearAllFields();
                break;
            case R.id.id_btn_login_signup:

                break;
        }
    }

    private void clearAllFields(){

        mEtEmail.setText("");
        mEtPassword.setText("");
        mEtUserName.setText("");
        mRbFemale.setChecked(false);
        mRbMail.setChecked(false);
        mCbTerms.setChecked(false);
        mSpCountries.setSelection(0);
    }
}
