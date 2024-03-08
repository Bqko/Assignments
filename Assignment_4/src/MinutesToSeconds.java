import java.util.Scanner;

public class MinutesToSeconds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of minutes: ");
        int minute = scanner.nextInt();

        int result = minute * 60;

        System.out.println("The number of seconds is: " + result);

        scanner.close();
    }
}