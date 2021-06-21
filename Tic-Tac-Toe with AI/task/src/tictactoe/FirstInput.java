package tictactoe;

import java.util.Scanner;

public class FirstInput {

    private String input = "";
    private String start;
    private String user1;
    private String user2;
    private String player1;
    private String player2;
    private Character[][] field;

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getInput() {
        return input;
    }

    public void firstChoice() {
        System.out.print("Input command:");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        if (!input.equals("exit")) {
            String[] sbString = input.split(" ");
            if (sbString.length != 0) {
                try {
                    start = sbString[0];
                    user1 = sbString[1];
                    user2 = sbString[2];
                } catch (Exception e) {
                    System.out.println("Bad parameters!");
                    firstChoice();
                    return;
                }
                if (start.equals("start") && (user1.equals("user") || user1.equals("easy") || user1.equals("medium") || user1.equals("hard")) &&
                        (user2.equals("user") || user2.equals("easy") || user2.equals("medium") || user2.equals("hard"))) {
                    switch (user1) {
                        case "user":
                            player1 = "User";
                            break;
                        case "easy":
                            player1 = "Robot easy";
                            break;
                        case "medium":
                            player1 = "Robot medium";
                            break;
                        case "hard":
                            player1 = "Robot hard";
                            break;
                    }
                    switch (user2) {
                        case "user":
                            player2 = "User";
                            break;
                        case "easy":
                            player2 = "Robot easy";
                            break;
                        case "medium":
                            player2 = "Robot medium";
                            break;
                        case "hard":
                            player2 = "Robot hard";
                            break;
                    }
                } else {
                    System.out.println("Bad parameters!");
                    firstChoice();
                }
            } else {
                System.out.println("Bad parameters!");
                firstChoice();
            }
        }
    }
}
