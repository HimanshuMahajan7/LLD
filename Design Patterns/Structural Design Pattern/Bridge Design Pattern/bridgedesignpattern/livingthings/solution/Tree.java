package bridgedesignpattern.livingthings.solution;

import bridgedesignpattern.livingthings.solution.breathingprocess.BreathImplementor;

public class Tree extends LivingThings {

    public Tree(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
}
