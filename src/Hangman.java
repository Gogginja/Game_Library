import java.*;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    //Bank of words the computer will choose from
    public static final String[] WORD_BANK = {}; //TODO: fill with words the computer could pick

    //Random number generator used to select a word
    public static final Random RANDOM = new Random();

    //Number of errors allowed
    private final int NUM_ERRORS = 6;

    //Word the player will be guessing for
    private String chosenWord;

    //Characters in the word the player will be guessing for
    private char[] chosenWordLetters;

    //Variable to keep track of the player's number of errors
    private int errorCounter;

    //Array of characters the user has guessed
    private ArrayList<String> guessedLetters;

    private String pickRandomWord(){
        return WORD_BANK[RANDOM.nextInt(WORD_BANK.length)];
    }

    private void newGame(){
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

    private void guess(String g){
        if(!guessedLetters.contains(g)){
            if(chosenWord.contains(g)){
                int i = chosenWord.indexOf(g);

                while(i >= 0){
                    chosenWordLetters[i] = g.charAt(0);
                    i = chosenWord.indexOf(g, i+1);
                }
            }
            else {
                errorCounter++;
            }
            guessedLetters.add(g);
        }
    }









}
