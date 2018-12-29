public class Hangman {

    public static void main(String[] args) {
        Game game = new Game("Gregorio");
       //o System.out.printf("Player one is: %s %n", game.getAnswer());
        Prompter prompter = new Prompter(game);
        prompter.displayProgress();
        while (game.getRemainingTries() > 0) {
            boolean guess = prompter.promptForGuess();
            if (guess) {
                System.out.println("It's a Hit!");
            } else {
                System.out.println("Oops it's a miss!");
            }
            prompter.displayProgress();
        }
    }
}
