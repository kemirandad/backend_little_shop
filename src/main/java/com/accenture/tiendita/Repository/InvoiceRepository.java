package com.accenture.tiendita.Repository;

import com.accenture.tiendita.Entities.Invoice;
import com.accenture.tiendita.Entities.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class InvoiceRepository {

    private static int invoiceCounter = 4;

    private static List<Invoice> invoices = new ArrayList<>();

    static {
        invoices.add(new Invoice(1, new OrderRepository().getOrderById(1)));
        invoices.add(new Invoice(2, new OrderRepository().getOrderById(2)));
        invoices.add(new Invoice(3, new OrderRepository().getOrderById(3)));
        invoices.add(new Invoice(4, new OrderRepository().getOrderById(4)));
    }

    public List<Invoice> getAllInvoices(){
        return invoices;
    }

    public Invoice getInvoiceById(int id){
        for (Invoice invoice:invoices) {
            if(invoice.getIdInvoice() == id){
                return invoice;
            }
        }
        return null;
    }

    public Invoice addInvoice(Invoice invoice) {
        if (invoice.getIdInvoice() == null){
            invoice.setIdInvoice(++invoiceCounter);
        }
        invoices.add(invoice);
        return invoice;
    }

    public void updateInvoice(int idOrder, Order order) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getOrder().getIdOrder() == idOrder){
                Invoice newInvoice = addInvoice(new Invoice(null, order));
                invoices.remove(i);
                invoices.set(i, newInvoice);
            }
        }
    }

    public Invoice deleteInvoiceByIdOrder(int idOrder) {
        Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()){
            Invoice invoice = (Invoice) iterator.next();
            if (invoice.getOrder().getIdOrder() == idOrder){
                iterator.remove();
                return invoice;
            }
        }
        return null;
    }
}
