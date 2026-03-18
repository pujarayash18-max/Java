import java.util.Scanner;

public class CountAlphabets6A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String Line = sc.nextLine();
        int Vcount = 0, Ccount = 0;
        String Vo = "aeiouAEIOU";
        String Co = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        for (int i = 0; i < Line.length(); i++) { 
             char ch = Line.charAt(i);
            if (Vo.indexOf(ch) != -1) {
                Vcount++;
            }
            else if (Co.indexOf(ch) != -1) {
                Ccount++;
            }
        }
        System.out.println("Number of Vowels are : " + Vcount);
        System.out.println("Number of Consonants are : " + Ccount); 
    }
}