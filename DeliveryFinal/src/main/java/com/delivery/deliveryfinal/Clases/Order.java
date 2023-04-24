package com.delivery.deliveryfinal.Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String nombreCliente;
    private String emailCliente;
    private String estado;
    private Date tiempoCreacion;
    private Date tiempoEstimadoDelivery;
    private List<Food> items;

    public Order(int id, String nombreCliente, String emailCliente, String estado, Date tiempoCreacion,
                 Date tiempoEstimadoDelivery, List<Food> items) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.estado = estado;
        this.tiempoCreacion = tiempoCreacion;
        this.tiempoEstimadoDelivery = tiempoEstimadoDelivery;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getEstado() {
        return estado;
    }

    public Date getTiempoCreacion() {
        return tiempoCreacion;
    }

    public Date getTiempoEstimadoDelivery() {
        return tiempoEstimadoDelivery;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTiempoCreacion(Date tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    public void setTiempoEstimadoDelivery(Date tiempoEstimadoDelivery) {
        this.tiempoEstimadoDelivery = tiempoEstimadoDelivery;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }
    public void addItem(Food item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void removeItem(Food item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        if (items != null) {
            for (Food item : items) {
                total += item.getPrecio();
            }
        }
        return total;
    }

    public void mostrarDetalle() {
        System.out.println("Orden #" + id);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Email: " + emailCliente);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha de creación: " + tiempoCreacion);
        System.out.println("Fecha estimada de entrega: " + tiempoEstimadoDelivery);
        System.out.println("Detalle de la orden:");
        if (items != null) {
            for (Food item : items) {
                System.out.println("- " + item.getNombre() + " (" + item.getDescripcion() + "): S/" + item.getPrecio());
            }
        }
        System.out.println("Total: S/" + calcularTotal());
    }
}
