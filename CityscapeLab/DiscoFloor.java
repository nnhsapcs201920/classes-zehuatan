import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Represents a drawable disco floor with colored tiles
 * 
 * @author ztan
 * @version 14 Oct 2019
 */
public class DiscoFloor
{
    private Color tileColor;
    private int colorCounter;
    private int cornerX;
    private int cornerY;
    private int width;
    private int height;
    private int rows;
    private int columns;
    
    public DiscoFloor(int x, int y, int frameWidth, int frameHeight, int numRows, int numColumns)
    {
        this.tileColor = Color.WHITE;
        this.cornerX = x;
        this.cornerY = y;
        this.width = frameWidth;
        this.height = frameHeight;
        this.rows = numRows;
        this.columns = numColumns;
    }
    
    public void draw(Graphics2D g2)
    {
        Rectangle outline = new Rectangle(this.cornerX, this.cornerY, this.width, this.height);
        
        for (int i = 0; i < rows; i++)
        {
            int yCoordinate = this.cornerY + ((int) ((double) this.height / this.rows) * i);
            for (int j = 0; j < columns; j++)
            {
                Rectangle tile = new Rectangle((int) (this.cornerX + j * ((double) this.width / this.columns)), yCoordinate, this.width / this.columns, this.height / this.rows);
                this.tileColor = new Color(2 * (i + j + this.colorCounter) % 170 + 85,
                3 * Math.abs(- i - j + this.colorCounter) % 170 + 85,
                5 * Math.abs( i - j + this.colorCounter) % 170 + 85, 255);
                
                
                g2.setColor(this.tileColor);
                g2.fill(tile);
                g2.setColor(Color.BLACK);
                g2.draw(tile);
            }
        }
    }
    
    public void nextColor()
    {
        this.colorCounter++;
        
        
    }
}