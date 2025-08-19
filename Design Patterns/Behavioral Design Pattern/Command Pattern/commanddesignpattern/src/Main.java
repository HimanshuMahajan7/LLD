package commanddesignpattern.src;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        MyRemoteControl remoteObject = new MyRemoteControl();

        remoteObject.setCommand(new TurnACOnCommand(airConditioner));
        remoteObject.pressButton();

        remoteObject.undo();
    }
}
