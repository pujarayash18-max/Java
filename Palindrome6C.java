import java.util.Scanner;

public class Palindrome6C
{
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a No: ");
        int No = sc.nextInt();
        int ONo = No;
        int RNo = 0;
        while (No != 0) {
            int digit = No % 10;
            RNo = RNo * 10 + digit; 
            No /= 10;
        }
        if (ONo == RNo) {
            System.out.println(ONo + " is a palindrome.");
        } else {
            System.out.println(ONo + " is not a palindrome.");
        }
    }
}
