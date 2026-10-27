package edu.practice.parking.error;
public class PassNotFoundException extends RuntimeException {
 public PassNotFoundException(long id){super("Parking pass not found: "+id);}
}
