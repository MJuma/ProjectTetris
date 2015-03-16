/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * October 26, 2012
 */

package tetris.pieces;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import tetris.utilities.Copy;

/**
 * Tetromino Enumeration Class.
 * 
 * @author Mohammad Juma
 * @version 10-26-2012
 */
public enum Tetrominos
{
  /**
   * Matrix representation of the I tetromino.
   */
  I(new int[][] {{0, 1, 0, 0}, {0, 2, 0, 0}, {0, 3, 0, 0}, {0, 4, 0, 0}},
    new Color(102, 205, 170)),
  
  /**
   * Matrix representation of the L tetromino.
   */
  L(new int[][] {{0, 1, 0}, {0, 2, 0}, {0, 3, 4}}, new Color(252, 175, 62)),
  
  /**
   * Matrix representation of the J tetromino.
   */
  J(new int[][] {{0, 1, 0}, {0, 2, 0}, {4, 3, 0}}, new Color(65, 105, 225)),
  
  /**
   * Matrix representation of the S tetromino.
   */
  S(new int[][] {{0, 2, 1}, {4, 3, 0}, {0, 0, 0}}, new Color(138, 226, 52)),
  
  /**
   * Matrix representation of the Z tetromino.
   */
  Z(new int[][] {{1, 2, 0}, {0, 3, 4}, {0, 0, 0}}, new Color(174, 34, 34)),
  
  /**
   * Matrix representation of the T tetromino.
   */
  T(new int[][] {{0, 0, 0}, {0, 1, 0}, {2, 3, 4}}, new Color(123, 104, 238)),
  
  /**
   * Matrix representation of the O tetromino.
   */
  O(new int[][] {{1, 2}, {3, 4}}, new Color(252, 233, 79));
  
  /**
   * List of possible Tetrominos for randomly choosing a Tetromino.
   */
  private static final List<Tetrominos> VALUES = 
      Collections.unmodifiableList(Arrays.asList(values()));
  
  /**
   * Size of Tetrominos List.
   */
  private static final int SIZE = VALUES.size();
  
  /**
   * Random object for choosing a random Tetromino.
   */
  private static final Random RANDOM = new Random();
  
  /**
   * Copies 2D arrays.
   */
  private final Copy my_copy = new Copy();
  
  /**
   * Tetrominos are all type 2d array.
   */
  private int[][] my_tetromino;
  
  /**
   * The Tetrominos Color.
   */
  private Color my_color;
  
  /**
   * Tetromino Enumeration Piece Constructor.
   * @param the_tetromino Tetromino desired.
   * @param the_color The color of the Tetromino.
   */
  private Tetrominos(final int[][] the_tetromino, final Color the_color)
  {
    my_tetromino = my_copy.copyArray(the_tetromino);
    my_color = the_color;
  }
  
  /**
   * Returns a 2d matrix representation of a tetromino.
   * @return my_tetromino
   */
  public int[][] getTetromino()
  {
    return my_copy.copyArray(my_tetromino);
  }
  
  /**
   * Returns the color of the Tetromino.
   * @return my_color The Tetrominos Color.
   */
  public Color getColor()
  {
    return my_color;
  }
  
  /**
   * Returns a random Tetromino.
   * @return Tetromino
   */
  public static Tetrominos random()  
  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
}