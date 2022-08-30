package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FastController {

    private PlaceService placeService = new PlaceService();

    @GetMapping("/places")
    public ResponseEntity<List<Place>> getListOfPlaces(@RequestParam(required = false) String country) {
        return new ResponseEntity<>(placeService.getListOfPlaces(country), HttpStatus.OK);
    }

    @GetMapping("/place")
    public ResponseEntity<Place> getPlaceById(@RequestParam Long id) {
        Place place = placeService.getPlaceById(id);

        if (place == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(place, HttpStatus.OK);
        }
    }

    @DeleteMapping("/place")
    public ResponseEntity deletePlaceByAddress(@RequestParam String address) {
        boolean result = placeService.deletePlaceById(address);
        return new ResponseEntity(result ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/place")
    public ResponseEntity<Place> addPlace(@RequestBody @Valid Place place) {
        Place placeNew = placeService.addPlace(place);
        return new ResponseEntity<>(placeNew, HttpStatus.OK);
    }
}
