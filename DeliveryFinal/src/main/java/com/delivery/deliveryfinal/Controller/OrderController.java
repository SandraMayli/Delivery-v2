package com.delivery.deliveryfinal.Controller;

import com.delivery.deliveryfinal.Clases.Food;
import com.delivery.deliveryfinal.Clases.Order;
import com.delivery.deliveryfinal.Request.OrderRequest;
import com.delivery.deliveryfinal.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ordenes")
public class OrderController {
    private List<Food> menu = new ArrayList<>();

    public OrderController() {
        menu.add(new Food("Lomo Saltado", "Plato Peruano",11.5));
        menu.add(new Food("Papa a la Huancaina","Plato Peruano", 4.45));
        menu.add(new Food("Ceviche","Plato Peruano", 15.00));
        menu.add(new Food("Causa Rellena","Plato Peruano", 7.00));
    }


    private OrderService orderService;

    @GetMapping( "/menu")
    public List<Food> getMenu() {
        return menu;
    }

    @PostMapping("/crear")
    public Order crearOrden(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }



    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order orderobjet = orderService.findOrderById(orderId);

        if (orderobjet != null) {
            orderobjet.setEstado(order.getEstado());
            return ResponseEntity.ok().body(orderobjet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
