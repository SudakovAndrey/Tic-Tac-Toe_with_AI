package tictactoe;

import java.util.Random;

public class RobotEasy {
    private int x;
    private int y;
    private Character[][] field;
    Random random = new Random();

    public void setField(Character[][] field) {
        this.field = field;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void robotEnterCoordinates() {
        x = random.nextInt(field[0].length) + 1;
        y = random.nextInt(field[0].length) + 1;
        if (field[x - 1][y - 1].equals('X') || field[x - 1][y - 1].equals('O')) {
            robotEnterCoordinates();
        }
    }
}
