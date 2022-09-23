package com.example.finalsubmit2.SetUpActivity;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalsubmit2.QuestionsListScreen.QuestionsListFragment;
import com.example.finalsubmit2.R;

public class SetUpFragment extends Fragment {
     Button button1,button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1=inflater.inflate(R.layout.fragment_set_up, container, false);
        button1=view1.findViewById(R.id.btnBack);
        button2=view1.findViewById(R.id.btnStart);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                System.exit(0);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new QuestionsListFragment();
                FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.setUpContainer, fragment);
                fragmentTransaction.commit();
            }
        });
        return  view1;

    }

}