package nullobjectpattern.example1.src;

public class Car implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 40;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
