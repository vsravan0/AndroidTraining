package com.edu.sra.trainings.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.edu.sra.trainings.R;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.core.auth.AccessTokenManager;
import com.uber.sdk.android.core.auth.AuthenticationError;
import com.uber.sdk.android.core.auth.LoginButton;
import com.uber.sdk.android.core.auth.LoginCallback;
import com.uber.sdk.android.core.auth.LoginManager;
import com.uber.sdk.core.auth.AccessToken;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.SessionConfiguration;

import java.util.Arrays;

import static com.uber.sdk.android.core.utils.Preconditions.checkNotNull;
import static com.uber.sdk.android.core.utils.Preconditions.checkState;

public class ActivityUber extends AppCompatActivity implements LoginCallback {
    SessionConfiguration config;
    LoginManager loginManager;
    private Context mCtx;
    private String TAG = "Login";
    private LoginButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uber);
        mCtx = getApplicationContext();
        loadUber();


    }

    private void loadUber() {


        config = new SessionConfiguration.Builder().
                setClientId(Constants.CLIENT_ID)
                .setServerToken(Constants.SERVER_TOKEN)
                .setClientSecret(Constants.CLIENT_SECRET)
                .setRedirectUri("https://login.uber.com/oauth/authorize")
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.RIDE_WIDGETS))


                .setEnvironment(SessionConfiguration.Environment.SANDBOX).build();

        validateConfiguration(config);


        UberSdk.initialize(config);
    }

    private void validateConfiguration(SessionConfiguration configuration) {
        String nullError = "%s must not be null";
        String sampleError = "Please update your %s in the gradle.properties of the project before " +
                "using the Uber SDK Sample app. For a more secure storage location, " +
                "please investigate storing in your user home gradle.properties ";


        checkNotNull(configuration, String.format(nullError, "SessionConfiguration"));
        checkNotNull(configuration.getClientId(), String.format(nullError, "Client ID"));
        checkNotNull(configuration.getRedirectUri(), String.format(nullError, "Redirect URI"));
        checkState(!configuration.getClientId().equals("insert_your_client_id_here"),
                String.format(sampleError, "Client ID"));
        checkState(!configuration.getRedirectUri().equals("insert_your_redirect_uri_here"),
                String.format(sampleError, "Redirect URI"));
    }

    public void loginUber(View view) {
        Log.v(TAG, "Login Uber ");

        login();
    }

    private void login() {

        AccessTokenManager accessTokenManager = new AccessTokenManager(mCtx);
        loginManager = new LoginManager(accessTokenManager, this);
        loginManager.login(ActivityUber.this);
        toast("login");


    }

    @Override
    public void onLoginCancel() {
        Log.v(TAG, "onLoginCancel ");
        toast("onLoginCancel");


    }

    @Override
    public void onLoginError(@NonNull AuthenticationError error) {
        Log.v(TAG, "onLoginError " + error.toString());
        toast("onLoginError ->>" + error.toString());


    }

    @Override
    public void onLoginSuccess(@NonNull AccessToken accessToken) {
        Log.v(TAG, "onLoginSuccess");
        toast("onLoginSuccess");


    }

    @Override
    public void onAuthorizationCodeReceived(@NonNull String authorizationCode) {
        Log.v(TAG, "onAuthorizationCodeReceived ");
        toast("onAuthorizationCodeReceived");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(TAG, "onActivityResult " + requestCode + " resultCode:" + resultCode);


        Log.i(TAG, String.format("onActivityResult requestCode:[%s] resultCode [%s]",
                requestCode, resultCode));


        loginManager.onActivityResult(this, requestCode, resultCode, data);
        toast("onActivityResult");

    }


    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), " msg :" + msg, Toast.LENGTH_LONG).show();

    }
}
