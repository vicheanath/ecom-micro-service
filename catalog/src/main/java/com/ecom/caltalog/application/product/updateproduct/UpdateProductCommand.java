package com.ecom.caltalog.application.product.updateproduct;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateProductCommand implements Command<Void> {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @Max(255)
    private String description;
    @Max(255)
    private String imageUrl;

    private Double price;
    @NotEmpty
    private String categoryId;
}
