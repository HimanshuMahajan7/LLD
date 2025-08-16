package bridgedesignpattern.livingthings.solution;

import bridgedesignpattern.livingthings.solution.breathingprocess.impl.TreeBreathImplementation;

public class Main {
    public static void main(String[] args) {
        LivingThings treeObj = new Tree(new TreeBreathImplementation());
        treeObj.breathProcess();
    }
}
