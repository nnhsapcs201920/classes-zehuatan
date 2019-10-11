import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Represents a drawable sky which changes colors
 * 
 * @author ztan
 * @version 14 October 2019
 */
public class Sky
{
    private int windowLength;
    private int windowHeight;
    private Color skyColor;
    private int colorCounter;
    
    /**
     * Constructs the sky
     */
    public Sky(int x, int y)
    {
        this.skyColor = Color.WHITE;
        this.windowLength = x;
        this.windowHeight = y;
    }
    
    /**
     * Draws the sky
     */
    public void draw(Graphics2D g2)
    {
        Rectangle body = new Rectangle(0, 0, windowLength, windowHeight);
        g2.setColor(skyColor);
        g2.fill(body);
    }
    /**
     * Changes the color of the sky
     */
    public void nextColor()
    {
        
        if (colorCounter < 40)
        {
            skyColor = new Color(255, 255 - colorCounter, 255, 200);
            colorCounter++;
        }
        else
        {
            if (colorCounter < 80)
            {
                skyColor = new Color(255, 255 - (80 - colorCounter), 255, 200);
                colorCounter++;
            }
            else
            {
                colorCounter = 0;
                skyColor = new Color (255, 255, 255, 200);
            }
        }
        
    }
    
}