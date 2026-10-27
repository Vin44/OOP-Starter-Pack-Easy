package edu.practice.parking.model;
public abstract class ParkingPass {
 private final long id; private final String registration;
 protected ParkingPass(long id,String registration){this.id=id;this.registration=registration;}
 public long getId(){return id;}
 public String getRegistration(){return registration;}
 public abstract int priceCents(int stayMinutes);
}
