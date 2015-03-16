/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

package tetris.gui;

/**
 * Holds the possible controls for the game.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
public enum TetrisControlsEnum
{
  /**
   * The hold control.
   */
  Hold("Hold"),
  
  /**
   * The rotate clockwise control.
   */
  RotateCW("RotateCW"),
  
  /**
   * The rotate control.
   */
  Rotate("Rotate"),
  
  /**
   * The drop control.
   */
  Drop("Drop"),
  
  /**
   * The right control.
   */
  Right("Right"),
  
  /**
   * The left control.
   */
  Left("Left"),
  
  /**
   * The down control.
   */
  Down("Down");
  
  /**
   * The name of the control.
   */
  private final String my_control;
  
  /**
   * Enumeration for controls constructor.
   * @param the_control The name of the control.
   */
  private TetrisControlsEnum(final String the_control)
  {
    my_control = the_control;
  }
  
  /**
   * Returns the name of the control.
   * @return my_control
   */
  public String getName()
  {
    return my_control;
  }
}
