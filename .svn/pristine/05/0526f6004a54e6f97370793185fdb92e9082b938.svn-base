/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * October 26, 2012
 */

package tetris.pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

import tetris.utilities.Copy;

/**
 * Parent class for all Tetrominos.
 * @author Mohammad Juma
 * @version 10-26-2012
 */
public class Tetromino implements ImmutablePiece
{
  /**
   * Number of blocks in a tetromino.
   */
  private static final int NUMBER_OF_BLOCKS = 4;

  /**
   * All tetromino matrices are n x n matrices with equals rows and columns.
   */
  private final int my_rows_and_columns;

  /**
   * Matrix representation of the tetromino using 1's and 0's.
   */
  private final int[][] my_matrix;

  /**
   * The tetromino's current x position.
   */
  private final int my_x;

  /**
   * The tetromino's current y position.
   */
  private final int my_y;
  
  /**
   * The color of the Tetromino.
   */
  private final Color my_color;
  
  /**
   * Copies 2D arrays.
   */
  private final Copy my_copy = new Copy();

  /**
   * Constructs a new tetromino.
   * @param the_x The initial x position
   * @param the_y The initial y position
   * @param the_matrix Initial tetromino matrix representation
   * @param the_color The color of the Tetromino.
   */
  public Tetromino(final int the_x, final int the_y,
                   final int[][] the_matrix, final Color the_color)
  {
    my_x = the_x;
    my_y = the_y;
    my_rows_and_columns = the_matrix.length;
    my_matrix = my_copy.copyArray(the_matrix);
    my_color = the_color;
  }

  /**
   * Finds the coordinates of the blocks in the Tetromino 
   * relative to the Boards coordinate system.
   * @return block_points
   */
  public Point[] points()
  {
    final Point[] block_points = new Point[NUMBER_OF_BLOCKS];
    int position = 0;
    for (int r = 0; r < my_rows_and_columns; r++)
    {
      for (int c = 0; c < my_rows_and_columns; c++)
      {
        if (my_matrix[r][c] > 0)
        {
          block_points[position] = new Point(c + my_x, r + my_y);
          position++;
        }
      }
    }
    return block_points;
  }
  
  /**
   * Finds the coordinates of the blocks in the Tetromino 
   * relative to the Tetrominos coordinate system.
   * @return block_points
   */
  public Point[] localPoints()
  {
    final Point[] block_points = new Point[NUMBER_OF_BLOCKS];
    int position = 0;
    for (int r = 0; r < my_rows_and_columns; r++)
    {
      for (int c = 0; c < my_rows_and_columns; c++)
      {
        if (my_matrix[r][c] > 0)
        {
          block_points[position] = new Point(c, r);
          position++;
        }
      }
    }
    return block_points;
  }
  
  /**
   * Returns the Tetrominos color.
   * @return my_color The Tetrominos color.
   */
  public Color getColor()
  {
    return my_color;
  }

  /** 
   * Moves this tetromino one space to the left. 
   * @return An ImmutablePiece moved one space to the left.
   */
  public ImmutablePiece moveLeft()
  {
    return (ImmutablePiece) new Tetromino(my_x - 1, my_y,
                                          my_copy.copyArray(my_matrix), my_color);
  }

  /** 
   * Moves this tetromino one space to the right. 
   * @return An ImmutablePiece moved one space to the right.
   */
  public ImmutablePiece moveRight()
  {
    return (ImmutablePiece) new Tetromino(my_x + 1, my_y,
                                          my_copy.copyArray(my_matrix), my_color);
  }

  /** 
   * Moves this tetromino one space down. 
   * @return An ImmutablePiece moved one space down.
   */
  public ImmutablePiece moveDown()
  {
    return (ImmutablePiece) new Tetromino(my_x, my_y + 1,
                                          my_copy.copyArray(my_matrix), my_color);
  }

  /** 
   * Rotates this tetromino one quarter turn counter-clockwise.
   * @return An ImmutablePiece rotated one quarter turn counter-clockwise
   */
  public ImmutablePiece rotate()
  {
    final int[][] rotated_matrix = new int[my_rows_and_columns][my_rows_and_columns];
    int row = 0;
    int col = my_rows_and_columns - 1;

    for (int r = 0; r < my_rows_and_columns; r++)
    {
      for (int c = 0; c < my_rows_and_columns; c++)
      {
        rotated_matrix[r][c] = my_matrix[row++][col];
      }
      row = 0;
      col--;
    }
    return (ImmutablePiece) new Tetromino(my_x, my_y, rotated_matrix, my_color);
  }

  /** 
   * Rotates this tetromino one quarter turn clockwise.
   * @return An ImmutablePiece rotated one quarter turn clockwise
   */
  public ImmutablePiece rotateCW()
  {
    final int[][] rotated_matrix = new int[my_rows_and_columns][my_rows_and_columns];

    for (int m = 0; m < my_rows_and_columns; m++)
    {
      for (int n = 0; n < my_rows_and_columns; n++)
      {
        rotated_matrix[n][my_rows_and_columns - 1 - m] = my_matrix[m][n];
      }
    }
    return (ImmutablePiece) new Tetromino(my_x, my_y, rotated_matrix, my_color);
  }

  /**
   * @return the x coordinate of this tetromino.
   */
  public int x()
  {
    return my_x;
  }

  /**
   * @return the y coordinate of this tetromino.
   */
  public int y()
  {
    return my_y;
  }
  
  /**
   * Sets the x and y coordinates of the piece.
   * @param the_x The new X coordinate.
   * @param the_y The new Y coordinate.
   * @return A new Tetromino with new X and Y coordinates.
   */
  public ImmutablePiece setPosition(final int the_x, final int the_y)
  {
    return (ImmutablePiece) new Tetromino(the_x, the_y,
                                          my_copy.copyArray(my_matrix), my_color);
  }

  /**
   * Returns a string representation of the tetromino.
   * @return sb.toString()
   */
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();

    for (int[] row: my_matrix)
    {
      sb.append(Arrays.toString(row));
      sb.append('\n');
    }
    return sb.toString();
  }
}