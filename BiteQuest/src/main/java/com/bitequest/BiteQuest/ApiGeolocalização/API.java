package com.bitequest.BiteQuest.ApiGeolocalização;

import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class API {
    private final OkHttpClient httpClient = new OkHttpClient();

    public void getGeolocation() throws Exception {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                "{"
                        + "\"homeMobileCountryCode\": 310,"
                        + "\"homeMobileNetworkCode\": 410,"
                        + "\"radioType\": \"gsm\","
                        + "\"carrier\": \"Vodafone\","
                        + "\"considerIp\": true"
                        + "}"
        );

        Request request = new Request.Builder()
                .url("https://www.googleapis.com/geolocation/v1/geolocate?key=SUA_CHAVE_API")
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }
}


