package commanddesignpattern.src;

public class AirConditioner {

    boolean isOn;
    int temperature;

    public void turnOnAC() {
        isOn = true;
        System.out.println("Turning ON AC");
    }

    public void turnOffAC() {
        isOn = false;
        System.out.println("Turning OFF AC");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Setting temperature to: " + temperature);
    }
}
