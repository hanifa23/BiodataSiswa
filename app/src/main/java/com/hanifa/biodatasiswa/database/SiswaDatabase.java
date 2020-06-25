package com.hanifa.biodatasiswa.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hanifa.biodatasiswa.model.KelasModel;
import com.hanifa.biodatasiswa.model.SiswaModel;

/**
 * Created by Hanifatus sholiha on 22/06/2020.
 */


@Database(entities = { KelasModel.class, SiswaModel.class}, version = 1, exportSchema = false)
public abstract class SiswaDatabase extends RoomDatabase{

    public abstract KelasDao kelasDao();

    private static SiswaDatabase INSTANCE;

    // Membuat method return untuk membuat database

    public static SiswaDatabase createDatabase(Context context){
        synchronized (SiswaDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, SiswaDatabase.class, "db_siswa")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
