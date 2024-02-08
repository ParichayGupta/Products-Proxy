package com.learning.productsproxy.entity;

import com.learning.productsproxy.dto.RatingDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageURL;
    private RatingDTO rating;

}
