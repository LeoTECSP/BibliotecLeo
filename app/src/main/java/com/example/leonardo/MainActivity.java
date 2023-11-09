package com.example.leonardo;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

import com.example.leonardo.db.dbHelper;
import com.example.leonardo.db.dbBibliteca;

public class MainActivity extends AppCompatActivity {
    //Buton btnGuardar
    //Crear las variables con la que vamos a trabajar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper DbHelper = new dbHelper(MainActivity.this);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        if (db != null) {
            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "" + db + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
        }


        EditText txtGenero, txtAutor, txtEditorial, txtPublicacion, txtPaginas, txtTitulo, txtISBN;

        //Mandar los valores de las casillas a las variables editext

        txtTitulo = findViewById(R.id.txtTitulo);
        txtAutor = findViewById(R.id.txtAutor);
        txtEditorial = findViewById(R.id.txtEditorial);
        txtPaginas = findViewById(R.id.txtPaginas);
        txtPublicacion = findViewById(R.id.txtPublicacion);
        txtGenero = findViewById(R.id.txtGenero);
        txtISBN = findViewById(R.id.txtISBN);
        Button btnModificar = findViewById(R.id.superboton);
        Button btnGuardar = findViewById(R.id.button);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbBibliteca DBBibliteca = new dbBibliteca(MainActivity.this);
                long id = DBBibliteca.insertarlibro(txtTitulo.getText().toString(),
                        txtAutor.getText().toString(), txtEditorial.getText().toString(),
                        txtGenero.getText().toString(),
                        Integer.valueOf(txtPublicacion.getText().toString()),
                        Integer.parseInt( String.valueOf((txtPaginas.getText()))));


                if(id>0)
                {
                    Toast.makeText(MainActivity.this, "Registro Guardado", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbBibliteca DBBibliteca = new dbBibliteca(MainActivity.this);
                long id = DBBibliteca.eliminarLibro(
                        Integer.parseInt((txtISBN.getText().toString())));


                if(id>0)
                {
                    Toast.makeText(MainActivity.this, "Borrado exitosamente", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this, "ERROR AL BORRAR", Toast.LENGTH_SHORT).show();
                }
            }
        });







                btnModificar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dbBibliteca DBbiblioteca = new dbBibliteca(MainActivity.this);
                        long id = DBbiblioteca.modificarlibro
                                (Integer.parseInt(String.valueOf(txtISBN.getText())), txtTitulo.getText().toString(), txtAutor.getText().toString(),
                                        txtEditorial.getText().toString(), txtGenero.getText().toString(),
                                        Integer.valueOf(txtPublicacion.getText().toString()),
                                        Integer.parseInt(String.valueOf(txtPaginas.getText())));

                        if (id > 0)
                        {
                            Toast.makeText(MainActivity.this, "Registro Modificado", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "algo salio mal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });










    }


}