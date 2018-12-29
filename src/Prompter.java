import java.util.Scanner;

public class Prompter {

    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            String guessInput = scanner.nextLine();
//            if (guessInput.isEmpty()) {
//                System.out.println("Please enter a letter!");
//                return isHit;
//            }
//            Character guess = guessInput.charAt(0);
            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s Please Try Again: ", iae.getMessage());
            }
        } while (!isAcceptable);
        return isHit;
    }

    void displayProgress() {
        System.out.printf("You have %d tries %n", game.getRemainingTries());
        System.out.printf("Guess a letter:  %s %n", game.getCurrentProgress());
    }
}
