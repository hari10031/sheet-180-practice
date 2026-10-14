
import java.util.Scanner;

public class FindPeakElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int answer = findPeakElement(array);
        System.out.println(answer);

        scanner.close();
    }

    private static int findPeakElement(int[] nums) {
        // Write your solution here.
        //linearserach
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i] > nums[i - 1]) && (nums[i] > nums[i + 1])) {
                return i;
            }
        }
        //bsearch
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((nums[mid - 1] < nums[mid]) && (nums[mid] > nums[mid + 1])) {
                return mid;
            }
            if (nums[mid - 1] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
