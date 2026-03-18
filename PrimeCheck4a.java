import java.util.Scanner;
public class PrimeCheck4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number:");
        int number = sc.nextInt();
        int count = 0;
        if (number <= 1) 
        {
            System.out.println(number + " is not a Prime Number.");
        } 
        else 
        {
            for (int i = 1; i <= number; i++) 
            {
                if (number % i == 0) 
                {
                    count++;
                }
            }
            if (count >= 2) 
            {
                System.out.println(number + " is a Prime Number.");
            } else 
            {
                System.out.println(number + " is not a Prime Number.");
            }
        }
        sc.close();
    }
}
