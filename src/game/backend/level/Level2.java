package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;

// Nivel GoldenBoard

public class Level2 extends Level {

    private static final int MAX_MOVES = 25;

    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    public class Level2State extends GameState {
        private long nonGoldenCells;
        private final boolean[][] goldenGrid = new boolean[Grid.SIZE][Grid.SIZE];

        public Level2State(int maxMoves) {
            setMaxMoves(maxMoves);
            this.nonGoldenCells = Grid.SIZE * Grid.SIZE;
        }

        @Override
        public boolean gameOver() {
            return playerWon() || getMoves() >= getMaxMoves();
        }

        @Override
        public boolean playerWon() {
            return nonGoldenCells == 0;
        }

        public void setGoldenCell(int row, int col){
            goldenGrid[row][col] = true;
            nonGoldenCells--;
        }

        public long getNonGoldenCells(){
            return nonGoldenCells;
        }

        public boolean getGoldenCell(int row, int col){
            return goldenGrid[row][col];
        }
    }

}
