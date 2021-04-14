package com.accenture.tiendita.Repository;

import com.accenture.tiendita.Entities.Invoice;
import com.accenture.tiendita.Entities.Order;

import com.accenture.tiendita.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class OrderRepository {
    private static Integer counterOrder = 3;

    public final Integer TWELVEHOURS = 43200000;
    public final Integer FIVEHOURS = 18000000;

    @Autowired
    private InvoiceRepository invoiceService;

    private static List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order(1, new ProductRepository().findAll(), 1, new Date(), "ACCEPTED"));
        orders.add(new Order(2, new ProductRepository().findAll(), 1, new Date(), "ACCEPTED"));
        orders.add(new Order(3, new ProductRepository().findAll(), 2, new Date(), "ACCEPTED"));

        deleteDeliveryFormOrders();
    }

    private static void deleteDeliveryFormOrders() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getPrice() > 100000){
                Iterator<Product> iterator = orders.get(i).getProducts().iterator();
                orders.get(i).setPrice(orders.get(i).getPrice() - 5000);
                while (iterator.hasNext()){
                    Product product = iterator.next();
                    if (product.getIdProduct() == 0){
                        iterator.remove();
                    }
                }
            }
        }
    }

    public List<Order> getAllOrders(){
        return orders;
    }

    public List<Order> getAllOrderByClientId(int idClient){
        List<Order> ordersByClient = new ArrayList<>();
        for (Order order: orders) {
            if (order.getIdClient() == idClient){
                ordersByClient.add(order);
            }
        }
        return ordersByClient;
    }
    
    public Order addOrderToClient(int idClient, Order order){
        if (order.getIdOrder().equals(null)) {
            order.setIdOrder(++counterOrder);
        }
            order.setIdClient(idClient);
            deleteDelivery(order);
            orders.add(order);
            return order;
    }

    public Order getOrderById(int id){
        for (Order order: orders) {
            if (order.getIdOrder() == id){
                return order;
            }
        }
        return null;
    }

    public Order addOrder(Order order){
        if (order.getIdOrder() == null){
            order.setIdOrder(++counterOrder);
        }
        if (order.getDate() == null){
            order.setDate(new Date());
        }
        double verifyPrice = order.totalPrice(order.getProducts());
        if (verifyPrice < 100000){
            order.getProducts().add(new Product(0, "Domicilio", 5000.00));
            order.setPrice(verifyPrice + 5000.00);
        }else {
            order.getProducts().add(new Product(0, "Domicilio", 0.00));
            order.setPrice(verifyPrice);
        }
        orders.add(order);
        invoiceService.addInvoice(new Invoice(null, order));
        return order;
    }

    public Order updateOrder(int idClient, Order order, int idOrder){

        Order newOrder = new Order(idOrder, order.getProducts(), idClient, new Date(), order.getState());

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getIdOrder() == idOrder && orders.get(i).getIdClient() == idClient){
                if (isUpdateTime(order.getDate()) == true){
                    if (newOrder.getPrice() >= orders.get(i).getPrice()){
                        deleteDelivery(newOrder);
                        orders.set(i, newOrder);
                        invoiceService.updateInvoice(idOrder, newOrder);
                        return orders.get(i);
                    }
                }
            }
        }
        return null;
    }

    private boolean isUpdateTime(Date orderDate) {
        Date actualDate = new Date();
        if (actualDate.getTime() - orderDate.getTime() < FIVEHOURS){
            return true;
        }
        return false;
    }

    public Order deleteOrderById(int idClient, int idOrder){
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            if (order.getIdOrder() == idOrder && order.getIdClient() == idClient){
                if (isCancelledTime(order.getDate()) == true){
                    iterator.remove();
                    invoiceService.deleteInvoiceByIdOrder(idOrder);
                    return order;
                }else {
                    order.setState("CANCELLED");
                    double newPrice = order.getPrice();
                    newPrice = (newPrice / 100) * 10;
                    order.setPrice(newPrice);
                    invoiceService.updateInvoice(idOrder, order);
                }
            }
        }
        return null;
    }

    private boolean isCancelledTime(Date orderDate) {
        Date actualDate = new Date();
        if (actualDate.getTime() - orderDate.getTime() < TWELVEHOURS){
            return true;
        }
        return false;
    }

    private Order deleteDelivery(Order order) {
        if (order.getPrice() > 100000){
            Iterator<Product> iterator = order.getProducts().iterator();
            while (iterator.hasNext()){
                Product product = iterator.next();
                if (product.getIdProduct() == 0){
                    iterator.remove();
                    return order;
                }
            }
        }
        return order;
    }

    public Order addProductToOrder(int idClient, int idOrder, int idProduct){
        ProductRepository products = new ProductRepository();
        Product product = products.findById(idProduct);
        Order order = deleteDelivery(getOrderById(idOrder));
        order.getProducts().add(product);
        return updateOrder(idClient, order, idOrder);
    }

}
