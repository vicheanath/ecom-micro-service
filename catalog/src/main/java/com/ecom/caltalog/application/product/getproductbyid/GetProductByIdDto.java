package com.ecom.caltalog.application.product.getproductbyid;

public record GetProductByIdDto(
        String id,
        String name,
        String description,
        String imageUrl,
        Double price,
        String category) {
}