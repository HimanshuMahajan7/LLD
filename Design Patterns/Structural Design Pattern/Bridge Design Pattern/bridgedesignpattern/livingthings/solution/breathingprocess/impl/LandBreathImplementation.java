package bridgedesignpattern.livingthings.solution.breathingprocess.impl;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class LandBreathImplementation implements BreathImplementor {
    @Override
    public void breath() {
        System.out.println("Breath through Nose");
        System.out.println("Inhale Oxygen from air");
        System.out.println("Exhale Carbon Dioxide");
    }
}
