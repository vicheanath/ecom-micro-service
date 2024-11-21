package com.ecom.inventory.application.controllers;

import com.ecom.inventory.application.stockadjaustment.StockAdjastmentCommand;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final Mediator mediator;

    public StockController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/adjust")
    public void adjustStock(@RequestBody StockAdjastmentCommand request) {
        mediator.send(request);
    }
}
