
import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int cows = scanner.nextInt();
        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = scanner.nextInt();
        }

        maxMinDistance(stalls, cows);
        scanner.close();
    }

    private static void maxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        // Write your solution here.
        // linear serach;
        int n = stalls.length;
        int ans = 0;
        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (!canweplace(i, stalls, cows)) {
                ans = i - 1;
                break;
            }
        }
        //bsearch
        int low = 1;
        int high = limit;
        int ans1 = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canweplace(mid, stalls, cows)) {
                ans1 = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

    }

    private static boolean canweplace(int dist, int[] stalls, int cows) {
        int n = stalls.length;
        int cnt = 1;
        int last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cnt++;
                last = stalls[i];
            }
            if (cnt >= cows) {
                return true;
            }
        }
        return false;

    }

    private static void bsearch(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1;
        int n = nums.length;
        int high = nums[n - 1] - nums[0];
        int ans2 = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canplace(mid, nums, k)) {
                ans2 = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    private static boolean canplace(int dist, int[] nums, int k) {
        int n = nums.length;
        int last = nums[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - last >= dist) {
                cnt++;
                last = nums[i];
            }
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }
}
