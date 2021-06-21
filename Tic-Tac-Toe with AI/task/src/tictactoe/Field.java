package tictactoe;

class Field {

    private int x;
    private int y;
    private Character[][] field;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        field = new Character[x][y];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = '_';
            }
        }
    }

    public void setSymbolToField(int x, int y, char symbol) {
        field[x - 1][y - 1] = symbol;
    }

    public char getSymbol(int x, int y) {
        return field[x - 1][y - 1];
    }

    public Character[][] getField() {
        return field;
    }
}
