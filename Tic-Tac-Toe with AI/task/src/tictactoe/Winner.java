package tictactoe;

public class Winner {
    private String state;
    private int xWins;
    private int oWins;

    private String horizontalWins(Character[][] input) {
        state = null;
        for (int i = 0; i < input[0].length; i++) {
            xWins = 0;
            oWins = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[i][j].equals('X')) {
                    xWins++;
                }
                if (input[i][j].equals('O')) {
                    oWins++;
                }
            }
            if (xWins == input[0].length) {
                state = "X wins";
                break;
            }
            if (oWins == input[0].length) {
                state = "O wins";
                break;
            }
        }
        return state;
    }

    private String verticalWins(Character[][] input) {
        state = null;
        for (int j = 0; j < input.length; j++) {
            xWins = 0;
            oWins = 0;
            for (int i = 0; i < input[0].length; i++) {
                if (input[i][j].equals('X')) {
                    xWins++;
                }
                if (input[i][j].equals('O')) {
                    oWins++;
                }
            }
            if (xWins == input[0].length) {
                state = "X wins";
                break;
            }
            if (oWins == input[0].length) {
                state = "O wins";
                break;
            }
        }
        return state;
    }

    private String rightDiagonalWins(Character[][] input) {
        state = null;
        xWins = 0;
        oWins = 0;
        for (int i = 0; i < input[0].length; i++) {
            if (input[i][i].equals('X')) {
                xWins++;
            }
            if (input[i][i].equals('O')) {
                oWins++;
            }
            if (xWins == input[0].length) {
                state = "X wins";
                break;
            }
            if (oWins == input[0].length) {
                state = "O wins";
                break;
            }
        }
        return state;
    }

    private String leftDiagonalWins(Character[][] input) {
        state = null;
        xWins = 0;
        oWins = 0;
        for (int i = 0; i < input[0].length; i++) {
            if (input[i][input[0].length - i - 1].equals('X')) {
                xWins++;
            }
            if (input[i][input[0].length - i - 1].equals('O')) {
                oWins++;
            }
            if (xWins == input[0].length) {
                state = "X wins";
                break;
            }
            if (oWins == input[0].length) {
                state = "O wins";
                break;
            }
        }
        return state;
    }

    public String findWinnersIn(Character[][] input, int numbersOfInputs) {
        if (horizontalWins(input) != null ) {
            return horizontalWins(input);
        }
        if (verticalWins(input) != null ) {
            return verticalWins(input);
        }
        if (rightDiagonalWins(input) != null ) {
            return rightDiagonalWins(input);
        }
        if (leftDiagonalWins(input) != null ) {
            return leftDiagonalWins(input);
        }
        if (numbersOfInputs == input[0].length * input.length) {
            return "Draw";
        }
       return "Game not finished";
    }
}


