package com.migueling.tarearecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miAppBar);
        setSupportActionBar(myToolbar);

        inicializarViews();
        inicializarLayotManager();
        inicializarMascotas();
        inicializarAdapter();
    }

    public void inicializarViews(){
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasMain);
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
        mascotas.add(new Mascota("Black",1,R.drawable.blackbird));
        mascotas.add(new Mascota("Blue",1,R.drawable.bluebird));
        mascotas.add(new Mascota("Green",1,R.drawable.greenbird));
        mascotas.add(new Mascota("Red",1,R.drawable.redbird));
        mascotas.add(new Mascota("White",1,R.drawable.whitebird));
        mascotas.add(new Mascota("Yellow",1,R.drawable.yellowbird));
    }

    public void mostrarFavoritos(){
        Intent intent = new Intent(this, MascotasFavoritasActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.btnFavoritos:
                mostrarFavoritos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
