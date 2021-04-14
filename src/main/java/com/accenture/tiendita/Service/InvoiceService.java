package com.accenture.tiendita.Service;

import com.accenture.tiendita.Entities.Invoice;
import com.accenture.tiendita.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceService;

    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/invoices/{idInvoices}")
    public Invoice getInvoiceById(@PathVariable int idInvoice){
        return invoiceService.getInvoiceById(idInvoice);
    }
}
