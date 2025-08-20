package decoratordesignpattern.pizza.pizza;

public class VegDelightPizza extends BasePizza {

    @Override
    public int cost() {
        return 120;
    }
}