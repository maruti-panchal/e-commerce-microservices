package com.learnspring.productservice.services;

import com.learnspring.productservice.ProductServiceApplication;
import com.learnspring.productservice.config.ApplicationConfig;
import com.learnspring.productservice.dtos.ProductDto;
import com.learnspring.productservice.modals.CategoryModal;
import com.learnspring.productservice.modals.ProductModal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplateConfig;

    public FakeStoreProductService(RestTemplate restTemplateConfig){
        this.restTemplateConfig = restTemplateConfig;
    }


    @Override
    public ProductModal getSingleProduct(long id) {
        ProductDto productDto= restTemplateConfig.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
        return convertProductDtoToProductModal(productDto);
    }

    @Override
    public ArrayList<ProductModal> getAllProducts() {
        ArrayList<ProductModal> productModals = new ArrayList<>();
        ProductDto[] productDtos=restTemplateConfig.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        for(ProductDto productDto:productDtos){
            productModals.add(convertProductDtoToProductModal(productDto));
        }
        return productModals;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public ProductModal updateProduct(long id, ProductModal product) {
        return null;
    }

    @Override
    public ProductModal addProduct(ProductModal product) {
        return null;
    }

    public ProductModal convertProductDtoToProductModal(ProductDto productDto){
        ProductModal productModal=new ProductModal();
        CategoryModal categoryModal=new CategoryModal();
        categoryModal.setValue(productDto.getCategory());
        productModal.setId(productDto.getId());
        productModal.setDescription((productDto.getDescription()));
        productModal.setTitle((productDto.getTitle()));
        productModal.setPrice((productDto.getPrice()));
        productModal.setImageUrl((productDto.getImageUrl()));
        productModal.setCreatedAt(new Date());
        productModal.setUpdatedAt(new Date());
        productModal.setCategory(categoryModal);
        return productModal;
    }
}
