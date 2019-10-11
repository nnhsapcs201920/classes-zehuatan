import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
 * Represents a drawable sun which also has rays of light.
 * 
 * @author ztan
 * @version 14 October 2019
 */
public class Sun
{
    private int cornerX;
    private int cornerY;
    private int diameter;
    private Color rayColor;
    private int colorCounter;
    private int angle;
    private Color sunColor;
    
    /**
     * Constructs a sun with coordinate position, height, and radius.
     */
    public Sun (int x, int y, int size)
    {
        this.cornerX = x;
        this.cornerY = y;
        this.diameter = size;
        this.rayColor = Color.WHITE;
        this.colorCounter = 0;
        this.angle = 0;
        this.sunColor = Color.WHITE;
    }
    
    /**
     * Draws the sun.
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double body = new Ellipse2D.Double(this.cornerX, this.cornerY, this.diameter, this.diameter);
        
        
        
        g2.setColor(Color.BLACK);
        g2.draw(body);
        g2.setColor(rayColor);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle, 30);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle + 60, 30);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle + 120, 30);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle + 180, 30);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle + 240, 30);
        g2.fillArc(this.cornerX - this.diameter, this.cornerY - this.diameter, this.diameter * 3, this.diameter * 3, this.angle + 300, 30);
        g2.setColor(sunColor);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * this.angle / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * this.angle / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * this.angle / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * this.angle / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * this.angle / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * this.angle / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * this.angle / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * this.angle / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 30) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 60) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 90) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 120) / 180))),
        this.diameter, 270, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.diameter, 90, 180);
        g2.drawArc(this.cornerX  + (this.diameter/2) + (int)  ((this.diameter / 2) * (-Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.cornerY,
        - (int)  ((this.diameter) * (-Math.cos(Math.PI * (this.angle + 150) / 180))),
        this.diameter, 270, 180);
        
    }
    /**
     * Changes the colors of the sun and its rays
     */
    public void nextColor()
    {
        this.rayColor = new Color(255 - (colorCounter + 40) % 120, 255 - ((colorCounter + 80) % 120), 255 - ((colorCounter) % 120), 255 - ((colorCounter * 2) % 80 ));
        this.sunColor = new Color(255, 200, 60, 150);
        this.colorCounter++;
        
    }
    /**
     * Spins the sun and rotates its rays
     */
    public void spin()
    {
        this.angle--;
    }
    
}