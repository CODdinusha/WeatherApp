package com.example.weatherApp.controller;

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
        public String getWeather(@RequestParam(required = false) String city, Model model) {
            if (city != null && !city.isEmpty()) {
                model.addAttribute("weather", weatherService.getWeather(city));
            }
            return "weather";
        }
    }

