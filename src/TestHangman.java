import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestHangman {

    @Test
    public void testConstructor(){
        Hangman game = new Hangman();
        assertEquals(game.getErrorCounter(), 0);
        assertEquals(game.getGuessedLetters().length(), 0);
        assertTrue(Arrays.asList(Hangman.WORD_BANK).contains(game.getChosenWord()));
    }

    @Test
    public void testNewGame(){
        Hangman game = new Hangman();
        game.newGame();
        assertEquals(game.getErrorCounter(), 0);
        assertEquals(game.getGuessedLetters().length(), 0);
        assertTrue(Arrays.asList(Hangman.WORD_BANK).contains(game.getChosenWord()));
    }

    @Test
    public void testValidGuess(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        assertEquals(game.guess("t"), 1);
        assertTrue(game.getGuessedLetters().contains("T"));
        assertEquals(game.getErrorCounter(), 0);
        assertEquals(game.displayProcess(), "T _ _ T");
    }

    @Test
    public void testWrongGuess(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        assertEquals(game.guess("w"), 0);
        assertTrue(game.getGuessedLetters().contains("W"));
        assertEquals(game.getErrorCounter(), 1);
        assertEquals(game.displayProcess(), "_ _ _ _");
    }

    @Test
    public void testAlreadyGuess(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess("s");
        assertTrue(game.getGuessedLetters().contains("S"));
        assertEquals(game.guess("s"), 2);
        assertEquals(game.getErrorCounter(), 0);
        assertEquals(game.displayProcess(), "_ _ S _");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGuess1(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess("test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGuess2(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess("7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGuess3(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess(".");
    }

    @Test
    public void testComplete(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess("t");
        game.guess("e");
        game.guess("s");
        assertTrue(game.completenessCheck());
    }

    @Test
    public void testIncomplete(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        game.guess("e");
        game.guess("s");
        assertFalse(game.completenessCheck());
    }

    @Test
    public void testDisplayProcess(){
        Hangman game = new Hangman();
        game.setChosenWord("TEST");
        assertEquals(game.displayProcess(), "_ _ _ _");
        game.guess("t");
        assertEquals(game.displayProcess(), "T _ _ T");
        game.guess("e");
        assertEquals(game.displayProcess(), "T E _ T");
        game.guess("s");
        assertEquals(game.displayProcess(), "T E S T");
    }
}
