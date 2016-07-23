package com.migueling.tarearecyclerview;


public class Mascota {

    private String nombre;
    private int noLikes;
    private int foto;


    public Mascota(String nombre, int noLikes, int foto) {
        this.nombre = nombre;
        this.noLikes = noLikes;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoLikes() {
        return noLikes;
    }

    public void setNoLikes(int noLikes) {
        this.noLikes = noLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
