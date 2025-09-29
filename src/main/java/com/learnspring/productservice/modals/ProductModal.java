package com.learnspring.productservice.modals;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Getter
@Setter
public class ProductModal extends BaseModal{
    private String title;
    private double price;
    private String description;
    private String imageUrl;
//    private String category;
    private CategoryModal category;
}
