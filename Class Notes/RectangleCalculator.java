import java.util.Scanner;
import java.lang.Math;

public class RectangleCalculator
{
    private double height;
    private double width;
    private double area;
    private double perimeter;
    private double diagonalLength;
    
    public static void main (String args[])
    {
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter height of rectangle: ");
        double enteredHeight = s.nextDouble();
        System.out.print("Enter width of rectangle: ");
        double enteredWidth = s.nextDouble();
        RectangleCalculator r = new RectangleCalculator(enteredHeight, enteredWidth);
        System.out.println(r);
    }
    
    public RectangleCalculator(double initialHeight, double initialWidth)
    {
        this.height = initialHeight;
        this.width = initialWidth;
        this.area = initialHeight * initialWidth;
        this.perimeter = 2 * initialHeight + 2 * initialWidth;
        this.diagonalLength = Math.sqrt(initialHeight*initialHeight + initialWidth*initialWidth);
        
    }
    public double getArea()
    {
        return area;
    }
    public double getPerimeter()
    {
        return perimeter;
    }
    public double getDiagonalLength()
    {
        return diagonalLength;
    }
    public String toString()
    {
        String str = "Height: " + this.height + "\nWidth: " + this.width + "\nArea: " + this.area
        + "\nPerimeter: " + perimeter + "\nDiagonal length: " + this.diagonalLength;
        return str;
    }
}