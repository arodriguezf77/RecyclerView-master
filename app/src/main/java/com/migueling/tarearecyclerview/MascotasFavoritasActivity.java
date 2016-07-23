package com.migueling.tarearecyclerview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar appBar = (Toolbar) findViewById(R.id.miAppBar);
        setSupportActionBar(appBar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        inicializarViews();
        inicializarLayotManager();
        inicializarMascotas();
        inicializarAdapter();
    }

    public void inicializarViews(){
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
    }

    public void inicializarLayotManager(){
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
    }

    public void inicializarAdapter(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        rvMascotas.setLayoutManager(llm);
        rvMascotas.setAdapter(adapter);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Yellow",10,R.drawable.yellowbird));
        mascotas.add(new Mascota("White",8,R.drawable.whitebird));
        mascotas.add(new Mascota("Black",7,R.drawable.blackbird));
        mascotas.add(new Mascota("Blue",6,R.drawable.bluebird));
        mascotas.add(new Mascota("Green",4,R.drawable.greenbird));
    }
}
