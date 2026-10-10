
import java.util.*;

public class Sort012 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        sortArray(array);

        for (int value : array) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    private static void sortArray(int[] nums) {
        // Write your solution here.
        Arrays.sort(nums);
        //three pointers dutch man nation flag algo
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        // int n = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(mid, low, nums);
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;

            }
        }
    }

    public static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
