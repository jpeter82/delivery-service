package com.peanuts.delivery.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHandler {

    public static <T> T convertJsonToObject(String json, String key, Class<T> classOfT) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        Gson gson = new Gson();
        JsonElement originJson = jsonObject.get(key);
        return gson.fromJson(originJson, classOfT);
    }

    public static String convertObjectToJson(Object objectOfT) {
        Gson gsonResponse = new Gson();
        String jsonResponse = gsonResponse.toJson(objectOfT);
        return jsonResponse;
    }

}
