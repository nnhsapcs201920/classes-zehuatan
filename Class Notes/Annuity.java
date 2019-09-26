import java.util.Scanner;

public class Annuity
{
    static Scanner s = new Scanner(System.in);
    static double payment = s.nextDouble();
    static double interest = s.nextDouble();
    static int numberOfPayments = s.nextInt();
    
    public static void main(String args[])
    {
        Annuity.calcPresentValue(payment, interest, numberOfPayments);
    }
    
    public static double calcPresentValue(double pmt, double i, int n)
    {
        double value = pmt * ((((Math.pow( (1+i) , (n-1) ) - 1 )/i)/(Math.pow((1+i),(n-1))))+1);
        return value;
    }
}
