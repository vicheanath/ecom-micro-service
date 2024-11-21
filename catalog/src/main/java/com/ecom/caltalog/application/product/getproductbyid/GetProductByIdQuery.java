package com.ecom.caltalog.application.product.getproductbyid;

import com.ecom.shared.application.Query;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
@AllArgsConstructor
public class GetProductByIdQuery implements  Query<GetProductByIdDto> {
    @NotEmpty
    @NotBlank
    private String id;
}
