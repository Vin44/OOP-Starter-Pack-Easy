package edu.practice.parking.model;

public class HourlyPass extends ParkingPass {

 private final int rateCents;

 public HourlyPass(long id,String registration,int rateCents){
  super(id,registration);
  this.rateCents=rateCents;
 }

 public int getRateCents(){
  return rateCents;
 }

@Override
 public int priceCents(int stayMinutes){

  if(stayMinutes<=0){
   throw new IllegalArgumentException(
           "Stay minustes must be greater than Zero."
   );
  }

  return (int) Math.ceil(stayMinutes/60.0) * rateCents;

 }
}
