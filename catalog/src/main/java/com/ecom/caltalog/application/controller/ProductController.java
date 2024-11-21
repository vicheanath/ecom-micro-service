package com.ecom.caltalog.application.controller;

import com.ecom.caltalog.application.product.createproduct.CreateProductCommand;
import com.ecom.caltalog.application.product.deleteproductbyid.DeleteProductByIdCommand;
import com.ecom.caltalog.application.product.getallproduct.GetAllProductDto;
import com.ecom.caltalog.application.product.getallproduct.GetAllProductQuery;
import com.ecom.caltalog.application.product.getproductbyid.GetProductByIdDto;
import com.ecom.caltalog.application.product.getproductbyid.GetProductByIdQuery;
import com.ecom.caltalog.application.product.updateproduct.UpdateProductCommand;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final Mediator mediator;

    public ProductController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public List<GetAllProductDto> getAll() {
        return mediator.ask(new GetAllProductQuery());
    }

    @GetMapping("/{id}")
    public GetProductByIdDto getById(String id) {
        return mediator.ask(new GetProductByIdQuery(id));
    }

    @PostMapping
    public void create(@RequestBody CreateProductCommand command) {
        mediator.send(command);
    }

    @PutMapping
    public void update(@RequestBody UpdateProductCommand command) {
        mediator.send(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        mediator.send(new DeleteProductByIdCommand(id));
    }


}
