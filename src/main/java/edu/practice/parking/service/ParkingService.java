package edu.practice.parking.service;
import edu.practice.parking.model.*;import edu.practice.parking.dto.*;import edu.practice.parking.repo.*;import edu.practice.parking.error.*;
import org.springframework.stereotype.Service;import java.util.*;

@Service
public class ParkingService {

 private final PassRepository repo;

 public ParkingService(PassRepository repo){
  this.repo=repo;
 }

 public Collection<ParkingPass> all(){
  return repo.all();
 }

 public Quote quote(long id,int minutes){
  if (minutes<=0){
   throw new IllegalArgumentException(
           "Stay minutes must be greater than zero"
   );
  }
  ParkingPass pass = repo.get(id);

  if (pass==null){
   throw new PassNotFoundException(id);
  }
  int price = pass.priceCents(minutes);

  return new Quote(
          pass.getId(),
          pass.getRegistration(),
          pass.getClass().getSimpleName(),
          minutes,
          price
  );
 }

 public List<Quote> allQuotes(int minutes){
  if (minutes<=0) {
   throw new IllegalArgumentException(
           "Stay minutes must be greater than zero"
   );
  }

  List<Quote> quotes = new ArrayList<>();

  for (ParkingPass pass : repo.all()){
   int price = pass.priceCents(minutes);

   Quote quote = new Quote(
           pass.getId(),
           pass.getRegistration(),
           pass.getClass().getSimpleName(),
           minutes,
           price
   );
   quotes.add(quote);
  }

  quotes.sort(
          Comparator.comparingInt(Quote::priceCents).thenComparingLong(Quote::id)
  );

  return quotes;
 }

 public ParkingPass addHourly(NewHourlyPass body){
  // TODO Task 3: validate id, registration, rate and duplicate ID before saving.
  if (body.id() <= 0){
   throw new IllegalArgumentException(
           "ID must be greater than zero"
   );
  }

  if (body.registration() == null || body.registration().isBlank()) {
   throw new IllegalArgumentException(
           "Registration must not be blank"
   );
  }

  if (body.rateCents() <=0 ){
   throw new IllegalArgumentException(
           "Hourly rate must be greater than zero"
   );
  }

  if (repo.contains(body.id())){
   throw new IllegalArgumentException(
           "A parking pass with this ID already exists"
   );
  }

  HourlyPass pass = new HourlyPass(
          body.id(),
          body.registration(),
          body.rateCents()
  );

  repo.save(pass);
  return pass;
 }

 // You may add a private helper method for constructing Quote objects.
}
