package bridgedesignpattern.livingthings.solution;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public abstract class LivingThings {

    BreathImplementor breathImplementor;

    public LivingThings(BreathImplementor breathImplementor) {
        this.breathImplementor = breathImplementor;
    }

    abstract public void breathProcess();
}
