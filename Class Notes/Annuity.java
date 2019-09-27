import java.util.Scanner;

public class Annuity
{
    
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Payment per year");
        double payment = s.nextDouble();
        System.out.print("Interest rate:");
        double interest = s.nextDouble();
        System.out.print("Number of payments:");
        int numberOfPayments = s.nextInt();
    
        System.out.println(Annuity.calcPresentValue(payment, interest, numberOfPayments));
    }
    
    public static double calcPresentValue(double pmt, double i, int n)
    {
        double value = pmt * ((((Math.pow( (1+i) , (n-1) ) - 1 )/i)/(Math.pow((1+i),(n-1))))+1);
        return value;
    }
}
