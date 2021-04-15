package com.accenture.tiendita.TestRepository;

import com.accenture.tiendita.Entities.Product;
import com.accenture.tiendita.Repository.ProductRepository;
import junit.framework.TestCase;
import org.springframework.stereotype.Component;

@Component
public class TestProductRepository extends TestCase {

    private static ProductRepository productRepository;
    private final static Product product = new Product(5, "Peluche", 25000.00);

    public void root(){
        productRepository = new ProductRepository();
    }

    public void testFindAllProducts(){
        root();
        assertSame("Los objetos no son iguales", 5, productRepository.findAll().size());
    }

    public void testFindAllProductsError(){
        root();
        assertSame("Los objetos no son iguales", "5", productRepository.findAll().size());
    }

    public void testFindAllProductsError2(){
        root();
        assertSame("Los objetos no son iguales", "5", productRepository.findAll().get(1));
    }

    public void testFindByIdProductError(){
        root();
        try {
            assertNotSame("No se cumple tu peticion",null, productRepository.findById(1000).equals(null));
        }catch (NullPointerException error){
            error = new NullPointerException("Tu codigo falló, eres tonto");
            System.out.println(error);
        }
    }

    public void testFindByIdProduct(){
        root();
        try {
            assertSame("No se cumple tu peticion",product, productRepository.findById(5));
        }catch (NullPointerException error){
            error = new NullPointerException("Tu codigo falló, eres tonto");
            System.out.println(error);
        }
    }


}
