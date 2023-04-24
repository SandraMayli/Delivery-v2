package com.delivery.deliveryfinal.Service;

import com.delivery.deliveryfinal.Clases.Food;
import com.delivery.deliveryfinal.Clases.Order;
import com.delivery.deliveryfinal.Request.OrderRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private List<Order> orders;

    public OrderService() {
        orders = new ArrayList<>();
    }
    public Order createOrder(OrderRequest orderRequest) {
        if (orderRequest.getItems().isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía");
        }
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setNombreCliente(orderRequest.getNombreClient());
        order.setEmailCliente(orderRequest.getEmailClient());
        order.setEstado("Procesando");
        order.setTiempoCreacion(LocalDateTime.now());
        order.setTiempoEstimadoDelivery(LocalDateTime.now().plusMinutes(20));
        order.setItems(orderRequest.getItems());
        orders.add(order);
        return order;
    }

    //Actualizar la orden
    public void actualizarOrden(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) {
                orders.set(i, order);
                return;
            }
        }
        System.out.println("Pedido no encontrado");
    }

    //Cancelar la orden
    public void cancelarOrden(String orderId) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == orderId) {
                orders.get(i).setEstado("Cancelado");
                return;
            }
        }
        System.out.println("Pedido no encontrado");
    }


    //Obtener detalles de un pedido que existe
    public Order getOrder(String orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        System.out.println("Pedido no encontrado");
        return null;
    }

    //Obtener una lista de pedidos realizados por un cliente en particular
    public List<Order> getOrdersByCustomer(String customerEmail) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getEmailCliente().equals(customerEmail)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    //Obtener una lista de pedidos en un estado particular
    public List<Order> getOrdersByState(String state) {
        List<Order> stateOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getEstado().equals(state)) {
                stateOrders.add(order);
            }
        }
        return stateOrders;
    }


    //Obtener una lista de pedidos realizados dentro de un rango de fechas
    public List<Order> getOrdersByDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> dateOrders = new ArrayList<>();
        for (Order order : orders) {
            LocalDateTime orderDate = order.getTiempoCreacion();
            if (orderDate.isAfter(startDate) && orderDate.isBefore(endDate)) {
                dateOrders.add(order);
            }
        }
        return dateOrders;
    }
    public List<Order> getAllOrders() {
        return orders;
    }

    public Order findOrderById(String orderNumber) {
        return orders.stream().filter(order -> orderNumber.equals(order.getId())).findFirst().orElse(null);
    }
    //calcular el tiempo estimado de entrega de una orden
    public int calcularTiempoDelivery(Order order) {
        double totalDistance = 0;
        for (Food item : order.getItems()) {
            totalDistance += item.getDescripcion().length();
        }
        return (int) (totalDistance / 10.0);
    }

    //Calcular el Total
    public double calcularTotal(Order order) {
        return order.calcularTotal();
    }


}
