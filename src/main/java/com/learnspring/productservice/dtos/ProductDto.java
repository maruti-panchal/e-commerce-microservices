package com.learnspring.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String title;
    private String description;
    private String imageUrl;
    private String category;
    private double price;

}
