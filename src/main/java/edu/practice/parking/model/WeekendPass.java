package edu.practice.parking.model;

public class WeekendPass extends ParkingPass{

    private final int flatCents;

    public WeekendPass(long id, String registration, int flatCents) {
        super(id, registration);
        this.flatCents = flatCents;
    }

    public int getFlatCents(){
        return flatCents;
    }

    @Override
    public int priceCents(int stayMinutes) {
        if(stayMinutes<=0){
            throw new IllegalArgumentException(
                    "Stay minustes must be greater than Zero."
            );
        }

        if(stayMinutes<=480){
            return flatCents;
        }

        int additionalTimeMinutes = stayMinutes - 480;
        int additionalTImeHours = (int) Math.ceil(
                additionalTimeMinutes/60.0
        );

        return flatCents + (additionalTImeHours*150);
    }
}
