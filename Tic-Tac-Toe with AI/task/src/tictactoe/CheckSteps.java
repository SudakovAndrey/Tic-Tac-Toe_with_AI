package tictactoe;

public class CheckSteps {
    private char symbol;
    private Character[][] field;

    public char getSymbol() {
        return symbol;
    }
    public void setField(Character[][] field) {
        this.field = field;
    }

    public int numbersOfInputs() {
        int numberOfInput = 0;
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j].equals('X')) {
                    countX++;
                    numberOfInput++;
                } else {
                    if (field[i][j].equals('O')) {
                        countO++;
                        numberOfInput++;
                    }
                }
                if (countX <= countO) {
                    symbol = 'X';
                } else {
                    symbol = 'O';
                }
            }
        }
        return numberOfInput;
    }
}
