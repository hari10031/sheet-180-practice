
import java.util.Scanner;

public class ReversePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        System.out.println(countReversePairs(array));

        scanner.close();
    }

    private static long countReversePairs(int[] nums) {
        // Write your solution here.
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    cnt++;
                }
            }
        }
        //optimal
        int n = nums.length;

        mergesort(0, n - 1, nums);
        return 0;
    }

    private static long mergesort(int low, int high, int[] nums) {
        int cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            cnt += mergesort(low, mid, nums);
            cnt += mergesort(mid + 1, high, nums);
            cnt += countPairs(nums, low, mid, high);
            merge(low, mid, high, nums);
        }
        return cnt;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1, cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    private static void merge(int low, int mid, int high, int[] nums) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int idx = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];

            }
        }
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }
        while (right <= high) {
            temp[idx++] = nums[right++];
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}
