package com.example.lab08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CityListTest {

    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.add(new City("Edmonton", "AB"));
        return cityList;
    }

    @Test
    void testHasCity() {
        CustomList cityList = mockCityList();
        City city = new City("Edmonton", "AB");
        assertTrue(cityList.hasCity(city));

        City fakeCity = new City("Vancouver", "BC");
        assertFalse(cityList.hasCity(fakeCity));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = mockCityList();
        City city = new City("Edmonton", "AB");

        assertTrue(cityList.hasCity(city));

        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city), "City should be removed from list");
    }

    @Test
    void testDeleteCityException() {
        CustomList cityList = new CustomList();
        City city = new City("Calgary", "AB");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    void testCountCities() {
        CustomList cityList = new CustomList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "AB"));
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Calgary", "AB"));
        assertEquals(2, cityList.countCities());
    }
}
