package com.example.finalsubmit2.QuestionsListScreen;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.example.finalsubmit2.DetailsScreen.DetailsFragment;
import com.example.finalsubmit2.R;
import com.example.finalsubmit2.SetUpActivity.SetUpActivity;
import com.example.finalsubmit2.SetUpActivity.SetUpFragment;

import java.nio.charset.CoderMalfunctionError;
import java.text.DecimalFormat;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.viewHolder> {

    private List<Model> Ques_List;
    private ItemClickListener clickListener;
    public QuestionsAdapter(List<Model> ques_List, ItemClickListener clickListener) {
        this.Ques_List = ques_List;
        this.clickListener=  clickListener;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new viewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        Model model=Ques_List.get(position);
        holder.tvForID.setText("Question "+model.getId());
        holder.tvForTitle.setText(model.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             clickListener.onItemClick(model);
            }
        });

    }
    @Override
    public int getItemCount() {
        return Ques_List.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvForTitle;
        TextView tvForID;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvForID=itemView.findViewById(R.id.tvID);
            tvForTitle=itemView.findViewById(R.id.tvTitle);

        }
    }
    interface ItemClickListener{
        public void onItemClick(Model model);
    }
}
