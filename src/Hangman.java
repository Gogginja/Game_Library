
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Hangman {

    //Bank of words the computer will choose from
    public static final String[] WORD_BANK = {"TEST"}; //TODO: fill with words the computer could pick

    //Random number generator used to select a word
    public static final Random RANDOM = new Random();

    //Number of errors allowed
    private final int NUM_ERRORS = 6;

    //Word the player will be guessing for
    private String chosenWord;

    //Characters in the word the player will be guessing for
    private static char[] chosenWordLetters;

    //Variable to keep track of the player's number of errors
    private int errorCounter;

    //Array of characters the user has guessed
    private ArrayList<String> guessedLetters = new ArrayList<String>();
    
    public Hangman(){
        errorCounter = 0;
        chosenWord = pickRandomWord();
        chosenWordLetters = new char[chosenWord.length()];
        for(int i=0; i < chosenWord.length(); i++){
            chosenWordLetters[i] = '_';
        }
    }

    public int getErrors(){
        return errorCounter;
    }

    public String getGuessedLetters(){
        return String.join(", ", guessedLetters);
    }

    public String getChosenWord(){
        return chosenWord;
    }

    private String pickRandomWord(){
        return WORD_BANK[RANDOM.nextInt(WORD_BANK.length)];
    }

    //Resets the counters from previous game, selects a new word, clears arrays
    public void newGame(){
        //Reset counters and arrays
        errorCounter = 0;
        guessedLetters.clear();
        //Pick a new word
        chosenWord = pickRandomWord();
        //Set up the blanks for chosen word
        chosenWordLetters = new char[chosenWord.length()];
        for(int i=0; i < chosenWord.length(); i++){
            chosenWordLetters[i] = '_';
        }
    }

    //Determines if a guessed letter is in the word, if not error is incremented
    public int guess(String g){
        g = g.toUpperCase();
        if(!guessedLetters.contains(g)){
            if(chosenWord.contains(g)){
                int i = chosenWord.indexOf(g);

                while(i >= 0){
                    chosenWordLetters[i] = g.charAt(0);
                    i = chosenWord.indexOf(g, i+1);
                }
                guessedLetters.add(g);
                return 1;
            }
            else {
                guessedLetters.add(g);
                errorCounter++;
                return 0;
            }
        }
        return 2;
    }

    //True if chosenWordLetters = chosenWord (completed array)
    public boolean completenessCheck(){
        return chosenWord.contentEquals(new String(chosenWordLetters));
    }

    //returns the state of the word we are guessing
    public String displayProcess() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chosenWordLetters.length; i++) {
            builder.append(chosenWordLetters[i]);

            if (i < chosenWordLetters.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public void startGame(){
        new HangmanFrame();
    }
}
