package com.androidwave.cleancode.data.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.androidwave.cleancode.data.db.dao.UserDao;
import com.androidwave.cleancode.data.db.model.User;


/**
 * Created on : Feb 01, 2019
 * Author     : AndroidWave
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;
    private static final String DATABASE_NAME = "wave-database";

    public abstract UserDao userDao();

    public synchronized static AppDatabase getDatabaseInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

    public static void destroyInstance() {
        mInstance = null;
    }

}