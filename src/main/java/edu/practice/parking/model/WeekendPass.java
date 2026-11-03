package edu.practice.parking.model;

public class WeekendPass extends ParkingPass{
    private int flatCents;

    public WeekendPass(long id, String registration, int flatCents){
        super(id, registration);
        this.flatCents = flatCents;
    }

    @Override
    public int priceCents(int stayMinutes){
        if (stayMinutes<=0){
            throw new IllegalArgumentException("Stay Minutes must be greater than zero.");
        }
        if (stayMinutes<=480){
            return flatCents;
        }

        int extraMinutes = stayMinutes - 480;
        int extraHours = (int) Math.ceil((double) extraMinutes/60);
        int extraPrice = extraHours*150;

        return flatCents+extraPrice;
    }

}
