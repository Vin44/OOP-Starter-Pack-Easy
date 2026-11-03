package edu.practice.parking.model;

public class HourlyPass extends ParkingPass {
    private final int rateCents;

    public HourlyPass(long id, String registration, int rateCents) {
        super(id, registration);
        this.rateCents = rateCents;
    }

    public int getRateCents() {
        return rateCents;
    }

    @Override
    public int priceCents(int stayMinutes) {
        if (stayMinutes<=0){
            throw new IllegalArgumentException("Stay minutes shouldnt be zero or negative.");
        }
        return (int) Math.ceil((double)stayMinutes/60)*rateCents;
//        throw new UnsupportedOperationException("Task 1");
    }
}
