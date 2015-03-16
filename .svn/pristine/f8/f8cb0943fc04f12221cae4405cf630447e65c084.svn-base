/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Project Tetris
 * December 05, 2012
 */

package tetris.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Sends the score to the server.
 * 
 * @author Mohammad Juma
 * @version 12-05-2012
 */
public class SendScore 
{
  /**
   * The host address.
   */
  private static final String URL = "http://131.191.72.157/tetris/add_score.php";

  /**
   * The name of the player.
   */
  private final String my_name;

  /**
   * The players score.
   */
  private final int my_score;
  
  /**
   * The result of adding the score.
   */
  private String my_result;

  /**
   * Constructs a new send score object for sending the high score to the server.
   * 
   * @param the_name The players name.
   * @param the_score The players score.
   */
  public SendScore(final String the_name, final int the_score) 
  {
    my_name = the_name;
    my_score = the_score;
  }

  /**
   * Opens a connection and sends the score.
   */
  public void sendScore() 
  {
    // Build parameter string
    final String data = "name=" + my_name + "&score=" + my_score;
    try 
    {

      // Send the request
      final URL url = new URL(URL);
      final URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
      final OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

      // write parameters
      writer.write(data);
      writer.flush();

      // Get the response
      final StringBuffer answer = new StringBuffer();
      final BufferedReader reader =
          new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while (true)
      {
        line = reader.readLine();
        if (line == null)
        {
          break;
        }
        answer.append(line);
      }
      writer.close();
      reader.close();

      // Output the response
      my_result = answer.toString();

    } 
    catch (final MalformedURLException ex) 
    {
      ex.printStackTrace();
    } 
    catch (final IOException ex) 
    {
      ex.printStackTrace();
    }
  }
  
  /**
   * Returns the host address.
   * @return URL
   */
  public String getHost()
  {
    return URL;
  }
  
  /**
   * Returns the result.
   * @return my_result
   */
  public String result()
  {
    return my_result;
  }

}