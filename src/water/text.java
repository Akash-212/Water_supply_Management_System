import java.util.ArrayList;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int count = scanner.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < count; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            int num = scanner.nextInt();
            numbers.add(num);
        }

        System.out.println("Elements in the ArrayList: " + numbers);
    }
}
