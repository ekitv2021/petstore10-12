package com.itvedant.petstoreapp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstoreapp.entities.Product;
import com.itvedant.petstoreapp.services.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {  

    @Autowired
    private ProductService service;

    //Create
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    //@RequestBody annotation will convert the JSON data
    //coming in the request body into the object of the class Product
    public ResponseEntity<String> addProduct(@RequestBody @Valid Product newProduct){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(this.service.addProduct(newProduct));
    }

    //Read All
    @RequestMapping(path = "/products", method = RequestMethod.GET)
    //<?> indicates that value of any type
    public ResponseEntity<?> getProducts(){
        //values() methods return Collection<Product>
        //we can convert this into an List by creating 
        //and ArrayList using it
        return ResponseEntity.ok(this.service.getAll());
    }

    //Read Single
    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductByID(@PathVariable Integer id){
        Product foundProduct = this.service.getByID(id);
        if(foundProduct == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Product with this ID does not exist");
        else
            return ResponseEntity.ok(foundProduct);
    }

    //Delete
    @RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        Product foundProduct = this.service.getByID(id);
        if(foundProduct == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Product with this ID does not exist");
        else
            {
                this.service.deleteProduct(id);
                //when the delete operation is done we don't
                //want to return any response
                return ResponseEntity.noContent().build();
            }
    }

    //Update
    @RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable Integer id,
                                           @RequestBody @Valid Product updatedProduct){
        Product foundProduct = this.service.getByID(id);
        if(foundProduct == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Product with this ID does not exist");
        else
            return ResponseEntity.ok(this.service.updateProduct(id, updatedProduct));
    }
}
