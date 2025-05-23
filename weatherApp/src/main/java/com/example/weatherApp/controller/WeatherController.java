package com.example.weatherApp.controller;

import com.example.weatherApp.exception.CityNotFoundException;
import com.example.weatherApp.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    public class WeatherController {

        private final WeatherService weatherService;

        public WeatherController(WeatherService weatherService) {
            this.weatherService = weatherService;
        }

        @GetMapping("/weather")
        public String getWeather(
                @RequestParam(required = false) String city,
                Model model) {

            if (city != null && !city.isEmpty()) {
                try {
                    model.addAttribute("weather", weatherService.getWeather(city));
                } catch (CityNotFoundException e) {
                    model.addAttribute("error", e.getMessage());
                }
            }
            return "weather";
        }
    }

