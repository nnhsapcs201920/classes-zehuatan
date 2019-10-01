import java.util.Scanner;

public class TelephoneNumber
{
    public static void main (String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a ten-digit telephone number: ");
        String telephoneNumber = s.next();
        String newNumber = "(" + telephoneNumber.substring(0, 3) + ")" + telephoneNumber.substring(3, 6)
         + "-" + telephoneNumber.substring(6);
        System.out.println(newNumber);
    }
}