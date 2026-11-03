package edu.practice.parking.controller;

import edu.practice.parking.service.*;
import edu.practice.parking.model.*;
import edu.practice.parking.dto.*;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passes")
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<ParkingPass> list() {
        return service.all();
    }

    @GetMapping("/{id}/quote")
    public Quote quote(@PathVariable Long id, int minutes){
        return service.quote(id, minutes);
    }

    @GetMapping("/quotes")
    public List<Quote> quotes(@RequestParam int minutes){
        return service.allQuotes(minutes);
    }

    @PostMapping("/hourly")
    public ResponseEntity<ParkingPass> pass(@RequestBody NewHourlyPass passEntity){
        ParkingPass created = service.addHourly(passEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // TODO Task 4: GET /{id}/quote?minutes=..., GET /quotes?minutes=... and POST /hourly.
    // POST must return HTTP 201 with the created record.
}
