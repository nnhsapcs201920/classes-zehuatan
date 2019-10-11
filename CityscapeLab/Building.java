import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
/**
 * Represents drawable buildings with variable position, height, and width. Buildings have windows, and their windows may change color.
 * 
 * @author ztan
 * @version 14 October 2019
 */
public class Building
{
    private int width;
    private int height;
    private int cornerX;
    private int cornerY;
    private Color windowColor;
    private int windowCounter;
    
    /**
     * Constructs a building with a coordinate position, height, and width.
     */
    public Building(int x, int y, int initialWidth,int initialHeight)
    {
        this.width = initialWidth;
        this.height = initialHeight;
        this.cornerX = x;
        this.cornerY = y;
        this.windowColor = Color.WHITE;
    }
    
    /**
     * Draws the building.
     */
    public void draw(Graphics2D g2)
    {
        double dimensionRatio = Math.pow(this.height * this.width, .25);
        Rectangle body = new Rectangle(this.cornerX, this.cornerY, this.width, this.height);
        Rectangle window = new Rectangle(this.cornerX + ((int) dimensionRatio),
        this.cornerY + (int) dimensionRatio, (int) dimensionRatio, (int) dimensionRatio);
        
        g2.setColor(Color.GRAY);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        
        double YCoordinate = window.getY();
        for (int i = 0; i < (int) ((this.height / dimensionRatio / 2) - 1); i++)
        {
            for (int j = 0; j < (int) (this.width / dimensionRatio / 2); j++)
            {
                window.setLocation(this.cornerX + (int) ((2 * j + 1) * (dimensionRatio)),
                (int) YCoordinate);
                g2.setColor(windowColor);
                g2.fill(window);
                g2.setColor(Color.BLACK);
                g2.draw(window);
            }
            YCoordinate += (dimensionRatio * 2);
        }
    }
    /**
     * Changes the color of the windows
     */
    public void nextWindowColor()
    {
        if (windowCounter % 120 < 60)
        {
            this.windowColor = Color.CYAN;
        }
        else
        {
            this.windowColor = Color.YELLOW;
        }
        windowCounter++;
    }
}