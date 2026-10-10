
import java.util.*;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int answer = findLongestSubarray(array, k);
        System.out.println(answer);

        scanner.close();
    }

    private static int findLongestSubarray(int[] nums, int k) {
        // Write your solution here.
        //brute
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    len = Math.max(j - i + 1, len);
                }
            }
        }
        //hashing
        Map<Integer, Integer> mpp = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }
            int rem = k - sum;
            if (mpp.containsKey(rem)) {
                maxlen = Math.max(maxlen, i - mpp.get(rem) + 1);
            }
            if (!mpp.containsKey(sum)) {
                mpp.put(sum, i + 1);
            }
        }
        //contains only postivces
        int mxlen = 0;
        int left = 0;
        int right = 0;
        int sum1 = nums[0];
        while (right < n) {
            while (left <= right && sum1 > k) {
                sum1 -= nums[left];
                left++;
            }
            if (sum1 == k) {
                mxlen = Math.max(mxlen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum1 += nums[right];
            }
        }
        return 0;
    }
}
