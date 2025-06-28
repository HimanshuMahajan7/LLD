package src.snake.ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 8, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("P1",0);
        Player player2 = new Player("P2",0);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn: " + playerTurn.id + ", Current Position: " + playerTurn.position);

            int diceNumbers = dice.rollDice();
            int playerNewPosition = playerTurn.position + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.position = playerNewPosition;

            System.out.println("Player turn: " + playerTurn.id + ", New Position: " + playerTurn.position);
            if (playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }

        System.out.println("Winner is " + winner.id);
    }

    private Player findPlayerTurn() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }
        Cell cell = board.getCells(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = cell.jump.start < cell.jump.end ? "Ladder" : "Snake";
            System.out.println("Jump by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
