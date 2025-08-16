package bridgedesignpattern.livingthings.problem;

public class Fish extends LivingThings {
    @Override
    public void breathProcess() {
        System.out.println("Breath through GILLS");
        System.out.println("Absorb Oxygen from water");
        System.out.println("Release Carbon Dioxide");
    }
}
