package tictactoe;

import java.util.Arrays;

public class Printer {

    public void printField(Character[][] field) {
        int k = 0;
        for (int i = 0; i < field.length + 2; i++) {
            for (int j = 0; j < field[0].length + 6; j++) {
                if (i == 0 || i == field[0].length + 1) {
                    System.out.print("-");
                } else {
                    if (j == 0 || j == field[0].length + 5) {
                        System.out.print("|");
                    } else {
                        if (j % 2 == 0) {
                            System.out.print(Arrays.deepToString(field)
                                    .replaceAll("[,\\[\\] ]", "")
                                    .replace("_", " ")
                                    .charAt(k));
                            k++;
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
