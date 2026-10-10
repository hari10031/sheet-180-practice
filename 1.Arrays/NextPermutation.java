
import java.util.Scanner;

public class NextPermutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        findNextPermutation(array);

        for (int value : array) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    private static void findNextPermutation(int[] nums) {
        // Write your solution here.
        int idx = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(0, n - 1, nums);
            return;
        }
        for (int i = nums.length - 1; i > idx; i--) {
            if (nums[idx] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(idx + 1, n - 1, nums);
        return;

    }

    private static void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
