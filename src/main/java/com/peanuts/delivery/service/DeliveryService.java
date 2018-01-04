package com.peanuts.delivery.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.peanuts.delivery.controller.DistanceMatrixApi;
import com.peanuts.delivery.dao.PostapontDao;
import com.peanuts.delivery.model.Address;
import com.peanuts.delivery.model.DeliveryResponse;
import com.peanuts.delivery.model.Offer;
import com.peanuts.delivery.model.Postapont;
import com.peanuts.delivery.util.JsonHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DeliveryService {

    private PostapontDao postapontDao;
    private DistanceMatrixApi distanceMatrixApi;

    public DeliveryService() {
    }

    public DeliveryService(PostapontDao postapontDao, DistanceMatrixApi distanceMatrixApi) {
        this.postapontDao = postapontDao;
        this.distanceMatrixApi = distanceMatrixApi;
    }

    public String handleQuery(String json) {

        Address originAddress = JsonHandler.convertJsonToObject(json, "origin", Address.class);
        Address destinationAddress = JsonHandler.convertJsonToObject(json, "destination", Address.class);


        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:" + destinationAddress.getCity());
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");*/

        // JSON RESPONSE
        List<Postapont> postaponts = new ArrayList<>();
        List<Offer> deliveryServices = new ArrayList<>();
        DeliveryResponse responseObject = new DeliveryResponse(originAddress, destinationAddress, postaponts, deliveryServices);

        /*Gson gsonResponse = new Gson();
        String jsonResponse = gsonResponse.toJson(responseObject);*/
        String jsonResponse = JsonHandler.convertObjectToJson(responseObject);

        return jsonResponse;
    }

    public HashMap calcDistanceAndDuration (Address origin, Address destenation) throws InterruptedException, ApiException, IOException {

        String[] originArray = {origin.getZipcode() + " " + origin.getCity() + " " + origin.getAddress()};
        String[] destinationArray ={destenation.getZipcode() + " " + destenation.getCity() + " " + destenation.getAddress()};
        DistanceMatrixApiRequest req = distanceMatrixApi.getDistanceMatrix(distanceMatrixApi.getContext(), originArray, destinationArray);
        DistanceMatrix matrix = req.await();

        System.out.println(matrix.rows[0].elements[0].distance.humanReadable);
        HashMap results = new HashMap();

        results.put("distance", matrix.rows[0].elements[0].distance.inMeters);
        results.put("duration", matrix.rows[0].elements[1].duration.inSeconds);

        return  results;
    }

    public String saveOrder(String json) {
        return "";
    }

}
