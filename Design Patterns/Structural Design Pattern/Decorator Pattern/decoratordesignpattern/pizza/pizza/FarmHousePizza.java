package decoratordesignpattern.pizza.pizza;

public class FarmHousePizza extends BasePizza {

    @Override
    public int cost() {
        return 200;
    }
}