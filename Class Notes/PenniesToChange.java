import java.util.Scanner;
public class PenniesToChange
{
    public static void main (String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter an integer number of pennies.");
        int pennies = s.nextInt();
        int dollars = pennies / 100;
        int leftoverDollars = pennies % 100;
        int quarters = leftoverDollars / 25;
        int leftoverQuarters = leftoverDollars % 25;
        int dimes = leftoverQuarters / 10;
        int leftoverDimes = leftoverQuarters % 10;
        int nickels = leftoverDimes / 5;
        int leftoverPennies = leftoverDimes % 5;
        System.out.println(dollars + "dollars, " + quarters + " quarters, " + dimes + " dimes, "
        + nickels + " nickels, " + leftoverPennies + " and pennies.");
    }
}