package com.peanuts.delivery.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.peanuts.delivery.dao.AddressDao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class AddressController {

    private DistanceMatrixApi distanceMatrixApi;

    public AddressController(DistanceMatrixApi distanceMatrixApi) {
        this.distanceMatrixApi = distanceMatrixApi;
    }

//    public HashMap getDistanceAndDuration () {
//String[] origins = {"1065 Budapest nagymező 44"};
//    String[] destinations ={"1067 Budapest Hunyadi tér 1"};
//    DistanceMatrixApiRequest req = distanceMatrixApi.getDistanceMatrix(distanceMatrixApi.getContext(), origins, destinations);
//    DistanceMatrix matrix = req.await();
//
//
//        System.out.println(matrix.rows[0].elements[0].distance.humanReadable);
//        HashMap result = new HashMap();
//        return  result;
//    }

    @GetMapping(value = "/")
    @ResponseBody
    public String welcomeView() throws Exception {
        return "welcome";
    }
}
