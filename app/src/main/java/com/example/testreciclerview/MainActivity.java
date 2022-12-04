package com.example.testreciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Debemos crear 3 variables, un recicleView, una adapterDatos, la cual será una clase personalizada que hereda de adapte, y un LinearLayoutManager
    private RecyclerView recyclerView;
    private AdapterDatos adapterDatos;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Pillamos el recyclerView del layout
        recyclerView = findViewById(R.id.reciclerView);
        //Creamos un nuevo layoutManager y se lo asignamos al recyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Asignamos el adapterDatos al recyclerView
        adapterDatos = new AdapterDatos(this);
        recyclerView.setAdapter(adapterDatos);

        for (int i = 0; i < 5; i++) {
            adapterDatos.add(new Item(getDrawable(R.mipmap.ic_launcher),"Texto"+i));
        }

    }
}