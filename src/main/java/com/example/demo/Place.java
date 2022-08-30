package com.example.demo;

import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

public class Place {

    @NonNull
    @Range(min=0, max=Long.MAX_VALUE)
    private Long id;

    @NonNull
    @Size(min = 10)
    @Size(max = 250)
    private String address;

    @NonNull
    @Size(min = 3)
    @Size(max = 250)
    private String country;

    @NonNull
    private double lat;

    @NonNull
    private double lon;

    private String category;

    public Place() {
    }

    public Place(Long id, String address, String country, double lat, double lon, String category) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
