import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;


public class TargetComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int x = getWidth();
        int y = getHeight();
        Target target1 = new Target(0, 0, x, y);
        Target target2 = new Target(x/8, y/8, 3*x/4, 3*y/4);
        Target target3 = new Target(x/4, y/4, x/2, y/2);
        Target target4 = new Target(3*x/8, 3*y/8, x/4, y/4);
        g.setColor(Color.BLACK);
        target1.draw(g2);
        g.setColor(Color.WHITE);
        target2.draw(g2);
        g.setColor(Color.BLACK);
        target3.draw(g2);
        g.setColor(Color.WHITE);
        target4.draw(g2);
        
    }
}