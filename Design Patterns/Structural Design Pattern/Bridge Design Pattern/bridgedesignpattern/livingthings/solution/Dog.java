package bridgedesignpattern.livingthings.solution;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class Dog extends LivingThings {

    public Dog(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
}
