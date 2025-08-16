package bridgedesignpattern.livingthings.solution;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class Fish extends LivingThings {

    public Fish(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
}
