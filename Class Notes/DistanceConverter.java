import java.util.Scanner;

public class DistanceConverter
/*
 * Can't be static if declared within a method! (only makes sense within the class)
 * Will the constant only be used in th method or might it be used outside the class? (you need to decide)
 * You don't have to, but it's a good idea to put the name of the class in front of all class variables.
 * Class variable, class attribute, and static variable all refer to the same thing.
 */
{
    final static double FEET_PER_YARD = 3;
    final static double INCHES_PER_FOOT = 12;
   public static void main(String[] args)
   {
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the number of yards to be converted to feet and inches: ");
      
      
      double yards = s.nextDouble();
      double feet = yards * DistanceConverter.FEET_PER_YARD;
      double inches = feet * DistanceConverter.INCHES_PER_FOOT;

      System.out.println(yards + " yards are " + feet + " feet");
      System.out.println(yards + " yards are " + inches + " inches");
   }
}
