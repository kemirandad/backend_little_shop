package com.accenture.tiendita.Entities;

public class Invoice {
    private Integer idInvoice;
    private Order order;
    private String description;
    private Double iva;

    public Invoice(Integer idInvoice, Order order) {
        this.idInvoice = idInvoice;
        this.order = order;
        this.description = setDescription();
        this.iva = setIva();
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription() {
        return this.description = toString();
    }

    public Double getIva() {
        return iva;
    }

    public Double setIva() {
        return this.iva = (order.getPrice()*(0.19));
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice=" + idInvoice +
                ", order=" + order +
                '}';
    }

}
