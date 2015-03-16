/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tetris.gui.TetrisGui;

/**
 * Runs the Tetris game by instantiating and starting the TetrisGUI.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
public final class TetrisMain
{
  /**
   * Private constructor, to prevent instantiation of this class.
   */
  private TetrisMain()
  {
    // do nothing.
  }

  /**
   * The main method, invokes the PowerPaint GUI. Command line
   * arguments are ignored.
   * 
   * @param the_args Command line arguments.
   */
  public static void main(final String[] the_args)
  {

    try
    {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e)
    {
      assert false;
    }
    final TetrisGui gui = new TetrisGui();
    gui.start();
  }
}
