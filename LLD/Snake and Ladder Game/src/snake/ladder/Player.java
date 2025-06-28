package src.snake.ladder;

public class Player {
    String id;
    String name;
    int position;

    public Player(String id, int position) {
        this.id = id;
        this.position = position;
    }

    public Player(String id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
