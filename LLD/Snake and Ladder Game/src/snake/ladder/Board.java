package src.snake.ladder;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesAndLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (Cell[] row : cells) {
            Arrays.fill(row, new Cell());
        }
    }

    private void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        int minCellNum = 1;
        int maxCellNum = cells.length * cells.length - 1;
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(minCellNum, maxCellNum);
            int snakeTail = ThreadLocalRandom.current().nextInt(minCellNum, maxCellNum);
            if (snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCells(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(minCellNum, maxCellNum);
            int ladderEnd = ThreadLocalRandom.current().nextInt(minCellNum, maxCellNum);
            if (ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCells(ladderStart);
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    Cell getCells(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = playerPosition % cells.length;
        return cells[boardRow][boardColumn];
    }
}
