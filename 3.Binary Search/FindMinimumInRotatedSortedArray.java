
import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int answer = findMinimum(array);
        System.out.println(answer);

        scanner.close();
    }
    //try dry run for better clarity

    private static int findMinimum(int[] nums) {
        // Write your solution here.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        //bsearch
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                ans = Math.min(nums[low], ans);
                low = mid + 1;
            } else {
                ans = Math.min(nums[mid], ans);
                high = mid - 1;
            }

        }
        return 0;
    }
}
