package tictactoe;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Winner winner = new Winner();
        FirstInput firstInput = new FirstInput();
        User user = new User();
        CheckSteps checkSteps = new CheckSteps();

        while (true) {
            firstInput.firstChoice();
            if (firstInput.getInput().equals("exit")) {
                break;
            }
            Field field = new Field(3, 3);
            checkSteps.setField(field.getField());
            printer.printField(field.getField());

            while (true) {
                switch (firstInput.getPlayer1()) {
                    case "User":
                        user.setField(field.getField());
                        user.enterCoordinates();

                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        field.setSymbolToField(user.getX(), user.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot easy":
                        RobotEasy robotEasy = new RobotEasy();
                        robotEasy.setField(field.getField());
                        robotEasy.robotEnterCoordinates();
                        System.out.println("Making move level \"easy\"");

                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        field.setSymbolToField(robotEasy.getX(), robotEasy.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot medium":
                        RobotMedium robotMedium = new RobotMedium();
                        robotMedium.setField(field.getField());
                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        robotMedium.setSymbol(checkSteps.getSymbol());
                        robotMedium.robotMediumEnterCoordinates();
                        System.out.println("Making move level \"medium\"");

                        field.setSymbolToField(robotMedium.getX(), robotMedium.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot hard":
                        RobotHard robotHard = new RobotHard();
                        robotHard.setField(field.getField());
                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        robotHard.setSymbol(checkSteps.getSymbol());
                        robotHard.robotHardEnterCoordinates();
                        System.out.println("Making move level \"hard\"");

                        field.setSymbolToField(robotHard.getX(), robotHard.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                }
                if (!winner.findWinnersIn(field.getField(), checkSteps.numbersOfInputs()).equals("Game not finished")) {
                    break;
                }
                switch (firstInput.getPlayer2()) {
                    case "User":
                        user.setField(field.getField());
                        user.enterCoordinates();

                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        field.setSymbolToField(user.getX(), user.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot easy":
                        RobotEasy robotEasy = new RobotEasy();
                        robotEasy.setField(field.getField());
                        robotEasy.robotEnterCoordinates();
                        System.out.println("Making move level \"easy\"");

                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        field.setSymbolToField(robotEasy.getX(), robotEasy.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot medium":
                        RobotMedium robotMedium = new RobotMedium();
                        robotMedium.setField(field.getField());
                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();

                        robotMedium.setSymbol(checkSteps.getSymbol());
                        robotMedium.robotMediumEnterCoordinates();
                        System.out.println("Making move level \"medium\"");

                        field.setSymbolToField(robotMedium.getX(), robotMedium.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                    case "Robot hard":
                        RobotHard robotHard = new RobotHard();
                        robotHard.setField(field.getField());
                        checkSteps.setField(field.getField());
                        checkSteps.numbersOfInputs();
                        robotHard.setSymbol(checkSteps.getSymbol());

                        robotHard.robotHardEnterCoordinates();
                        System.out.println("Making move level \"hard\"");

                        field.setSymbolToField(robotHard.getX(), robotHard.getY(), checkSteps.getSymbol());
                        printer.printField(field.getField());
                        break;
                }
                if (!winner.findWinnersIn(field.getField(), checkSteps.numbersOfInputs()).equals("Game not finished")) {
                    break;
                }
            }
            System.out.println(winner.findWinnersIn(field.getField(), checkSteps.numbersOfInputs()));
        }
    }
}
