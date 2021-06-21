package tictactoe;

import java.util.Scanner;

public class User {
    private int x;
    private int y;
    private Character[][] field;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setField(Character[][] field) {
        this.field = field;
    }

    public void enterCoordinates() {
        System.out.print("Enter the coordinates:");
        Scanner sc = new Scanner(System.in);
        x = 0;
        y = 0;
        if (sc.hasNextInt()) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x > field[0].length || y > field.length) {
                System.out.printf("Coordinates should be from 1 to %d!\n", field.length);
                enterCoordinates();
            } else {
                if (field[x - 1][y - 1].equals('X') || field[x - 1][y - 1].equals('O')) {
                    System.out.println("This cell is occupied! Choose another one!");
                    enterCoordinates();
                }
            }
        } else {
            System.out.println("You should enter numbers!");
            enterCoordinates();
        }
    }
}
