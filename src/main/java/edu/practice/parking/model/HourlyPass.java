package edu.practice.parking.model;
public class HourlyPass extends ParkingPass {
 private final int rateCents;
 public HourlyPass(long id,String registration,int rateCents){super(id,registration);this.rateCents=rateCents;}
 public int getRateCents(){return rateCents;}
 public int priceCents(int stayMinutes){
  // TODO Task 1: round up partial hours; one-hour minimum, validate input.
  throw new UnsupportedOperationException("Task 1");
 }
}
