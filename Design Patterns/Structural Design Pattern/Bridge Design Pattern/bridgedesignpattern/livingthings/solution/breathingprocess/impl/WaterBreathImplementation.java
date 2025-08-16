package bridgedesignpattern.livingthings.solution.breathingprocess.impl;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class WaterBreathImplementation implements BreathImplementor {
    @Override
    public void breath() {
        System.out.println("Breath through GILLS");
        System.out.println("Absorb Oxygen from water");
        System.out.println("Release Carbon Dioxide");
    }
}
