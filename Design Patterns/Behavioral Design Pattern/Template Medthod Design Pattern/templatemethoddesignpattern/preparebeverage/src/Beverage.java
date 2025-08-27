package templatemethoddesignpattern.preparebeverage.src;

public abstract class Beverage {

    // Template Method (final to prevent overriding)
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps left to subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}
