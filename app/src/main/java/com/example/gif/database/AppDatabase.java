package com.example.gif.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FeedbackData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FeedbackDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase initDB(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbFeedback").allowMainThreadQueries().build();

        }
        return appDatabase;
    }
}
