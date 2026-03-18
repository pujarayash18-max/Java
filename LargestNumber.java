import java.util.Scanner;
public class LargestNumber
{
    public static void main()
    {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the First Number ");
         int N1=sc.nextInt();
         System.out.print("Enter the Second Number ");
         int N2=sc.nextInt();
         if(N1>N2)
         {
             System.out.println("The largest Number is "+N1);
         }
         else if(N2>N1)
         {
             System.out.println("The Largest Number is "+N2);
         }
         else
         {
             System.out.println("Both Numbers are same");
         }
    }
}