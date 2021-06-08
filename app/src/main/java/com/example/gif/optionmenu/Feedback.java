package com.example.gif.optionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gif.R;
import com.example.gif.database.AppDatabase;
import com.example.gif.database.FeedbackData;

public class Feedback extends AppCompatActivity {
    private EditText et_username,et_feedback;
    private Button btn_kirim;
    private AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        appDatabase = AppDatabase.initDB(getApplicationContext());

        et_username = findViewById(R.id.et_username);
        et_feedback = findViewById(R.id.et_feedback);
        btn_kirim = findViewById(R.id.btn_kirim);

        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    insertData();
                    Intent intent = new Intent(Feedback.this, FeedbackList.class);
                    startActivity(intent);

                    Log.e("Feedback","terkirim");
                    Toast.makeText(getApplicationContext(),"Berhasim Mengirim", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("Feedback","gagal kirim, msg :"+ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Gagal Mengirim", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void insertData(){
        FeedbackData feedbackData = new FeedbackData();
        feedbackData.setUsername(et_username.getText().toString());
        feedbackData.setFeedback(et_feedback.getText().toString());

        appDatabase.dao().insertData(feedbackData);

        et_username.setText("");
        et_feedback.setText("");
    }

}
