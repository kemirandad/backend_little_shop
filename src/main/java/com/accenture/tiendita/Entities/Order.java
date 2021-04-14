package com.accenture.tiendita.Entities;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer idOrder;
    private List<Product> products;
    private Integer idClient;
    private Double price;
    private Date date;
    private String state;

    public Order(Integer idOrder, List<Product> products, Integer idClient, Date date, String state) {
        this.idOrder = idOrder;
        this.products = products;
        this.idClient = idClient;
        this.price = totalPrice(products);
        this.date = date;
        this.state = state;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Double totalPrice(List<Product> products){
        double productsPrices = 0;
        for (Product product: products ) {
            productsPrices += product.getPrice();
        }
        price = productsPrices;
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", products=" + products +
                ", idClient=" + idClient +
                ", price=" + price +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }
}
