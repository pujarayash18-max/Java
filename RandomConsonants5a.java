import java.util.Random;
public class RandomConsonants5a {
    public static void main(String[] args) {
        int length = 5; 
        String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
        Random r = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(consonants.length()+1);
            result += consonants.charAt(index);
        }
        System.out.println(result);
    }
}