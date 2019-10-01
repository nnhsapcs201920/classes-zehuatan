import java.util.Scanner;
public class AddComma
{
    public static void main (String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter an integer between 1000 and 999999: ");
        String number = s.next();
        int numberLength = number.length();
        String newNumber = number.substring(0, numberLength - 3) + "," 
        + number.substring(numberLength - 3, numberLength);
        System.out.println(newNumber);
    }
    
}