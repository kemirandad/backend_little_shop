package com.accenture.tiendita.Repository;

import com.accenture.tiendita.Entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProductRepository {

    private static Integer productCounter = 4;

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(0, "Delivery", 5000.00));
        products.add(new Product(1, "Chair", 80000.00));
        products.add(new Product(2, "Table", 100000.00));
        products.add(new Product(3, "Board", 120000.00));
        products.add(new Product(4, "Toys Box", 60000.00));
    }

    public List<Product> findAll(){
        return products;
    }

    public Product addProduct(Product product){
        if (product.getIdProduct().equals(null)){
            product.setIdProduct(++productCounter);
        }
        products.add(product);
        return product;
    }

    public Product findById(int id){
        for (Product product: products) {
            if (product.getIdProduct() == id){
                return product;
            }
        }
        return null;
    }

    public Product deleteProductById(int id){
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getIdProduct() == id){
                iterator.remove();
                return product;
            }
        }
        return null;
    }
}
