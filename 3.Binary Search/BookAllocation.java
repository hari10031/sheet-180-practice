
import java.util.Scanner;

public class BookAllocation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int students = scanner.nextInt();
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        allocateBooks(pages, students);
        scanner.close();
    }

    private static void allocateBooks(int[] nums, int students) {
        // Write your solution here.
        int low = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }
        int ans = -1;
        int n = nums.length;
        for (int i = low; i <= high; i++) {
            if (count(nums, i) <= students) {
                ans = i;
                break;
            }
        }

        //bsearch
        int ans1 = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (count(nums, mid) <= students) {
                ans1 = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
    }

    private static int count(int[] nums, int pages) {
        int n = nums.length;
        int student = 1;
        int page = 0;
        for (int i = 0; i < n; i++) {
            if (page + nums[i] <= pages) {
                page += nums[i];
            } else {
                student++;
                page = nums[i];
            }

        }
        return student;
    }
}
