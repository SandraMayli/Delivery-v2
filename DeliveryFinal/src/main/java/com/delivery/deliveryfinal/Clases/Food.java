package com.delivery.deliveryfinal.Clases;

public class Food {
    private String nombre;
    private String descripcion;
    private double precio;


    public Food(String nombre, String descripcion, double precio) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

