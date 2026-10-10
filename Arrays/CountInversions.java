
import java.util.Scanner;

public class CountInversions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        System.out.println(countInversions(array));

        scanner.close();
    }
//     Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

// It indicates how close an array is to being sorted.
// A sorted array has an inversion count of 0.
// An array sorted in descending order has maximum inversion.
    private static long countInversions(int[] num) {
        // Write your solution here.
        //brute
        int cnt = 0;
        int n = num.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (num[i] > num[j]) {
                    cnt++;
                }
            }
        }
        //optimal
        //merge sort
        int cnt1 = 0;
        mergesort(0, n - 1, num);
        return cnt;
    }

    private static long mergesort(int low, int high, int[] nums) {
        long cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            cnt += mergesort(low, mid, nums);
            cnt += mergesort(mid + 1, high, nums);
            cnt += merge(low, mid, high, nums);
        }
        return cnt;
    }

    private static long merge(int low, int mid, int high, int[] nums) {
        int[] temp = new int[high - low + 1];
        int lt = low;
        int rt = mid + 1;
        int idx = 0;
        long cnt = 0;
        while (lt <= mid && rt <= high) {
            if (nums[lt] <= nums[rt]) {
                temp[idx++] = nums[lt++];
            } else {
                temp[idx++] = nums[rt++];
                cnt += (mid - lt + 1);
            }
        }
        while (lt <= mid) {
            temp[idx++] = nums[lt++];

        }
        while (rt <= high) {
            temp[idx++] = nums[rt++];
        }
        System.arraycopy(temp, 0, nums, low, high - low + 1);
        return cnt;
    }
}
