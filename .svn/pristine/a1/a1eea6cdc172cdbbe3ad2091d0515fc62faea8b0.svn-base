/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

package tetris.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import tetris.board.Board;
import tetris.pieces.Tetromino;

/**
 * JPanel class for drawing the small Tetrominos in 
 * hold, next and sequence panels.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
@SuppressWarnings("serial")
public class TetrisSinglePanel extends JPanel implements Observer
{
  /**
   * The default width of the game panel.
   */
  private static final int DEFAULT_WIDTH = 100;

  /**
   * The default height of the game panel.
   */
  private static final int DEFAULT_HEIGHT = 100;

  /**
   * The size of each Tetromino block.
   */
  private static final int DEFAULT_BLOCK_SIZE = 25;
  
  /**
   * The background color of the board.
   */
  private static final Color BACKGROUND_COLOR = new Color(105, 105, 105);
  
  /**
   * The color of the grid lines.
   */
  private static final Color GRID_COLOR = new Color(139, 137, 137);

  /**
   * The Tetromino currently being drawn.
   */
  private Tetromino my_tetromino;
  
  /**
   * The block size.
   */
  private int my_block_size;
  
  /**
   * The block in the sequence this panel will paint.
   */
  private final int my_block_number;
  
  /**
   * The game board.
   */
  private final Board my_board;
  
  /**
   * Creates a new JPanel for holding the Tetromino.
   * @param the_board The game board.
   * @param the_block_number The block in the sequence this panel will paint.
   */
  public TetrisSinglePanel(final Board the_board, final int the_block_number)
  {
    super();
    setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    setBackground(BACKGROUND_COLOR);
    my_block_size = DEFAULT_BLOCK_SIZE;
    my_block_number = the_block_number;
    my_board = the_board;
    my_board.addObserver(this);
  }
  
  /**
   * Creates a new JPanel for holding the Tetromino.
   * @param the_board The game board.
   */
  public TetrisSinglePanel(final Board the_board)
  {
    super();
    setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    setBackground(BACKGROUND_COLOR);
    my_block_size = DEFAULT_BLOCK_SIZE;
    my_block_number = -1;
    my_board = the_board;
    my_board.addObserver(this);
  }

  /**
   * Paints the panel with the Tetromino.
   * 
   * @param the_graphics The graphics context to use for painting.
   */
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                         RenderingHints.VALUE_ANTIALIAS_ON);

    
    g2d.setColor(GRID_COLOR);
    for (int m = 0; m < (getWidth() / my_block_size); m++)
    {
      for (int n = 0; n < (getHeight() / my_block_size); n++)
      {
        g2d.drawRect(m * my_block_size, n * my_block_size, my_block_size, my_block_size);
      }
    }
    if (my_tetromino != null)
    {
      for (int m = 0; m < my_tetromino.localPoints().length; m++)
      {
        g2d.setColor(my_tetromino.getColor());
        g2d.fill3DRect(my_tetromino.localPoints()[m].x * my_block_size,
                     my_tetromino.localPoints()[m].y * my_block_size,
                     my_block_size, my_block_size, true);
      }
    }
    if (my_block_number > 0)
    {
      g2d.setColor(Color.WHITE);
      g2d.drawRect(0, 0, getWidth(), getHeight());
    }
  }
  
  /**
   * Sets the block size.
   * @param the_block_size The new block size.
   */
  public void setBlockSize(final int the_block_size)
  {
    my_block_size = the_block_size;
  }
  
  /**
   * The Tetromino to place in the panel.
   * @param the_tetromino The Tetromino to place in the panel.
   */
  public void setTetromino(final Tetromino the_tetromino)
  {
    my_tetromino = the_tetromino;
    repaint();
  }
  

  /**
   * The update method for the Observer interface.
   * 
   * @param the_obj The observable that called us.
   * @param the_arg The argument it passed us.
   */
  public void update(final Observable the_obj, final Object the_arg)
  { 
    if (my_block_number == -1 && the_arg == TetrisObserverEvents.HoldTetromino)
    {
      setTetromino(my_board.getHeldTetromino());
    }
    else if (my_block_number >= 0 && the_arg == TetrisObserverEvents.NewSequence)
    {
      setTetromino(my_board.getSequence().get(my_block_number));
    }
  }
}
