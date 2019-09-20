import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Target
{
    private int cornerX;
    private int cornerY;
    private int targetSizeX;
    private int targetSizeY;
    
    public Target(int x, int y, int sizeX, int sizeY)
    {
        this.cornerX = x;
        this.cornerY = y;
        this.targetSizeX = sizeX;
        this.targetSizeY = sizeY;
        
    }
    
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ring1 = new Ellipse2D.Double(this.cornerX, this.cornerY, targetSizeX, targetSizeY );
        g2.fill(ring1);
        
    }
    public void outline(Graphics2D g2)
    {
        Ellipse2D.Double ring1 = new Ellipse2D.Double(this.cornerX, this.cornerY, targetSizeX, targetSizeY);
        g2.draw(ring1);
    }
    
}