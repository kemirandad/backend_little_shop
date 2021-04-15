package com.accenture.tiendita.TestRepository;

import com.accenture.tiendita.Entities.Invoice;
import com.accenture.tiendita.Entities.Order;
import com.accenture.tiendita.Entities.Product;
import com.accenture.tiendita.Repository.InvoiceRepository;
import com.accenture.tiendita.Repository.ProductRepository;
import junit.framework.TestCase;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class TestInvoiceRepository extends TestCase {

    private static InvoiceRepository invoiceRepository;

    //Pedido y factura 1 para ahorrar domicilio
    private static List<Product> newOrder = Arrays.asList(new ProductRepository().findById(1), new ProductRepository().findById(3));
    private final static Order order = new Order(null, newOrder, 2, new Date(), "ACCEPTED");

    //Pedido y factura 2 para no ahorrar domilicio
    private static List<Product> newOrder1 = Arrays.asList(new ProductRepository().findById(1));
    private final static Order order1 = new Order(null, newOrder1, 2, new Date(), "ACCEPTED");

    private final static Invoice invoice = new Invoice(5, order);

    public void root(){
        invoiceRepository = new InvoiceRepository();
    }

    public void testAddAnyInvoice(){
        root();
        assertSame(invoice,invoiceRepository.addInvoice(invoice));
    }

    public void testGetAllInvoices(){
        root();
        assertNotNull(invoiceRepository.getAllInvoices().size());
    }



}
