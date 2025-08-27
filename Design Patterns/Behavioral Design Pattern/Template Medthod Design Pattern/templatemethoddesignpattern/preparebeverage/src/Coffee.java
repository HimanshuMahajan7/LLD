package templatemethoddesignpattern.preparebeverage.src;

public class Coffee extends Beverage {

    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
