import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
/**
 * Represents buildings with variable position, height, and width. Buildings have windows and doors.
 * 
 * @author ztan
 * @version 4 October 2019
 */
public class Building
{
    private int width;
    private int height;
    private int cornerX;
    private int cornerY;
    
    /**
     * Constructs a building with a coordinate position, height, and width.
     */
    public Building(int x, int y, int initialWidth,int initialHeight)
    {
        this.width = initialWidth;
        this.height = initialHeight;
        this.cornerX = x;
        this.cornerY = y;
    }
    
    /**
     * Draws the building.
     */
    public void draw(Graphics2D g2)
    {
        int dimensionRatio = (int) Math.pow(this.height * this.width, .25);; 
        Rectangle body = new Rectangle(this.cornerX, this.cornerY, this.width, this.height);
        Rectangle window = new Rectangle(this.cornerX + (dimensionRatio),
        this.cornerY + (dimensionRatio), dimensionRatio, dimensionRatio);
        g2.setColor(Color.GRAY);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        int YCoordinate = (int) window.getY();
        for (int i = 0; i < ((this.height / dimensionRatio / 2) - 1); i++)
        {
            for (int j = 0; j < (this.width / dimensionRatio / 2); j++)
            {
                window.setLocation(this.cornerX + ((2 * j + 1) * (dimensionRatio)),
                YCoordinate);
                g2.setColor(Color.CYAN);
                g2.fill(window);
                g2.setColor(Color.BLACK);
                g2.draw(window);
            }
            YCoordinate += (dimensionRatio * 2);
        }
    }
}