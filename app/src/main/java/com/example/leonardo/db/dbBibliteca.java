package com.example.leonardo.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

//ponemos extends porque vamos a hederar de la clase dbhelper
public class dbBibliteca extends dbHelper{

    Context context;
    //Procurar el método no llamarlo igual que la clase
    public dbBibliteca(@Nullable Context context){
        //Heredamos de la clase padre dbHelper
        super(context);

        //Asignamos el contexto actual con el que trae nuestro constructor
        this.context = context;
    }



    //Creamos un constructor con los parámetros necesarios para insertar el registro en nuestra tabla
    //Para los parámetros a insertar la tabla
    public long insertarlibro(String titulo, String autor,String editorial, String genero, Integer añopublicacion, Integer paginas){

        //Creamos un objeto DBHelper para realizar la escritura de los datos usaremos
        //Creando un objeto db de la clase DBHelper y vamos a escribir en nuestra base de datos
        dbHelper DBHelper = new dbHelper(context);
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TITULO",titulo);
        values.put("AUTOR",autor);
        values.put("EDITORIAL",editorial);
        values.put("GENERO",genero);
        values.put("A_PUBLICACION",añopublicacion);
        values.put("NO_PAGINAS",paginas);


        long id= db.insert(DATABASE_TABLE, null, values);
        return id;


    }



    //Buscar un ISBN que sea como este
    public long eliminarLibro (int ISBN)
    {

        //COntext para consultas de SQLite
        dbHelper DBHelper = new dbHelper(context);
        SQLiteDatabase db = DBHelper.getWritableDatabase();


        //La tabla con la que trabajamos, el segundo es la clausula where, ponemos lo que coincida con la caja

        //Se deja nulo porque en WHERE
        long id = db.delete(DATABASE_TABLE,"ISBN = " + ISBN,null);
        return id;



    }


    public long modificarlibro (Integer ISBN, String titulo, String autor, String editorial, String genero, Integer añopublicacion, Integer paginas)
    {
        dbHelper DBhelper = new dbHelper(context);
        SQLiteDatabase db = DBhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TITULO", titulo);
        values.put("AUTOR", autor);
        values.put("EDITORIAL", editorial);
        values.put("GENERO", genero);
        values.put("A_PUBLICACION", añopublicacion);
        values.put("NO_PAGINAS", paginas);

        long id = db.update(DATABASE_TABLE, values, "ISBN = " + ISBN, null);
        return id;
    }


}
