package com.peanuts.delivery.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.peanuts.delivery.dao.PostapontDao;
import com.peanuts.delivery.model.Address;
import com.peanuts.delivery.model.DeliveryResponse;
import com.peanuts.delivery.model.Offer;
import com.peanuts.delivery.model.Postapont;
import com.peanuts.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
