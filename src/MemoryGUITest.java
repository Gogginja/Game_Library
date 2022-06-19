import org.junit.After;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class MemoryGUITest extends MemoryGUI {

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testActionPerformed() {
  }


  @Test
  public void testDoTurn() {

  }

  /***************************************************
   * Tests checkCards method when they are a match
   **************************************************/
  @Test
  public void testCheckCards() {
    MemoryGUI memory = new MemoryGUI();
    b1.setSelectedIcon(new ImageIcon("michael.png"));
    b2.setSelectedIcon(new ImageIcon("michael.png"));
    assertTrue("Match", b1.getSelectedIcon().toString().equals(b2.getSelectedIcon().toString()));


  }

  /*******************************************************
   * Tests checkCards method when they are mismatched
   ******************************************************/
  @Test
  public void testCheckCards2() {
    MemoryGUI memory = new MemoryGUI();
    b1.setSelectedIcon(new ImageIcon("pam.png"));
    b2.setSelectedIcon(new ImageIcon("jim.png"));
  }

  /************************************************
   * Tests isGameWon method when game is not over
   ************************************************/
  @Test
  public void testIsGameWon() {
    MemoryGUI memory = new MemoryGUI();
    matches = 3;
    assertFalse("Game is NOT Won, Matches = 3", isGameWon());
  }

  /************************************************
   * Tests isGameWon method when game is over
   ************************************************/
  @Test
  public void testIsGameWon2() {
    matches = 8;
    assertTrue("Game is Won, Matches = 8", isGameWon());
  }

  @Test
  public void testSetPlayagain() {
  }

  @Test
  public void testMain() {
  }
}