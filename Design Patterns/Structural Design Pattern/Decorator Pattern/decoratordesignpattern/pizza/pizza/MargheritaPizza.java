package decoratordesignpattern.pizza.pizza;

public class MargheritaPizza extends BasePizza {

    @Override
    public int cost() {
        return 100;
    }
}