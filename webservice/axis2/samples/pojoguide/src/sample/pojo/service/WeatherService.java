/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package sample.pojo.service;

import java.util.ArrayList;
import java.util.List;

import sample.pojo.data.Weather;

public class WeatherService {

    private final static List<Weather> WEATHER_CACHE = new ArrayList<Weather>();

    public void createWeather(Weather weather) {

        System.out.println("Add the " + (WEATHER_CACHE.size() + 1) + "the weather: " + weather);
        WEATHER_CACHE.add(weather);
    }

    public Weather getWeather(int index) {

        System.out.println("Retrieve the last weather from cache:[" + WEATHER_CACHE + "]");
        return WEATHER_CACHE.get(WEATHER_CACHE.size() - 1);
    }

    public String hello(String user) {

        System.out.println("Welcome to your, " + user);
        return "Welcome to your, " + user;
    }

    public Weather[] getWeathers() {

        return WEATHER_CACHE.toArray(new Weather[0]);
    }

    public List<Weather> listWeathers() {

        return WEATHER_CACHE;
    }
}