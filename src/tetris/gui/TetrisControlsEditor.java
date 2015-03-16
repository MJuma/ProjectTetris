/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * November 22, 2012
 */

package tetris.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JPanel class for the game controls editing.
 * 
 * @author Mohammad Juma
 * @version 11-22-2012
 */
@SuppressWarnings("serial")
public class TetrisControlsEditor extends JFrame
{
  /**
   * The default width of the window.
   */
  private static final int DEFUALT_WIDTH = 250;
      
  /**
   * The default height of the window.
   */
  private static final int DEFAULT_HEIGHT = 300;
  
  /**
   * The game controls to be edited.
   */
  private final TetrisControls my_keys; 
  
  /**
   * The list of buttons associated with the keys.
   */
  private final List<JButton> my_key_buttons = new ArrayList<JButton>();
  
  /**
   * The name of each control for the game.
   */
  private final List<JLabel> my_key_labels = new ArrayList<JLabel>();
  
  /**
   * Creates the frame for the Tetris Controls Editor.
   * @param the_keys The game controls to be edited.
   * @param the_frame The main frame.
   */
  public TetrisControlsEditor(final TetrisControls the_keys, final JFrame the_frame)
  {
    super("Edit Controls");
    setSize(DEFUALT_WIDTH, DEFAULT_HEIGHT);
    my_keys = the_keys;
    add(textPanel(), BorderLayout.NORTH);
    add(controlsEditor(), BorderLayout.CENTER);
    setResizable(false);
    setLocation(the_frame.getLocation());
    setVisible(false);
  }
  
  /**
   * Creates a panel for displayed the title and the
   * description of the frame.
   * @return panel
   */
  private JPanel textPanel()
  {
    final JPanel panel = new JPanel();
    final JLabel title = new JLabel("Game Controls");
    final JLabel description = new JLabel("Click the button to change the key.");
    
    panel.add(title);
    panel.add(description);
    return panel;
    
  }

  /**
   * Panel for editing controls.
   * @return panel The panel.
   */
  private JPanel controlsEditor()
  {
    final JPanel panel = new JPanel(new GridBagLayout());
    final GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(2, 2, 2, 2);
    getKeys();
    for (int i = 0; i < my_key_buttons.size(); i++)
    {
      addComponents(my_key_labels.get(i), my_key_buttons.get(i), panel, gbc);
    }
    return panel;
  }
  
  /**
   * Creates a list of buttons and labels corresponding to the game controls.
   */
  private void getKeys()
  {
    for (int i = 0; i < my_key_buttons.size(); i++)
    {
      my_key_buttons.remove(i);
      my_key_labels.remove(i);
    }
    for (int i = 0; i < my_keys.getKeyCodes().length; i++)
    {
      final int key_code = (int) my_keys.getKeyCodes()[i];
      final int j = i;
      if (key_code == 0)
      {
        my_key_buttons.add(new JButton("Undefined"));
      }
      else
      {
        my_key_buttons.add(new JButton(KeyEvent.getKeyText(key_code)));
      }
      my_key_buttons.get(i).addActionListener(new ActionListener()
      {
        public void actionPerformed(final ActionEvent the_event)
        {
          my_key_buttons.get(j).addKeyListener(new KeyAdapter()
          {
            public void keyPressed(final KeyEvent the_event)
            {      
              my_keys.setKey(key_code, the_event.getKeyCode());
              my_key_buttons.get(j).setText(KeyEvent.getKeyText(the_event.getKeyCode()));
              my_key_buttons.get(j).removeKeyListener(this);
            }
          });
        }
      });
      my_key_labels.add(new JLabel(my_keys.getKey((int) my_keys.getKeyCodes()[i]).getName()));
    }
  }

  /**
   * Adds components to the game controls panel.
   * @param the_label The control name;
   * @param the_button The controls edit button.
   * @param the_panel The panel the controls are in.
   * @param the_gbc The grid bag constant.
   */
  private void addComponents(final JLabel the_label, final JButton the_button,
                             final JPanel the_panel, final GridBagConstraints the_gbc)
  {
    the_gbc.anchor = GridBagConstraints.EAST;
    the_gbc.gridwidth = GridBagConstraints.RELATIVE;
    the_panel.add(the_label, the_gbc);
    the_gbc.anchor = GridBagConstraints.WEST;
    the_gbc.gridwidth = GridBagConstraints.REMAINDER;
    the_panel.add(the_button, the_gbc);
  }
}
