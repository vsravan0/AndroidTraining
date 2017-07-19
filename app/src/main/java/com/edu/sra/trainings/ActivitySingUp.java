package com.edu.sra.trainings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.edu.sra.trainings.utils.EntityUser;
import com.edu.sra.trainings.utils.MyUtils;

public class ActivitySingUp extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Training:ActivitySingUp";
    private EditText mEtUserName,mEtPassword,mEtEmail;
    private Button mBtnSingUp, mBtnClear;
    private RadioButton mRbMale, mRbFemale;
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
        mBtnSingUp = (Button) findViewById(R.id.id_btn_login_signup);
        mRbFemale=(RadioButton) findViewById(R.id.id_rb_femaile);
        mRbMale = (RadioButton) findViewById(R.id.id_rb_maile);
        mCbTerms=(CheckBox) findViewById(R.id.id_checkbox);
        mSpCountries=(Spinner)findViewById(R.id.id_sp_countries);
        mBtnClear.setOnClickListener(this);
        mBtnSingUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_clear:
                clearAllFields();
                break;
            case R.id.id_btn_login_signup:
                sigUp();
                break;
        }
    }

    private void clearAllFields(){
        mEtEmail.setText("");
        mEtPassword.setText("");
        mEtUserName.setText("");
        mRbFemale.setChecked(false);
        mRbMale.setChecked(false);
        mCbTerms.setChecked(false);
        mSpCountries.setSelection(0);
    }

    private void sigUp() {

        String email = mEtEmail.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String userName = mEtUserName.getText().toString().trim();
        boolean isMale = false;
        if (mRbMale.isChecked()) {
            isMale = true;
        } else if (mRbFemale.isChecked()) {
            isMale = false;
        } else {

            showTost("Please Select Gender");
        }

        boolean isAcceptedTerms = mCbTerms.isChecked();
        if (!isAcceptedTerms) {
            showTost("Please Accept Terms");
        }

        String country = mSpCountries.getSelectedItem().toString();

        if (email == null || email.length() == 0 || !MyUtils.isEmailValid(email)) {
            mEtEmail.setError("Please Enter valid Email");
            return;
        } else if (password == null || password.length() == 0) {
            mEtPassword.setError("Please Enter valid Email");
            return;
        } else if (userName == null || userName.length() == 0) {
            mEtUserName.setError("Please Enter valid username");
            return;
        }


        EntityUser user = new EntityUser(userName, email, password, isMale);
        long insertedId = MyUtils.saveUserDataInDb(getApplicationContext(), user);
        if (insertedId != -1) {
            showTost("Saved successfully rowId :" + insertedId);
        } else {
            showTost("Some error :" + insertedId);
        }

        finish(); // Remove Activity from Android stack

    }


    private void showTost(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        Log.d(TAG, " msg :" + msg);
    }
}
