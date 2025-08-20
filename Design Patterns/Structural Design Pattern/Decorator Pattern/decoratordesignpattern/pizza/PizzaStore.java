package decoratordesignpattern.pizza;

import decoratordesignpattern.pizza.decorator.ExtraCheese;
import decoratordesignpattern.pizza.decorator.Mushroom;
import decoratordesignpattern.pizza.pizza.BasePizza;
import decoratordesignpattern.pizza.pizza.MargheritaPizza;

public class PizzaStore {
    public static void main(String[] args) {
        // Margarita Pizza with Extra Cheese
        BasePizza pizza1 = new ExtraCheese(new MargheritaPizza());
        int cost1 = pizza1.cost();
        System.out.println(cost1);

        // Margarita Pizza with Extra Cheese and Mushroom
        BasePizza pizza2 = new Mushroom(new ExtraCheese(new MargheritaPizza()));
        int cost2 = pizza2.cost();
        System.out.println(cost2);
    }
}