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
        int dimensionRatio = (this.height) / (this.width) ;
        Rectangle body = new Rectangle(this.cornerX, this.cornerY, this.width, this.height);
        Rectangle window = new Rectangle(this.cornerX + (this.width / dimensionRatio),
        this.cornerY + (this.height / dimensionRatio), dimensionRatio * 10, dimensionRatio * 10);
        g2.setColor(Color.GRAY);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        //fix math such that windows appear at regular intervals within the body of the building, and repeat
        //for every row.
        for (int i = 0; i < dimensionRatio; i++)
        {
            g2.setColor(Color.CYAN);
            g2.fill(window);
            g2.setColor(Color.BLACK);
            g2.draw(window);
            window.setLocation(this.cornerX + (i *(this.width/10)), this.cornerY + (i *(this.height / 10)));
        }
        
    }
}