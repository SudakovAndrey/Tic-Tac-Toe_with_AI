package tictactoe;

import java.util.Random;

public class RobotMedium {
    private int x;
    private int y;
    private int tempX;
    private int tempY;
    private Character[][] field;
    Random random = new Random();
    private char symbol;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setField(Character[][] field) {
        this.field = field;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private String horizontalRobotSteps() {
        for (int i = 0; i < field[0].length; i++) {
            int xWins = 0;
            int oWins = 0;
            int xBlock = 0;
            int oBlock = 0;
            int empty = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j].equals('X') && symbol == 'X') {
                    xWins++;
                }
                if (field[i][j].equals('O') && symbol == 'O') {
                    oWins++;
                }
                if (field[i][j].equals('X') && symbol == 'O') {
                    oBlock++;
                }
                if (field[i][j].equals('O') && symbol == 'X') {
                    xBlock++;
                }
                if (field[i][j].equals('_')) {
                    empty++;
                    tempX = i;
                    tempY = j;
                }
            }
            if (xWins == field.length - 1 && empty == 1) {
                return "xCanWin";
            }
            if (oWins == field.length - 1 && empty == 1) {
                return "oCanWin";
            }
            if (oBlock == field.length - 1 && empty == 1) {
                return "oCanBlock";
            }
            if (xBlock == field.length - 1 && empty == 1) {
                return "xCanBlock";
            }
        }
        return "Not found";
    }

    private String verticalRobotSteps() {
        for (int j = 0; j < field.length; j++) {
            int xWins = 0;
            int oWins = 0;
            int xBlock = 0;
            int oBlock = 0;
            int empty = 0;
            for (int i = 0; i < field[0].length; i++) {
                if (field[i][j].equals('X') && symbol == 'X') {
                    xWins++;
                }
                if (field[i][j].equals('O') && symbol == 'O') {
                    oWins++;
                }
                if (field[i][j].equals('X') && symbol == 'O') {
                    oBlock++;
                }
                if (field[i][j].equals('O') && symbol == 'X') {
                    xBlock++;
                }
                if (field[i][j].equals('_')) {
                    empty++;
                    tempX = i;
                    tempY = j;
                }
            }
            if (xWins == field.length - 1 && empty == 1) {
                return "xCanWin";
            }
            if (oWins == field.length - 1 && empty == 1) {
                return "oCanWin";
            }
            if (oBlock == field.length - 1 && empty == 1) {
                return "oCanBlock";
            }
            if (xBlock == field.length - 1 && empty == 1) {
                return "xCanBlock";
            }
        }
        return "Not found";
    }

    private String rightDiagonalRobotSteps() {
        int xWins = 0;
        int oWins = 0;
        int xBlock = 0;
        int oBlock = 0;
        int empty = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i].equals('X') && symbol == 'X') {
                xWins++;
            }
            if (field[i][i].equals('O') && symbol == 'O') {
                oWins++;
            }
            if (field[i][i].equals('X') && symbol == 'O') {
                oBlock++;
            }
            if (field[i][i].equals('O') && symbol == 'X') {
                xBlock++;
            }
            if (field[i][i].equals('_')) {
                empty++;
                tempX = i;
                tempY = i;
            }

            if (xWins == field.length - 1 && empty == 1) {
                return "xCanWin";
            }
            if (oWins == field.length - 1 && empty == 1) {
                return "oCanWin";
            }
            if (oBlock == field.length - 1 && empty == 1) {
                return "oCanBlock";
            }
            if (xBlock == field.length - 1 && empty == 1) {
                return "xCanBlock";
            }
        }
        return "Not found";
    }

    private String leftDiagonalRobotSteps() {
        int xWins = 0;
        int oWins = 0;
        int xBlock = 0;
        int oBlock = 0;
        int empty = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][field[0].length - i - 1].equals('X') && symbol == 'X') {
                xWins++;
            }
            if (field[i][field[0].length - i - 1].equals('O') && symbol == 'O') {
                oWins++;
            }
            if (field[i][field[0].length - i - 1].equals('X') && symbol == 'O') {
                oBlock++;
            }
            if (field[i][field[0].length - i - 1].equals('O') && symbol == 'X') {
                xBlock++;
            }
            if (field[i][field[0].length - i - 1].equals('_')) {
                empty++;
                tempX = i;
                tempY = field[0].length - i - 1;
            }

            if (xWins == field.length - 1 && empty == 1) {
                return "xCanWin";
            }
            if (oWins == field.length - 1 && empty == 1) {
                return "oCanWin";
            }
            if (oBlock == field.length - 1 && empty == 1) {
                return "oCanBlock";
            }
            if (xBlock == field.length - 1 && empty == 1) {
                return "xCanBlock";
            }
        }
        return "Not found";
    }

    public String findRobotSteps() {
        if (!horizontalRobotSteps().equals("Not found")) {
            return horizontalRobotSteps();
        }
        if (!verticalRobotSteps().equals("Not found")) {
            return verticalRobotSteps();
        }
        if (!rightDiagonalRobotSteps().equals("Not found")) {
            return rightDiagonalRobotSteps();
        }
        if (!leftDiagonalRobotSteps().equals("Not found")) {
            return leftDiagonalRobotSteps();
        }
        return "Not found";
    }

    public void robotMediumEnterCoordinates() {
        switch (findRobotSteps()) {
            case "Not found":
                x = random.nextInt(field[0].length) + 1;
                y = random.nextInt(field[0].length) + 1;
                if (field[x - 1][y - 1].equals('X') || field[x - 1][y - 1].equals('O')) {
                    robotMediumEnterCoordinates();
                }
                break;
            case "xCanWin":
            case "oCanWin":
            case "oCanBlock":
            case "xCanBlock":
                x = tempX + 1;
                y = tempY + 1;
                break;
        }
    }
}
