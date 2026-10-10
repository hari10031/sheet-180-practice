
import java.util.Scanner;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        System.out.println(maxSubarraySum(array));

        scanner.close();
    }

    private static int maxSubarraySum(int[] nums) {
        // Write Kadane's algorithm here.
        //brute
        int maxsum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxsum = Math.max(sum, maxsum);
            }
        }
        maxsum = Integer.MIN_VALUE;
        //optimal
        // int j = 0;
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            maxsum = Math.max(sum1, maxsum);
            if (sum1 < 0) {
                sum1 = 0;
            }
        }
        // follow up array from start to end
        sum1 = 0;
        int start = 0;
        int tempstart = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (sum1 == 0) {
                tempstart = i;
            }
            sum1 += nums[i];
            if (sum1 > maxsum) {
                maxsum = sum1;
                end = i;
                start = tempstart;
            }
            if (sum1 < 0) {
                sum1 = 0;
            }
        }

        return maxsum;
    }
}
