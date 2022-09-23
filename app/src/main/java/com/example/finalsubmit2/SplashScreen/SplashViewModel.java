package com.example.finalsubmit2.SplashScreen;

import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.example.finalsubmit2.SetUpActivity.SetUpActivity;

public class SplashViewModel extends ViewModel {
    public SplashViewModel() {
     executeSplashScreen();
    }
   // execution for 1.5 Sec delay
    public void executeSplashScreen() {

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
    }
}

