package com.peanuts.delivery.service;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.peanuts.delivery.controller.DistanceMatrixApi;
import com.peanuts.delivery.dao.PostapontDao;
import com.peanuts.delivery.model.*;
import com.peanuts.delivery.util.JsonHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public DeliveryResponse handleQuery(String json) {

        Address originAddress = JsonHandler.convertJsonToObject(json, "origin", Address.class);
        Address destinationAddress = JsonHandler.convertJsonToObject(json, "destination", Address.class);

        List<Postapont> postaponts = collectPostaponts(destinationAddress.getCity());
        List<Offer> deliveryServices = collectOffers(originAddress, destinationAddress);

        DeliveryResponse responseObject = new DeliveryResponse(originAddress, destinationAddress, postaponts, deliveryServices);

        return responseObject;
    }

    public List<Offer> collectOffers(Address origin, Address destination) {
        List<Offer> offers = new ArrayList<>();
        LocalDate dateDPD =  LocalDate.now().plusDays(2);
        LocalDate dateDHL =  LocalDate.now().plusDays(4);
        String costDPD = "1100";
        String costDHL = "800";
        Offer offerDPD = new Offer("DPD", costDPD, Currency.HUF, dateDPD);
        Offer offerDHL = new Offer("DHL", costDHL, Currency.HUF, dateDHL);
        offers.add(offerDPD);
        offers.add(offerDHL);
        return offers;
    }

    public List<Postapont> collectPostaponts(String destinationCity) {
        return new ArrayList<>();
    }

    public HashMap calcDistanceAndDuration (Address origin, Address destination) throws InterruptedException, ApiException, IOException {

        String[] originArray = {origin.getZipcode() + " " + origin.getCity() + " " + origin.getAddress()};
        String[] destinationArray ={destination.getZipcode() + " " + destination.getCity() + " " + destination.getAddress()};
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
