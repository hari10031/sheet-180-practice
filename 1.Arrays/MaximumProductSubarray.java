
import java.util.Scanner;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        System.out.println(maxProductSubarray(array));

        scanner.close();
    }

    private static int maxProductSubarray(int[] nums) {
        // Write your solution here.
        //brute
        int maxproduct = 1;
        for (int i = 0; i < nums.length; i++) {
            int prd = 1;
            for (int j = i; j < nums.length; j++) {
                prd *= nums[j];
                maxproduct = Math.max(prd, maxproduct);
                if (prd == 0) {
                    break;
                }

            }

        }
        //better
        int maxprd = 1;
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - 1 - i];
            maxprd = Math.max(prefix, suffix);
        }

        return maxprd;
    }
}
