package ParkingSystem;

import java.util.*;

enum VehicleSize {
    SMALL, MEDIUM, LARGE
}

class Vehicle {
    private String plate;
    private VehicleSize size;
    private String spotId;

    public Vehicle(String plate, VehicleSize size) {
        this.plate = plate;
        this.size = size;
        this.spotId = null;
    }

    public String getPlate() {
        return plate;
    }

    public VehicleSize getSize() {
        return size;
    }

    public String getSpot() {
        return spotId;
    }

    public void setSpot(String id) {
        spotId = id;
    }
}

class Spot {
    private VehicleSize spotSize;
    private String id;
    private Vehicle parkedVehicle;

    public Spot(String id, VehicleSize size) {
        this.id = id;
        this.spotSize = size;
        this.parkedVehicle = null;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean canFit(Vehicle vech) {
        return isAvailable() && vech.getSize().ordinal() <= spotSize.ordinal();
    }

    public void park(Vehicle vech) {
        if (!canFit(vech)) {
            throw new IllegalStateException("Vehicle cannot park here");
        }
        parkedVehicle = vech;
        vech.setSpot(id);
    }

    public void leave() {
        parkedVehicle = null;
    }
}

class ParkingLot {
    private List<Spot> spots;

    public ParkingLot(List<Spot> spots) {
        this.spots = spots;
    }

    public void enter(Vehicle vech) {
        for (Spot spot : spots) {
            if (spot.canFit(vech)) {
                spot.park(vech);
                return;
            }
        }
        throw new IllegalStateException("No available spot");
    }

    public void exit(Vehicle vech) {
        String spotId = vech.getSpot();

        for (Spot spot : spots) {
            if (spot.getId().equals(spotId)) {
                spot.leave();
                vech.setSpot(null);
                return;
            }
        }

        throw new IllegalStateException("Vehicle is not parked");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Spot> spots = Arrays.asList(
            new Spot("S1", VehicleSize.SMALL),
            new Spot("S2", VehicleSize.MEDIUM),
            new Spot("S3", VehicleSize.LARGE)
        );

        ParkingLot lot = new ParkingLot(spots);

        Vehicle car = new Vehicle("ABC123", VehicleSize.MEDIUM);

        lot.enter(car);
        System.out.println("Parked at: " + car.getSpot());

        lot.exit(car);
        System.out.println("Exited parking lot");
    }
}