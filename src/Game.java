public class Game {

    private String answer;
    private String hits;
    private String misses;
    private static final int MAX_NUMBER_OF_MISSES = 7;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    public String getAnswer() {
        return answer;
    }

    private char normalizeLetter(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Sorry, Only Letters are allowed!");
        }
        letter = Character.toLowerCase(letter);
        if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed!");
        }
        return letter;
    }


    public boolean applyGuess(Character letter) {
        letter = normalizeLetter(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit) {
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '*';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries() {
        int numberOfMisses = misses.length();
        return MAX_NUMBER_OF_MISSES - numberOfMisses;
    }


}
