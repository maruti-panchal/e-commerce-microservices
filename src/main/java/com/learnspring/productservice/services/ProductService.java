package com.learnspring.productservice.services;

import com.learnspring.productservice.modals.ProductModal;

import java.util.ArrayList;

public interface ProductService {
    public ProductModal getSingleProduct(long id);
    public ArrayList<ProductModal> getAllProducts();
    public void deleteProduct(long id);
    public ProductModal updateProduct(long id,ProductModal product);
    public ProductModal addProduct(ProductModal product);
}
