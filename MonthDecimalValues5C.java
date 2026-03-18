import java.util.Random;    
public class MonthDecimalValues5C {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"};
        double[] decimalValues = new double[12];
        Random rn = new Random();
        for (int i = 0; i < 12; i++) {
            decimalValues[i] = 100 * rn.nextDouble();
        }
        System.out.println("Month and Corresponding Decimal Value:");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%s: %.2f\n", months[i], decimalValues[i]);
        }
        double sum = 0;
        for (double value : decimalValues) {
            sum += value;
        }
        double average = sum / 12;
        System.out.printf("\nAverage of Decimal Values: %.2f\n", average);
    }
}
