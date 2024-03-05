package com.itvedant.petstoreapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.petstoreapp.entities.Product;

@Service
public class ProductService {
    private Map<Integer, Product> productMap = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();

    //Create
    public String addProduct(Product newProduct){              
        newProduct.setId(atomic.incrementAndGet());
        productMap.put(newProduct.getId(), newProduct);
        return "Product Added";
    }

    //Read All
    public List<Product> getAll(){
        return new ArrayList<Product>(productMap.values());
    }

    //Read Single
    public Product getByID(Integer id){
        return productMap.get(id);
    }

    //Delete
    public void deleteProduct(Integer id){
        productMap.remove(id);
    }

    //Update
    public Product updateProduct(Integer id, Product updatedProduct){
        updatedProduct.setId(id);
        productMap.put(id, updatedProduct);
        return productMap.get(id);
    }
}
