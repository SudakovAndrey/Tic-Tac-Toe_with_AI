package tictactoe;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RobotHard {
    private int x;
    private int y;
    private int tempX;
    private int tempY;
    private Character[][] field;
    private Character symbol;
    private char opponentSymbol;
    Winner winner = new Winner();

    public void setField(Character[][] field) {
        this.field = field;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    static Boolean isMovesLeft(Character[][] field) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (field[i][j] == '_')
                    return true;
        return false;
    }

    public void robotHardEnterCoordinates() {
        // AI to make its turn
        if (symbol.equals('X')) {
            opponentSymbol = 'O';
        } else {
            opponentSymbol = 'X';
        }
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field.length; j++) {
                // Is the spot available?
                if (field[i][j].equals('_')) {
                    field[i][j] = symbol;
                    int score = minimax(field, 0, false);
                    field[i][j] = '_';
                    if (score > bestScore) {
                        bestScore = score;
                        tempX = i;
                        tempY = j;
                    }
                }
            }
        }
        x = tempX + 1;
        y = tempY + 1;
    }

    private int minimax(Character[][] field, int depth, boolean isMaximizing) {
        String result = winner.findWinnersIn(field, depth + 1);
        if (!result.equals("Game not finished")) {
            if (result.equals(symbol + " wins")) {
                return 10;
            } else {
                if (result.equals(opponentSymbol + " wins"))
                    return -10;
            }
        }

        if (!isMovesLeft(field)) {
            return 0;
        }
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < field[0].length; i++) {
                for (int j = 0; j < field.length; j++) {
                    // Is the spot available?
                    if (field[i][j].equals('_')) {
                        field[i][j] = symbol;
                        int score = minimax(field, depth + 1, false);
                        field[i][j] = '_';
                        bestScore = max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < field[0].length; i++) {
                for (int j = 0; j < field.length; j++) {
                    // Is the spot available?
                    if (field[i][j].equals('_')) {
                        field[i][j] = opponentSymbol;
                        int score = minimax(field, depth + 1, true);
                        field[i][j] = '_';
                        bestScore = min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
