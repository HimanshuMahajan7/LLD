package bridgedesignpattern.livingthings.solution.breathingprocess.impl;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class TreeBreathImplementation implements BreathImplementor {
    @Override
    public void breath() {
        System.out.println("Breath through LEAVES");
        System.out.println("Inhale Carbon Dioxide");
        System.out.println("Exhale Oxygen through Photosynthesis");
    }
}
