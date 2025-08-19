package commanddesignpattern.src;

public class TurnACOffCommand implements ICommand {

    AirConditioner airConditioner;

    public TurnACOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOffAC();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAC();
    }
}
