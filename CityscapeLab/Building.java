import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Building
{
    private int width;
    private int height;
    private int cornerX;
    private int cornerY;
    
    public Building(int x, int y, int initialWidth,int initialHeight)
    {
        this.width = initialWidth;
        this.height = initialHeight;
        this.cornerX = x;
        this.cornerY = y;
    }
    
    public void draw(Graphics2D g2)
    {
        Rectangle body = new Rectangle(this.cornerX, this.cornerY, this.width, this.height);
        g2.fill(body);
    }
}