package com.example.finalsubmit2.DetailsScreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalsubmit2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    private Button btnDialog;
    private AlertDialog.Builder builder;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "optionA";
    private static final String ARG_PARAM3 = "optionB";
    private static final String ARG_PARAM4 = "optionC";
    private static final String ARG_PARAM5 = "optionD";
    private static final String ARG_PARAM6= "id";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2,mParam3,mParam4,mParam5;
    private int id;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String mParam1, String[] mcq, int id) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,mParam1);
        args.putString(ARG_PARAM2,mcq[0]);
        args.putString(ARG_PARAM3,mcq[1]);
        args.putString(ARG_PARAM4,mcq[2]);
        args.putString(ARG_PARAM5,mcq[3]);
        args.putInt(ARG_PARAM6,id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            id=getArguments().getInt(ARG_PARAM6);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_details, container, false);
        btnDialog=view.findViewById(R.id.btnSubmitDetails);
        builder=new AlertDialog.Builder(getContext());
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Alert!!")
                        .setMessage("Do you want to submit quiz?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"I am yes",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
            }
        });
        TextView textView=view.findViewById(R.id.question);
        TextView textView1=view.findViewById(R.id.optionA);
        TextView textView2=view.findViewById(R.id.optionB);
        TextView textView3=view.findViewById(R.id.optionC);
        TextView textView4=view.findViewById(R.id.optionD);

        textView.setText(id+".) "+mParam1);
        textView1.setText("A) "+mParam2);
        textView2.setText("B) "+mParam3);
        textView3.setText("C) "+mParam4);
        textView4.setText("D) "+mParam5);
        return view;
    }
}