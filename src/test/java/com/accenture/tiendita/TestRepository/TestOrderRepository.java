package com.accenture.tiendita.TestRepository;

import com.accenture.tiendita.Entities.Order;
import com.accenture.tiendita.Entities.Product;
import com.accenture.tiendita.Repository.OrderRepository;
import com.accenture.tiendita.Repository.ProductRepository;
import junit.framework.TestCase;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class TestOrderRepository extends TestCase {

    private static OrderRepository orderRepository;

    //Pedido y factura 1 para ahorrar domicilio
    private static List<Product> newOrder = Arrays.asList(new ProductRepository().findById(1), new ProductRepository().findById(3));
    private final static Order order = new Order(4, newOrder, 2, new Date(), "ACCEPTED");

    //Pedido y factura 2 para no ahorrar domilicio
    private static List<Product> newOrder1 = Arrays.asList(new ProductRepository().findById(1));
    private final static Order order1 = new Order(5, newOrder1, 2, new Date(), "ACCEPTED");

    public void root(){
        orderRepository = new OrderRepository();
    }

    public void testAddOrder(){
        root();
        assertNotNull(orderRepository.addOrder(order));
    }

    public void testFindAllOrders(){
        root();
        assertNotNull(orderRepository.getAllOrders());
    }

    public void testIncludeDelivery(){
        root();
        assertSame(5000.00, orderRepository.getOrderById(4).getPrice());
    }
}
