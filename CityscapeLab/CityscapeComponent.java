import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent
{
    // define the objects in your Cityscape as instance variables
    // ...
    private Building building1; 
    private Building building2;
    private Building building3;
    private Building building4;
    private Building building5;
    private Building building6;
    private Building building7;
    private Building building8;
    private Sun majorSun;
    private Sky sky;
    private DiscoFloor discoFloor;
    
    // define the CityscapeComponent constructor and intialize all instance variables
    // ...
    
    public CityscapeComponent()
    {
        this.building1 = new Building(0, 100, 100, 500);
        this.building2 = new Building(100, 200, 100, 400);
        this.building3 = new Building(200, 400, 100, 200);
        this.building4 = new Building(300, 450, 100, 150);
        this.building5 = new Building(400, 450, 100, 150);
        this.building6 = new Building(500, 400, 100, 200);
        this.building7 = new Building(600, 200, 100, 400);
        this.building8 = new Building(700, 50, 100, 550);
        this.majorSun = new Sun(100, 200, 600);
        this.sky = new Sky(800, 600);
        this.discoFloor = new DiscoFloor(0, 600, 800, 200, 20, 20);
        
    }
    
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * 
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method on each object in your Cityscape
        // ...
        this.sky.draw(g2);
        this.majorSun.draw(g2);
        this.building1.draw(g2);
        this.building2.draw(g2);
        this.building3.draw(g2);
        this.building4.draw(g2);
        this.building5.draw(g2);
        this.building6.draw(g2);
        this.building7.draw(g2);
        this.building8.draw(g2);
        this.discoFloor.draw(g2);
        
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...
        this.building1.nextWindowColor();
        this.building2.nextWindowColor();
        this.building3.nextWindowColor();
        this.building4.nextWindowColor();
        this.building5.nextWindowColor();
        this.building6.nextWindowColor();
        this.building7.nextWindowColor();
        this.building8.nextWindowColor();
        this.majorSun.nextColor();
        this.majorSun.spin();
        this.sky.nextColor();
        discoFloor.nextColor();
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        
        repaint();
    }

}
