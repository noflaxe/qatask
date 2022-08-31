package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceService {

    private List<Place> listOfPlaces;

    public PlaceService() {
        listOfPlaces = new ArrayList<>();
        listOfPlaces.add(new Place(1L, "Kyiv, Okhtyrskyi Ln. 7", "Ukraine", 50.396453,  30.477545, "Office building"));
    }

    public List<Place> getListOfPlaces(String country) {
        if (country == null) {
            return listOfPlaces;
        } else {
            return listOfPlaces.stream().filter(c -> c.getCountry().equals(country)).collect(Collectors.toList());
        }
    }

    public Place getPlaceById(Long id) {
        return listOfPlaces.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
    }

    public boolean deletePlaceById(String address) {
        Place place = listOfPlaces.stream().filter(p -> p.getAddress().equals(address)).findAny().orElse(null);

        if (place == null) {
            return false;
        } else {
            listOfPlaces.remove(place);
            return true;
        }
       // return listOfPlaces.remove(place);
        /*boolean result = listOfPlaces.contains(place);
        listOfPlaces.clear();
        return result;*/
    }

    public Place addPlace(Place place) {
        listOfPlaces.add(place);
        return place;
    }
}
