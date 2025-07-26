package nullobjectpattern.example1.src;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("CAR");
        printVehicleDetails(vehicle);

        Vehicle wrongVehicle = VehicleFactory.getVehicle("WRONG");
        printVehicleDetails(wrongVehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    }
}
