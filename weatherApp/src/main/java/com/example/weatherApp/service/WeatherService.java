package com.example.weatherApp.service;


import com.example.weatherApp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

    @Service
    public class WeatherService {

        @Value("${weather.api.url}")
        private String apiUrl;

        @Value("${weather.api.key}")
        private String apiKey;

        private final RestTemplate restTemplate;

        public WeatherService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public WeatherResponse getWeather(String city) {
            String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
            return restTemplate.getForObject(url, WeatherResponse.class);
        }
    }

