import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int N = sc.nextInt();
        int Fact = 1;

        for (int i = 1; i <= N; i++) {
            Fact *= i; 
        }

        System.out.println("Factorial of " + N + " is: " + Fact);
    }
}
