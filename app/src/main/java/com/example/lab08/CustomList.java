package com.example.lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CustomList {
    private List<City> cities;

    public CustomList() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list, (c1, c2) -> c1.getCityName().compareTo(c2.getCityName()));
        return list;
    }
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public int countCities() {
        return cities.size();
    }
}
