package com.example.myapplicationfragments.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplicationfragments.model.Usuario;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class NoticiasDataBase extends RoomDatabase {

    public abstract NoticiasDao dao();
    private static NoticiasDataBase INSTANCE;

    public static NoticiasDataBase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (NoticiasDataBase.class) {
                INSTANCE = Room.databaseBuilder(context, NoticiasDataBase.class, "app-db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
