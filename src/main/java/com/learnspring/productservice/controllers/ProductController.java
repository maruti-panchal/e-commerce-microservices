package com.learnspring.productservice.controllers;

import com.learnspring.productservice.ProductServiceApplication;
import com.learnspring.productservice.modals.ProductModal;
import com.learnspring.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService=productService;
    }
    // get single product
    @GetMapping("/{id}")
    public ProductModal getProduct(@PathVariable("id")long id){
        return productService.getSingleProduct(id);
    }

    // get all products
    @GetMapping()
    public ArrayList<ProductModal> getAllProducts(){
        return productService.getAllProducts();
    }

    // delete a product
    public void deleteProduct(long id){}

    // update a product
    public ProductModal updateProduct(long id,ProductModal product){
        return new ProductModal();
    }

    // create a new product
    public ProductModal createProduct(ProductModal product){
        return new ProductModal();
    }
}
