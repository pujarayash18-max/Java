import java.util.Scanner;

public class VowelCounter7a {
    public static void main(String[] args) {
        int aC = 0, eC = 0, iC = 0, oC = 0, uC = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a String (Type 'quit' to stop):");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("quit")) {
                break;
            }
            int[] vowelCount = countVowels(str);
            System.out.println("Vowel counts in the sentence: \"" + str + "\"");
            System.out.println("a: " + vowelCount[0]);
            System.out.println("e: " + vowelCount[1]);
            System.out.println("i: " + vowelCount[2]);
            System.out.println("o: " + vowelCount[3]);
            System.out.println("u: " + vowelCount[4]);
            aC += vowelCount[0];
            eC += vowelCount[1];
            iC += vowelCount[2];
            oC += vowelCount[3];
            uC += vowelCount[4];
            System.out.println("\nTotal vowel counts from all sentences:");
            System.out.println("a: " + aC);
            System.out.println("e: " + eC);
            System.out.println("i: " + iC);
            System.out.println("o: " + oC);
            System.out.println("u: " + uC);
        }
        sc.close();
    }
    public static int[] countVowels(String str) {
        int[] vowelCount = new int[5];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                vowelCount[0]++;
            } else if (ch == 'e') {
                vowelCount[1]++;
            } else if (ch == 'i') {
                vowelCount[2]++;
            } else if (ch == 'o') {
                vowelCount[3]++;
            } else if (ch == 'u') {
                vowelCount[4]++;
            }
        }
        return vowelCount;
    }
}
