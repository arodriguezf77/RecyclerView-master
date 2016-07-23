package com.migueling.tarearecyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgFotoCv.setImageResource(mascota.getFoto());
        holder.tvNombreCv.setText(mascota.getNombre());
        holder.tvLikesCv.setText(("" + mascota.getNoLikes()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setNoLikes(mascota.getNoLikes()+1);
                holder.tvLikesCv.setText(("" + mascota.getNoLikes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCv;
        private ImageButton btnLike;
        private TextView tvNombreCv;
        private TextView tvLikesCv;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCv = (ImageView) itemView.findViewById(R.id.imgFotoCv);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNombreCv = (TextView) itemView.findViewById(R.id.tvNombreCv);
            tvLikesCv = (TextView) itemView.findViewById(R.id.tvLikesCv);
        }
    }

}
