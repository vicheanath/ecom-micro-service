package com.ecom.caltalog.application.product.getallproduct;


public record GetAllProductDto (String id, String name, String description, String imageUrl, Double price , CategoryDto category) {
}
