import java.util.Scanner;
public class oddOReven
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number");
        int N=sc.nextInt();
        if(N%2==0)
        {
            System.out.println("The Number "+N+" is Even");
        }
        else
        {
            System.out.println("The Number "+N+" is Odd");
        }
    }
}