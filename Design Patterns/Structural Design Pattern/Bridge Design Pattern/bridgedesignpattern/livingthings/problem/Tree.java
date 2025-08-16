package bridgedesignpattern.livingthings.problem;

public class Tree extends LivingThings {
    @Override
    public void breathProcess() {
        System.out.println("Breath through LEAVES");
        System.out.println("Inhale Carbon Dioxide");
        System.out.println("Exhale Oxygen through Photosynthesis");
    }
}
