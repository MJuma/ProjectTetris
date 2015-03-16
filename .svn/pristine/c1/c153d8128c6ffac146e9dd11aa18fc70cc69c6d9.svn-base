/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

package tetris.gui;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds the controls for the game.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
public class TetrisControls
{
  /**
   * HashMap of key codes that lead to the corresponding control key.
   */
  private final Map<Integer, TetrisControlsEnum> my_keys = 
      new HashMap<Integer, TetrisControlsEnum>(); 
    
  /**
   * Creates the initial default controls for the game.
   */
  public TetrisControls()
  {
    intializeKeys();
  }
  
  /**
   * Initializes the keys to their defaults.
   */
  private void intializeKeys()
  {
    my_keys.put(KeyEvent.VK_LEFT, TetrisControlsEnum.Left);
    my_keys.put(KeyEvent.VK_RIGHT, TetrisControlsEnum.Right);
    my_keys.put(KeyEvent.VK_DOWN, TetrisControlsEnum.Down);
    my_keys.put(KeyEvent.VK_SPACE, TetrisControlsEnum.Drop);
    my_keys.put(KeyEvent.VK_UP, TetrisControlsEnum.Rotate);
    my_keys.put(0, TetrisControlsEnum.RotateCW);
    my_keys.put(KeyEvent.VK_SHIFT, TetrisControlsEnum.Hold);
  }
  
  /**
   * Returns the game control key for the entered key.
   * @param the_key The pressed key.
   * @return The corresponding game control key.
   */
  public TetrisControlsEnum getKey(final int the_key)
  {
    return my_keys.get(the_key);
  }
  
  /**
   * Sets the game control key based on the entered key.
   * @param the_old_key The old key associated with the game control key.
   * @param the_new_key The new key.
   */
  public void setKey(final int the_old_key, final int the_new_key)
  {
    my_keys.put(the_new_key, my_keys.get(the_old_key));
    my_keys.remove(the_old_key);
  }
  
  /**
   * Returns the set of keys for the game.
   * @return The set of keys for the game.
   */
  public Object[] getKeyCodes()
  {
    return my_keys.keySet().toArray();
  }
  
  /**
   * Checks to see if the pressed key exists.
   * @param the_key_code The pressed key.
   * @return True if it exists.
   */
  public boolean keyExists(final int the_key_code)
  {
    return my_keys.containsKey(the_key_code);
  }
  
  /**
   * Returns the keys to their defaults.
   */
  public void setDefaults()
  {
    my_keys.clear();
    intializeKeys();
  }
}
