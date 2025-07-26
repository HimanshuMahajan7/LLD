package nullobjectpattern.example1.src;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        return switch (vehicleType) {
            case "CAR" -> new Car();
            case "BIKE" -> new Bike();
            default -> new NullObject();
        };
    }
}
