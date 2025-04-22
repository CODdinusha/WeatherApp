package com.example.weatherApp.exception;


    public class CityNotFoundException extends RuntimeException {
        public CityNotFoundException(String message) {
            super(message);
        }
    }

