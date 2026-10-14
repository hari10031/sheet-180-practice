
import java.util.Scanner;

public class FindNthRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int number = scanner.nextInt();

        findNthRoot(n, number);
        scanner.close();
    }

    private static void findNthRoot(int n, int number) {
        // Write your solution here.
        //brute
        int ans = 0;
        for (int i = 1; i <= number; i++) {
            int pow = (int) Math.pow(i, n);
            if (pow == number) {
                ans = i;
                break;
            } else if (pow < number) {
                ans = i;
            } else {
                break;
            }
        }
        //bsearch

        int low = 0;
        int high = number;
        while (low <= high) {
            int mid = (low + high) / 2;
            int pow = (int) Math.pow(mid, n);
            if (pow == number) {
                return;
            } else if (pow < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
