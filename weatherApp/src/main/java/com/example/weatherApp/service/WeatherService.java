package com.example.weatherApp.service;


import com.example.weatherApp.exception.CityNotFoundException;
import com.example.weatherApp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
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

            try {
                WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

                if (response == null || response.getName() == null) {
                    throw new CityNotFoundException("Please enter a valid city name");
                }

                return response;
            } catch (HttpClientErrorException.NotFound e) {
                throw new CityNotFoundException("City '" + city + "' not found. Please enter a valid city name");
            } catch (RestClientException e) {
                throw new CityNotFoundException("Error fetching weather data. Please try again later");
            }
        }
    }

