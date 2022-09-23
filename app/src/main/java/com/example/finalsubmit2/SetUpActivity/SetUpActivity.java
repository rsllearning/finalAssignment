package com.example.finalsubmit2.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.finalsubmit2.R;

public class SetUpActivity extends AppCompatActivity {
     RecyclerView recyclerView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        Fragment fragment=new SetUpFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.setUpContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
//        recyclerView=findViewById(R.id.setUpContainer);


    }
}