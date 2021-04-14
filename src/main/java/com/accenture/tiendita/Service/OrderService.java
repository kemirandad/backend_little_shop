package com.accenture.tiendita.Service;

import com.accenture.tiendita.Entities.Order;
import com.accenture.tiendita.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class OrderService {

    @Autowired
    private OrderRepository orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/clients/{idClient}/orders")
    public List<Order> getOrderByClient(@PathVariable int idClient){
        return orderService.getAllOrderByClientId(idClient);
    }

    @PostMapping("/clients/{idClient}/orders")
    public ResponseEntity<Object> createOrder(@PathVariable int idClient, @RequestBody Order order){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("" +
                "/{idClient}").buildAndExpand(idClient).toUri();
        orderService.addOrder(order);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/clients/{idClient}/orders/{idOrder}")
    public Order updateOrder(@PathVariable int idClient, @PathVariable int idOrder, @RequestBody Order order){
        return orderService.updateOrder(idClient, order, idOrder);
    }

    @PostMapping("/clients/{idClient}/orders/{idOrder}/addProduct/{idProduct}")
    public Order addProductToOrder(@PathVariable int idClient, @PathVariable int idOrder, @PathVariable int idProduct){
        return orderService.addProductToOrder(idClient, idOrder, idProduct);
    }

    @DeleteMapping("/clients/{idClient}/orders/{irOrder}")
    public void deleteOrderByClient(@PathVariable int idClient, @PathVariable int idOrder){
        Order order = orderService.deleteOrderById(idClient, idOrder);
        if (order == null){
            //ToDo
        }
    }

}
