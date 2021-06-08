package com.example.gif.optionmenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gif.R;
import com.example.gif.database.AppDatabase;
import com.example.gif.database.FeedbackDAO;
import com.example.gif.database.FeedbackData;
import com.example.gif.optionmenu.FeedbackAdapter;

import java.util.Arrays;
import java.util.List;

public class FeedbackList extends AppCompatActivity {

    List<FeedbackData> feedbackData;
    AppDatabase appDatabase;
    FeedbackDAO feedbackDAO;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_list);
        appDatabase = AppDatabase.initDB(this);
        feedbackDAO = appDatabase.dao();

        recyclerView = findViewById(R.id.list_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        read();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public void read(){
        feedbackData = Arrays.asList(feedbackDAO.getData());

        FeedbackAdapter adapter = new FeedbackAdapter(feedbackData, this);
        recyclerView.setAdapter(adapter);
    }

}
