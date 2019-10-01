import java.util.Scanner;

public class RemoveComma
{
    
    public static void main (String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter an integer between 1,000 and 999,999: ");
        String number = s.next();
        int numberLength = number.length();
        //5 - numberLength = comma location
        String newNumber = number.substring(0, numberLength - 4) + 
        number.substring(numberLength - 3, numberLength);
        System.out.println(newNumber);
        
        
    }
    
    
}