import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

public class TargetExtensionComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int x = getWidth();
        int y = getHeight();
        Target targetSpecial = new Target(0, 0, x, y);
        g.setColor(Color.BLACK);
        targetSpecial.outline(g2);
        g.setColor(Color.PINK);
        targetSpecial.draw(g2);
    }
}