package flyweightdesignpattern.game.src;

public class RoboticDog implements IRobot{

    private String type;
    private Spirit spirit;

    public RoboticDog(String type, Spirit spirit) {
        this.type = type;
        this.spirit = spirit;
    }

    public String getType() {
        return type;
    }

    public Spirit getSpirit() {
        return spirit;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Rendering Spirit at position: " + x + " and " + y);
    }
}
