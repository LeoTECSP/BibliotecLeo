package com.example.leonardo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 *  Crear base de datos
 *
 *  se hizo una herencia.
 */

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_Version = 1;
    private static final String DATABASE_NAME = "Biblioteca";
    public static final String DATABASE_TABLE = "Libros";

    public dbHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE " + DATABASE_TABLE + "(" +
                "ISBN  INTEGER PRIMARY KEY," +
                "TITULO VARCHAR(100)," +
                "AUTOR VARCHAR(100)," +
                "EDITORIAL VARCHAR(50)," +
                "GENERO VARCHAR(30)," +
                "A_PUBLICACION INT," +
                "NO_PAGINAS INT)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int j)
        {
            sqLiteDatabase.execSQL("DROP TABLE "+ DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

