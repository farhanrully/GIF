package com.example.gif.optionmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gif.R;
import com.example.gif.database.FeedbackData;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {
    private List<FeedbackData> feedbackDataArrayList;
    Context context;

    public FeedbackAdapter(List<FeedbackData> feedbackDataArrayList, Context context) {
        this.feedbackDataArrayList = feedbackDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeedbackData feedbackData = feedbackDataArrayList.get(position);
        holder.tv_username.setText(feedbackData.getUsername());
        holder.tv_feedback.setText(feedbackData.getFeedback());
    }

    @Override
    public int getItemCount() {
        return feedbackDataArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_username, tv_feedback;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_feedback = itemView.findViewById(R.id.tv_feedback);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
