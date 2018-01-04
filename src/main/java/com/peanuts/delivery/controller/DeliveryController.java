package com.peanuts.delivery.controller;


import com.peanuts.delivery.model.DeliveryResponse;
import com.peanuts.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/query")
    public DeliveryResponse queryDeliveryOptions(@RequestBody String json) {
        DeliveryResponse deliveryResponse = deliveryService.handleQuery(json);
        return deliveryResponse;
    }

    @PostMapping("/save-order")
    public String saveOrder(@RequestBody String json) {
        String jsonResponse = deliveryService.saveOrder(json);
        return jsonResponse;
    }

}
