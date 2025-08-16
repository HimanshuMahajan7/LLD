package bridgedesignpattern.livingthings.problem;

public class Dog extends LivingThings {
    @Override
    public void breathProcess() {
        System.out.println("Breath through Nose");
        System.out.println("Inhale Oxygen from air");
        System.out.println("Exhale Carbon Dioxide");
    }
}
