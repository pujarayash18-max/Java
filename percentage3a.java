import java.util.*;

public class percentage3a {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float Sum = 0;
        int sub = 6; 

        for (int i = 1; i <= sub; i++) {
            System.out.print("Enter the Marks of Subject " + i + ": ");
            float mark = sc.nextFloat();
            Sum += mark;
        }

        float per = Sum / sub;
        System.out.println("Total per is= " + per);
        sc.close();
    }
}
