package com.example.confix.parqueadero;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txt_search, txt_license;
    Button btn_search, btn_add, btn_delete;
    ListView list_vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_search = findViewById(R.id.txt_search);
        btn_search = findViewById(R.id.btn_search);

        txt_license = findViewById(R.id.txt_license);
        btn_add = findViewById(R.id.btn_add);
        //btn_delete = findViewById(R.id.btn_delete);

        list_vehicle = findViewById(R.id.list_vehicle);

        readAll();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String license = txt_license.getText().toString();
                String time_in = "00:00";
                save(license, time_in);
            }
        });

    }

    public void readAll(){
        List<String> arraylist = new ArrayList<String>();

        BaseDatos baseDatosIntc = new BaseDatos(this, "Polo", null, 1);
        SQLiteDatabase BD = baseDatosIntc.getReadableDatabase();

        Cursor row = BD.rawQuery("SELECT * FROM VEHICLES", null);

        while(row.moveToNext()) {
            arraylist.add(row.getString(0));
        }
        txt_search.setText(arraylist.toString());

        row.close();

        BD.close();
    }


    public void getById(String searchId){
        BaseDatos baseDatosIntc = new BaseDatos(this, "Polo", null, 1);
        SQLiteDatabase BD = baseDatosIntc.getReadableDatabase();

        Cursor row = BD.rawQuery("SELECT * FROM VEHICLES WHERE id=" + searchId, null);

        if(row.moveToFirst()){
            // AQUI SE AGREGA LA LISTA A LA LIST VIEW
        }else{
            Toast.makeText(this, "No Existe vehiculo buscado", Toast.LENGTH_SHORT).show();
        }

        BD.close();
    }

    public void save(String license, String time_in){
        BaseDatos baseDatosIntec = new BaseDatos(  this,"polo", null, 1 );
        SQLiteDatabase BD = baseDatosIntec.getWritableDatabase();

        ContentValues v1 = new ContentValues();
        v1.put("license", license);
        v1.put("time_in", time_in);

        Long valor = BD.insert( "VEHICLES",null, v1);
        Toast.makeText(this, "Guardado!"+valor, Toast.LENGTH_SHORT).show();

        txt_license.setText("");

        BD.close();
    }
}
