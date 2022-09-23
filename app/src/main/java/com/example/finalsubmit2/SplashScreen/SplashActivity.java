package com.example.finalsubmit2.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.finalsubmit2.R;
import com.example.finalsubmit2.SetUpActivity.SetUpActivity;
import com.example.finalsubmit2.SetUpActivity.SetUpFragment;


public class SplashActivity extends AppCompatActivity {
     SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To hide taskBar at splash screen
        getSupportActionBar().hide();
        // To stop splash screen for 1500ms
        Thread  thread=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        // Intent for move splash screen to setup screen
        Intent intent=new Intent(SplashActivity.this,SetUpActivity.class);
        startActivity(intent);
    }
}