import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Target
{
    private int corner1;
    private int corner2;
    private int corner3;
    
    public Target(int coordinate1, int coordinate2, int coordinate3)
    {
        this.corner1 = coordinate1;
        this.corner2 = coordinate2;
        this.corner3 = coordinate3;
        
    }
    
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ring1 = new Ellipse2D.Double(this.corner1, this.corner1, 100, 100);
        
        g2.fill(ring1);
        
        
    }
}