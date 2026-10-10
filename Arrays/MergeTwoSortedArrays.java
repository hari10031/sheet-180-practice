
import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstLength = scanner.nextInt();
        int[] firstArray = new int[firstLength];
        for (int index = 0; index < firstLength; index++) {
            firstArray[index] = scanner.nextInt();
        }

        int secondLength = scanner.nextInt();
        int[] secondArray = new int[secondLength];
        for (int index = 0; index < secondLength; index++) {
            secondArray[index] = scanner.nextInt();
        }

        mergeArrays(firstArray, secondArray);

        for (int value : firstArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int value : secondArray) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    private static void mergeArrays(int[] firstArray, int[] secondArray) {
        // Write your solution here without using extra arrays.
    }
}
