package com.ecom.caltalog.application.product.deleteproductbyid;

import com.ecom.shared.application.Command;
import lombok.Data;

@Data
public class DeleteProductByIdCommand implements Command<Void> {
    private String id;

    public DeleteProductByIdCommand(String id) {
        this.id = id;
    }

}
