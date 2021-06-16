package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public interface IJsonHandling {

    default JSONObject jsonFromString(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject;
    }
    
    default JSONArray getArrayFromJsonObject(JSONObject jsonObject, String key) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        return jsonArray;
    };

    default JSONArray getJsonArrayFromString(String json, String key) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        return jsonArray;
    };

    default String getStringKey(String json, String key) {
        JSONObject jsonData = this.jsonFromString(json);
        return jsonData.getString(key);
    }

    default int getIntKey(String json, String key) {
        JSONObject jsonData = this.jsonFromString(json);
        return jsonData.getInt(key);
    }

}
