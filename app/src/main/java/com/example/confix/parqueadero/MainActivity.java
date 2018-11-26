package com.example.confix.parqueadero;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        BaseDatos baseDatosIntc = new BaseDatos(this, "Polo", null, 1);
        SQLiteDatabase BD = baseDatosIntc.getReadableDatabase();

        Cursor row = BD.rawQuery("SELECT * FROM table_vehicle", null);
    }

    public void getById(String searchId){
        BaseDatos baseDatosIntc = new BaseDatos(this, "Polo", null, 1);
        SQLiteDatabase BD = baseDatosIntc.getReadableDatabase();

        Cursor row = BD.rawQuery("SELECT * FROM table_vehicle WHERE id=" + searchId, null);

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

        Long valor = BD.insert( "table_vehicle",null, v1);
        Toast.makeText(this, "Guardado!"+valor, Toast.LENGTH_SHORT).show();

        txt_license.setText("");
    }
}
