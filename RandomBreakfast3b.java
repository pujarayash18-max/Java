import java.util.Scanner;
import java.util.Random;

public class RandomBreakfast3b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] breakfasts = new String[5];
        System.out.println("Enter 5 types of breakfast:");
        for (int i = 0; i < breakfasts.length; i++) {
            System.out.print("Breakfast " + (i + 1) + ": ");
            breakfasts[i] = scanner.nextLine();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(breakfasts.length);
        System.out.println("Today's breakfast is: " + breakfasts[randomIndex]);
    }
}