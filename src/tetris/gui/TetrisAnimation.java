/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * December 06, 2012
 */

package tetris.gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.LayerUI;

/**
 * The animation class that uses a JLayer to paint over the main JFrame.
 * 
 * @author Mohammad Juma
 * @author Oracle
 * @version 12-06-2012
 */
@SuppressWarnings("serial")
public class TetrisAnimation extends LayerUI<JPanel> implements ActionListener
{
  /**
   * Degrees in a circle.
   */
  private static final int DEGREES_IN_CIRCLE = 360;
  
  /**
   * The number of rotations the indicator will perform.
   */
  private static final int ROTATIONS = 12;
  
  /**
   * The amount to divide the arc length by.
   */
  private static final int ARC_DIVIDER = 5;
  
  /**
   * The amount to increase the angle.
   */
  private static final int ANGLE_INCREASE = 3; 
  
  /**
   * The number of frame per second to update the animation.
   */
  private static final int FPS = 24;
  
  /**
   * The length of the animation in milliseconds.
   */
  private static final int ANIMATION_LENGTH = 2000;
  
  /**
   * Ticks to update the animation and repaint it.
   */
  private static final String TICK = "tick";
  
  /**
   * The fade limit for the fading animation.
   */
  private static final int FADE_LIMIT = 15;
  
  /**
   * Boolean for holding the state of the timer.
   */
  private boolean my_is_running;
  
  /**
   * Boolean for holding the state of the component fading.
   */
  private boolean my_is_fading_out;
  
  /**
   * The animation timer.
   */
  private Timer my_timer;

  /**
   * The angle for the spinners in the animation.
   */
  private int my_angle;
  
  /**
   * The fade count for the fading animation.
   */
  private int my_fade_count;
  
  /**
   * Timer for stopping the animation.
   */
  private final Timer my_stop_animation_timer;
  
  /**
   * Constructs a new animation JLayer class.
   * @param the_game_panel Panel used for drawing the board and Tetrominos.
   */
  public TetrisAnimation(final TetrisPanel the_game_panel)
  {
    super();
    my_stop_animation_timer = new Timer(ANIMATION_LENGTH, new ActionListener() 
    {
      public void actionPerformed(final ActionEvent the_event) 
      {
        stop();
        the_game_panel.gameToggle();
      }
    });
    my_stop_animation_timer.setRepeats(false);
  }

  /**
   * Paints the animation.
   * @param the_graphics What to paint.
   * @param the_component Where to paint it.
   */
  public void paint(final Graphics the_graphics, final JComponent the_component) 
  {
    final int width = the_component.getWidth();
    final int height = the_component.getHeight();
    super.paint(the_graphics, the_component);

    if (!my_is_running)
    {
      return;
    }

    final Graphics2D g2d = (Graphics2D) the_graphics.create();

    final float fade = (float) my_fade_count / (float) FADE_LIMIT;
    grayOutScreen(g2d, width, height, fade);    
    
    showIndicator(g2d, width, height, fade);

    g2d.dispose();
  }
  
  /**
   * Grays out the screen.
   * @param the_g2d The graphics to paint with.
   * @param the_width The width of the component.
   * @param the_height The height of the component.
   * @param the_fade The amount to fade.
   */
  private void grayOutScreen(final Graphics2D the_g2d, final int the_width,
                             final int the_height, final float the_fade)
  {
    final Composite composite = the_g2d.getComposite();
    the_g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, the_fade / 2f));
    the_g2d.fillRect(0, 0, the_width, the_height);
    the_g2d.setComposite(composite);
  }
  
  /**
   * Displays the wait indicator.   
   * @author Oracle
   * @param the_g2d The graphics to paint with.
   * @param the_width The width of the component.
   * @param the_height The height of the component.
   * @param the_fade The amount to fade.
   */
  private void showIndicator(final Graphics2D the_g2d, final int the_width,
                             final int the_height, final float the_fade)
  {
    final int arc_length = Math.min(the_width, the_height) / ARC_DIVIDER;
    final int center_x = the_width / 2;
    final int center_y = the_height / 2;
    the_g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    the_g2d.setStroke(
        new BasicStroke(arc_length / (ARC_DIVIDER - 1),
                        BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    the_g2d.setPaint(Color.white);
    the_g2d.rotate(Math.PI * my_angle / (DEGREES_IN_CIRCLE / 2), center_x, center_y);
    for (int i = 0; i < ROTATIONS; i++) 
    {
      final float scale = ((ROTATIONS - 1) - (float) i) / (ROTATIONS - 1);
      the_g2d.drawLine(center_x + arc_length, center_y, center_x + arc_length * 2, center_y);
      the_g2d.rotate(-Math.PI / (ROTATIONS / 2), center_x, center_y);
      the_g2d.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, scale * the_fade));
    }
  }

  /**
   * Performs the fading and the wait indicator.
   * @param the_event The event that happened.
   */
  public void actionPerformed(final ActionEvent the_event) 
  {
    if (my_is_running) 
    {
      firePropertyChange(TICK, 0, 1);
      my_angle += ANGLE_INCREASE;
      if (my_angle >= DEGREES_IN_CIRCLE) 
      {
        my_angle = 0;
      }
      if (my_is_fading_out) 
      {
        if (--my_fade_count == 0) 
        {
          my_is_running = false;
          my_timer.stop();
        }
      }
      else if (my_fade_count < FADE_LIMIT) 
      {
        my_fade_count++;
      }
    }
  }
  
  /**
   * Returns the timer delay.
   * @return the_delay
   */
  public int getDelay()
  {
    return my_timer.getDelay();
  }
  
  /**
   * Returns the animation length.
   * @return ANIMATION_LENGTH
   */
  public int getLength()
  {
    return ANIMATION_LENGTH;
  }

  /**
   * Starts the timer.
   */
  public void start() 
  {
    if (my_is_running) 
    {
      return;
    }
    
    // Run a thread for animation.
    my_is_running = true;
    my_is_fading_out = false;
    my_fade_count = 0;
    final int tick = ANIMATION_LENGTH / (2 * FPS);
    my_timer = new Timer(tick, this);
    my_timer.start();
  }

  /**
   * Stops the timer.
   */
  public void stop() 
  {
    my_is_fading_out = true;
  }
  
  /**
   * Returns whether or not the animation is running.
   * @return True if the animation is running.
   */
  public boolean isRunning()
  {
    return my_stop_animation_timer.isRunning();
  }
  
  /**
   * Starts the animation.
   */
  public void startRunning()
  {
    my_stop_animation_timer.start();
  }

  /**
   * Repaints the JLayer as needed.
   * @param the_pce The event calling for a repaint.
   * @param the_layer The layer to repaint.
   */
  public void applyPropertyChange(final PropertyChangeEvent the_pce, 
                                  final JLayer<? extends JPanel> the_layer) 
  {
    if (TICK.equals(the_pce.getPropertyName())) 
    {
      the_layer.repaint();
    }
  }
}
