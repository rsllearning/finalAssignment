package com.example.finalsubmit2.QuestionsListScreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalsubmit2.DetailsScreen.DetailsFragment;
import com.example.finalsubmit2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class QuestionsListFragment extends Fragment  {
    private Button btnDialog;
    private AlertDialog.Builder builder;
     private  List<Model> list=new ArrayList<>();
     private RecyclerView recyclerView;
     QuestionsAdapter adapter;
     String URL="https://raw.githubusercontent.com/tVishal96/sample-english-mcqs/master/db.json";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_questions_list, container, false);
        btnDialog=view.findViewById(R.id.btnSubmit);
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
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getData();
        return view;
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("questions");
                    if(jsonArray.length()>0){
                        for(int i=0;i<jsonArray.length();i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            int id = Integer.parseInt(jsonObject1.getString("id"));
                            String question = jsonObject1.getString("question");
                            int correct_option = Integer.parseInt(jsonObject1.getString("correct_option"));
                            String[] arr = jsonObject1.getString("options").split(",");
                            list.add(new Model(id, question, correct_option, arr));

                        }
                        adapter = new QuestionsAdapter(list, new QuestionsAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(Model model) {
                                Fragment fragment = DetailsFragment.newInstance(model.getTitle(),model.getMCQ(),model.getId());
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.setUpContainer, fragment, "detail_fragment").addToBackStack(null);
                                transaction.commit();
                            }
                        });
                        recyclerView.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.getMessage());
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
   queue.add(stringRequest);
    }

}