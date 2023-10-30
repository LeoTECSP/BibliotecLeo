package com.example.bibliotecchido;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bibliotecchido.db.dbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;
    //este al iniciar la aplicacion(Automatico)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);

        dbHelper DbHelper = new dbHelper(MainActivity.this);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        if (db != null) {
            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "" + db + "", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
        }
        /**
        //Hasta que se clic al boton
        btnCrear.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                dbHelper DbHelper = new dbHelper(MainActivity.this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "" + db + "", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        **/
    }
}

