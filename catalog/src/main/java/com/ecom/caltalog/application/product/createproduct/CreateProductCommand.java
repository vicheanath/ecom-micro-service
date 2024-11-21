package com.ecom.caltalog.application.product.createproduct;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateProductCommand implements Command<Void> {
    @NotEmpty
    @NotBlank
    @Max(100)
    public String name;
    @Max(500)
    public String description;
    @NotEmpty
    public String categoryId;
    public double price;
    public int quantity;
    public String imageUrl;
}
