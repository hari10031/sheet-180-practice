
import java.util.Scanner;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        boolean answer = search(array, target);
        System.out.println(answer);

        scanner.close();
    }

    private static boolean search(int[] nums, int target) {
        // Write your solution here.
        //brute
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                return true;
            }
        }
        //optimal bsearch
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == k) {
                return true;
            }
            if ((nums[mid] == nums[low]) && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }
        return false;
    }
}
