package src.snake.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int total = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {
            total += ThreadLocalRandom.current().nextInt(min, max + 1);
            diceUsed++;
        }
        System.out.println("Dice rolled with Numbers: " + total);
        return total;
    }
}
