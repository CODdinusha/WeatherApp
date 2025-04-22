package com.example.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class WeatherResponse {
        private String name; // city name
        private Main main;
        private Weather[] weather;
        private Wind wind;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public Weather[] getWeather() {
            return weather;
        }

        public void setWeather(Weather[] weather) {
            this.weather = weather;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public static class Main {
            private double temp;
            private int humidity;
            private double temp_min;
            private double temp_max;

            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
            }

            public int getHumidity() {
                return humidity;
            }

            public void setHumidity(int humidity) {
                this.humidity = humidity;
            }

            public double getTemp_min() {
                return temp_min;
            }

            public void setTemp_min(double temp_min) {
                this.temp_min = temp_min;
            }

            public double getTemp_max() {
                return temp_max;
            }

            public void setTemp_max(double temp_max) {
                this.temp_max = temp_max;
            }


        }

        public static class Weather {
            private String main;
            private String description;
            private String icon;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class Wind {
            private double speed;

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }
        }
    }

