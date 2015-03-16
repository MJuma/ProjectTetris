/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 11, 2012
 */

package tetris.board;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import tetris.pieces.Tetrominos;

import static org.junit.Assert.assertEquals;

/**
 * Tests the tetris project game board.
 * @author Mohammad Juma
 * @version 11-12-2012
 */
public class BoardTest
{ 
  /**
   * A default board to be used in most tests.
   */
  private Board my_board;
  
  /**
   * A String representation of an empty board.
   */
  private String my_empty_board;
  
  /**
   * Creates the board and passes in the 30 Tetrominos chosen for the test.
   */
  @Before
  public void createBoard()
  {
    my_board = new Board();
    my_empty_board = my_board.toString();
    final Tetrominos[] tetrominos = new Tetrominos[] {Tetrominos.I, Tetrominos.I,
      Tetrominos.I, Tetrominos.I, Tetrominos.I, Tetrominos.I, Tetrominos.I, Tetrominos.I,
      Tetrominos.I, Tetrominos.I, Tetrominos.I, Tetrominos.I, Tetrominos.O, Tetrominos.L,
      Tetrominos.L, Tetrominos.L, Tetrominos.L, Tetrominos.I, Tetrominos.T, Tetrominos.Z,
      Tetrominos.Z, Tetrominos.Z, Tetrominos.T, Tetrominos.S, Tetrominos.S, Tetrominos.Z,
      Tetrominos.Z, Tetrominos.L, Tetrominos.J, Tetrominos.J, Tetrominos.L, Tetrominos.I,
      Tetrominos.I, Tetrominos.L, Tetrominos.J, Tetrominos.L, Tetrominos.J, Tetrominos.O,
      Tetrominos.I, Tetrominos.I};
    my_board.setTetrominos(tetrominos);
  }
  
  /**
   * Tests creating an empty game board.
   * This is done but creating a 2D array that would represent an 
   * empty board and checking it against an actual empty board.
   * This also checks toString and creating a board with a non default size.
   */
  @Test
  public void emptyBoard()
  {
    // First create the expected String the empty board should match.
    final int[][] expected_board = new int[8][7];
    final StringBuilder sb = new StringBuilder();
    for (int[] row: expected_board)
    {
      sb.append(Arrays.toString(row));
      sb.append('\n');
    }
    final String expected = sb.toString();

    // Now create the board itself with the non default size.
    final Board board = new Board(7, 8);
    final String actual = board.toString();

    assertEquals("Empty board is empty.", expected, actual);
  }
  
  /**
   * Simulates a Tetris game to test the board class.
   */
  @Test
  public void simulateGame()
  {
    phaseOne();
    // The board is expected to be cleared after phase one.
    assertEquals("Empty board after phase one.", my_empty_board, my_board.toString());
    phaseTwo();
    phaseThree();
    phaseFour();
    phaseFive();
    phaseSix();
    phaseSeven();
    // The board is expected to be cleared after phase seven.
    assertEquals("Empty board after phase seven.", my_empty_board, my_board.toString());
  }
  
  /**
   * Phase One Tests: Moving down, moving left, left bound,
   * clearing multiple lines, the I Tetromino, the step function
   * and the bottom bound of the board.
   */
  private void phaseOne()
  {
    for (int i = 0; i < 10; i++)
    {
      leftForever();
      for (int j = 0; j < i; j++)
      {
        my_board.moveRight();
      }
      stepForever();
    }
    my_board = new Board();
  }
  
  /**
   * Phase Two Tests: Moving down, moving left, moving right, rotating, 
   * the left bound, the right bound, the I Tetromino, the O Tetromino, 
   * clearing single lines, the step function and the bottom bound of 
   * the board.
   */
  private void phaseTwo()
  {
    for (int i = 0; i < 2; i++)
    {
      my_board.rotate();
      leftForever();
      for (int j = 0; j < i * 4; j++)
      {
        my_board.moveRight();
      }
      stepForever();
    }
    rightForever();
    stepForever();
  }
  
  /**
   * Phase Three Tests: Moving down, moving left, moving right, rotating,
   * rotating clockwise, the left bound, the right bound, the L Tetromino,
   * the I Tetromino, the T Tetromino, clearing single lines and the 
   * step function.
   */
  private void phaseThree()
  {
    for (int i = 0; i < 4; i++)
    {
      if (i % 2 == 0)
      {
        my_board.rotateCW();
      }
      else
      {
        my_board.rotate();
      }
      rightForever();
      
      if (i == 1 || i == 2)
      {
        for (int k = 0; k < i + 2; k++)
        {
          my_board.moveLeft();
        }
      }
      if (i == 3)
      {
        leftForever();
      }
      stepForever();
    }
    leftForever();
    stepForever();
    my_board.rotateCW();
    leftForever();
    my_board.moveRight();
    stepForever();
  }
  
  /**
   * Phase Four Tests: Moving down, moving left, moving right, rotating,
   * the left bound, the right bound, the Z Tetromino, the T Tetromino, 
   * clearing multiple lines and the step function.
   */
  private void phaseFour()
  {
    for (int i = 0; i < 3; i++)
    {
      leftForever();
      for (int j = 0; j < 2 * i + 2; j++)
      {
        my_board.moveRight();
      }
      stepForever();
    }
    rightForever();
    my_board.rotate();
    stepForever();
  }
  
  /**
   * Phase Five Tests: Moving down, moving left, moving right,
   * the left bound, the right bound, the Z Tetromino, the S Tetromino, 
   * clearing single lines and the step function. 
   * of the board.
   */
  private void phaseFive()
  {
    for (int i = 0; i < 2; i++)
    {
      rightForever();
      for (int j = 0; j < i * 2; j++)
      {
        my_board.moveLeft();
      }
      stepForever();
    }
    for (int i = 0; i < 2; i++)
    {
      leftForever();
      for (int j = 0; j < i * 2; j++)
      {
        my_board.moveRight();
      }
      stepForever();
    }
  }
  
  /**
   * Phase Six Tests: Moving down, moving left, moving right, rotating,
   * rotating clockwise, the left bound, the right bound, the I Tetromino,
   * the J Tetromino, the L Tetromino, clearing multiple lines, clearing
   * non adjacent lines, the step function and the bottom bound of the board.
   */
  private void phaseSix()
  {
    my_board.rotate();
    rightForever();
    stepForever();
    my_board.rotateCW();
    rightForever();
    my_board.moveLeft();
    stepForever();
    
    my_board.rotateCW();
    leftForever();
    stepForever();
    my_board.rotate();
    leftForever();
    my_board.moveRight();
    stepForever();
    
    stepForever();
    my_board.moveRight();
    stepForever();
  }
  
  /**
   * Phase Seven Tests: Moving down, moving left, moving right, rotating,
   * rotating clockwise, the left bound, the right bound, the O Tetromino,
   * the J Tetromino, the L Tetromino, clearing multiple single lines, 
   * the step function and the bottom bound of the board.
   */
  private void phaseSeven()
  {
    my_board.rotate();
    rightForever();
    stepForever();
    my_board.rotateCW();
    leftForever();
    stepForever();
    
    my_board.rotateCW();
    rightForever();
    my_board.moveLeft();
    stepForever();
    my_board.rotate();
    leftForever();
    my_board.moveRight();
    stepForever();
    
    my_board.moveRight();
    stepForever();
    my_board.rotate();
    rightForever();
    stepForever();
    my_board.rotate();
    leftForever();
    stepForever();
    my_board = new Board();
  }


  /**
   * Steps the board until it can no longer 
   * move the Tetromino down any more.
   */
  private void stepForever()
  {
    while (true)
    {
      if (!my_board.step())
      {
        break;
      }
    }
  }
  
  /**
   * Moves the Tetromino to the left until 
   * it hits the left bound of the board.
   */
  private void leftForever()
  {
    while (true)
    {
      if (!my_board.moveLeft())
      {
        break;
      }
    }
  }
  
  /**
   * Moves the Tetromino to the right until 
   * it hits the right bound of the board.
   */
  private void rightForever()
  {
    while (true)
    {
      if (!my_board.moveRight())
      {
        break;
      }
    }
  }
}