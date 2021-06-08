package com.example.gif.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FeedbackDAO {
    @Insert
    long insertData(FeedbackData feedbackData);

    @Query("Select * from feedback_db")
    FeedbackData[] getData();

    @Update
    int updateData(FeedbackData item);

    @Delete
    void deleteData(FeedbackData item);
}
