package com.ecom.caltalog.application.product.deleteproductbyid;

import com.ecom.shared.application.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteProductByIdCommand implements Command<Void> {
    private String id;

}
