/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

package tetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * The menu bar for the TetrisGUI.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
public class TetrisMenu
{
  /**
   * The frame used to allow the player to edit the controls.
   */
  private final TetrisControlsEditor my_controls_editor;
  
  /**
   * The games menu bar.
   */
  private final JMenuBar my_menu_bar;
  
  /**
   * The main frame.
   */
  private final TetrisGui my_frame;
  
  /**
   * The menu actions for
   * controlling the state of the game.
   */
  private final TetrisActions my_actions;

  /**
   * Creates a new JMenuBar.
   * @param the_keys The game controls.
   * @param the_frame The main frame.
   * @param the_actions The menu actions for
   * controlling the state of the game.
   */
  public TetrisMenu(final TetrisGui the_frame,
                    final TetrisControls the_keys,
                    final TetrisActions the_actions)
  {
    my_menu_bar = new JMenuBar();
    my_frame = the_frame;
    my_actions = the_actions;
    createMenuBar();
    my_controls_editor = new TetrisControlsEditor(the_keys, the_frame);
  }

  /**
   * Returns a created menu bar.
   * @return my_menu_bar The created menu bar.
   */
  public JMenuBar getMenuBar()
  {
    return my_menu_bar;
  }

  /**
   * Creates the menu bar.
   */
  private void createMenuBar()
  {
    my_menu_bar.add(tetrisMenu());
    my_menu_bar.add(optionsMenu());
    my_menu_bar.add(helpMenu());
  }

  /**
   * Creates the file menu.
   * @return file_menu The file menu.
   */
  private JMenu tetrisMenu()
  {
    final JMenu tetris_menu = new JMenu("Tetris");
    
    tetris_menu.add(my_actions.getNewGame());
    tetris_menu.add(my_actions.getToggleGame());
    tetris_menu.add(my_actions.getEndGame());
    
    final JMenuItem quit = new JMenuItem("Quit");
    quit.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_frame.dispose();
      }
    });
    quit.setMnemonic(KeyEvent.VK_Q);
    tetris_menu.add(quit);

    return tetris_menu;
  }

  /**
   * Creates the options menu.
   * @return options_menu The file menu.
   */
  private JMenu optionsMenu()
  {
    final JMenu options_menu = new JMenu("Options");
    
    final JMenu size_menu = new JMenu("Screen Size");
    for (final TetrisScreenResolution size: TetrisScreenResolution.values())
    {
      final JMenuItem menu_item = new JMenuItem(size.getName());
      menu_item.addActionListener(new ActionListener()
      {
        public void actionPerformed(final ActionEvent the_event)
        {
          my_frame.screenSize(size.getWidth(), size.getHeight(), size.getBlockSize());
        }
      });
      size_menu.add(menu_item);
    }
    size_menu.setMnemonic(KeyEvent.VK_S);
    options_menu.add(size_menu);
    
    final JMenuItem edit_controls = new JMenuItem("Edit Controls");
    edit_controls.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_controls_editor.setVisible(true);
      }
    });
    edit_controls.setMnemonic(KeyEvent.VK_C);
    options_menu.add(edit_controls);

    return options_menu;
  }

  /**
   * Creates the help menu.
   * @return help_menu The file menu.
   */
  private JMenu helpMenu()
  {
    final JMenu help_menu = new JMenu("Help");
    
    final String how_to_play = "Using the arrow keys," +
        " you can adjust where and how the Tetriminos fall.\n" +
        "By pressing the LEFT and RIGHT Arrow keys, you can slide" +
        " the falling Tetrimino from side to side.\nYou can’t slide a" +
        " Tetrimino past the edge of the Matrix.\nBy pressing the UP" +
        " Arrow key, you can rotate the Tetrimino 90 degrees clockwise.\n" +
        "You can move the Tetriminos even after they Lock Down at the" +
        " bottom of the Matrix briefly.\nThe Tetrimino will Lock Down as" +
        " soon as you stop trying to move it.\nAt that point, the next" +
        " Tetrimino will begin to fall.";
    final JMenuItem help = new JMenuItem("How To Play");
    help.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        JOptionPane.showMessageDialog(my_frame, how_to_play);
      }
    });
    help.setMnemonic(KeyEvent.VK_H);
    help_menu.add(help);
    
    final JMenuItem about = new JMenuItem("About");
    about.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        JOptionPane.showMessageDialog(my_frame, "TCSS 305A\nTetris Project");
      }
    });
    about.setMnemonic(KeyEvent.VK_A);
    help_menu.add(about);

    return help_menu;
  }
}
