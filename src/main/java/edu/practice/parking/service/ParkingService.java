package edu.practice.parking.service;

import edu.practice.parking.model.*;
import edu.practice.parking.dto.*;
import edu.practice.parking.repo.*;
import edu.practice.parking.error.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingService {
    private final PassRepository repo;

    public ParkingService(PassRepository repo) {
        this.repo = repo;
    }

    public Collection<ParkingPass> all() {
        return repo.all();
    }

    public Quote quote(long id, int minutes) {
        // TODO Task 3: validate stay, return 404 when ID missing, calculate dynamically.
        if (minutes<=0){
            throw new IllegalArgumentException("Minutes must be greater than Zero.");
        }

        ParkingPass pass = repo.get(id);

        if (pass==null){
            throw new PassNotFoundException(id);
        }

        return new Quote(
                id,
                pass.getRegistration(),
                pass.getClass().getSimpleName(),
                minutes,
                pass.priceCents(minutes)
        );

//        throw new UnsupportedOperationException("Task 3");
    }

    public List<Quote> allQuotes(int minutes) {
         List<Quote> quotes = new ArrayList<>();

         for(ParkingPass pass : repo.all()){

             Quote quote = new Quote(
                     pass.getId(),
                     pass.getRegistration(),
                     pass.getClass().getSimpleName(),
                     minutes,
                     pass.priceCents(minutes)
             );

             quotes.add(quote);
         }

         quotes.sort(
                 Comparator.comparingInt(Quote::priceCents).thenComparingLong(Quote::id)
         );

         return quotes;
    }

    public ParkingPass addHourly(NewHourlyPass body) {
        // TODO Task 3: validate id, registration, rate and duplicate ID before saving.
        if (body.id()<=0){
            throw new IllegalArgumentException("ID must be greater than zero.");
        }

        if(body.registration()==null){
            throw new IllegalArgumentException("Registration Must have a value.");
        }

        if(body.rateCents()<=0){
            throw new IllegalArgumentException("Rate must be greater than zero.");
        }

        HourlyPass pass = new HourlyPass(body.id(), body.registration(), body.rateCents());

        repo.save(pass);

        return pass;

//        throw new UnsupportedOperationException("Task 3");
    }
    // You may add a private helper method for constructing Quote objects.
}
