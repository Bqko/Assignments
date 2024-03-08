import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius;

        // Using while loop to check if the number is positive
        do {
            System.out.print("Enter the radius of the circle: ");
            radius = scanner.nextDouble();
            
            // Checks if the number is positive, negative or 0
            if (radius <= 0) {
                System.out.println("The number must be greater than 0.");
            }
        } while(radius <= 0);

        // Circle area formula
        double area = Math.PI * radius * radius;

        // Print out the results
        System.out.println("Area of the circle is: " + area);

        scanner.close();
    }
}
