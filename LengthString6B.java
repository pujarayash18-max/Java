import java.util.Scanner;
public class LengthString6B
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.nextLine();
        int l=str.length();
        int sIndex=l/2;
        String str2=str.substring(sIndex);
        System.out.println("Length of String "+str+" is "+ l +" and another half of string is "+str2);
    }
}