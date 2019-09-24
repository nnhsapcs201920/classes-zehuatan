


public class RectangleCalculator
{
    private double height;
    private double width;
    private double area;
    private double perimeter;
    private double diagonalLength;
    
    public RectangleCalculator(double initialHeight, double initialWidth)
    {
        this.height = initialHeight;
        this.width = initialWidth;
        this.area = initialHeight * initialWidth;
        this.perimeter = 2 * initialHeight + 2 * initialWidth;
        this.diagonalLength = Math.sqrt(initialHeight*initialHeight + initialWidth*initialWidth, 1/2);
    }
    public double getArea()
    {
        return 1;
    }
    public double getPerimeter()
    {
        return 1;
    }
    public double getDiagonalLength()
    {
        return 1;
    }
    public String toString()
    {
        return "";
    }
}