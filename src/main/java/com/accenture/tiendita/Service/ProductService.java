package com.accenture.tiendita.Service;

import com.accenture.tiendita.Entities.Product;
import com.accenture.tiendita.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductService {

    @Autowired
    private ProductRepository productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(product.getIdProduct()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/products/{id}")
    public void deleteByProductId(@PathVariable int id){
        Product product = productService.deleteProductById(id);
        if (product == null){
            //ToDo
        }
    }
}
