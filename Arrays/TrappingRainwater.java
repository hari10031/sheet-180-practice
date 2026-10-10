
import java.util.Scanner;

public class TrappingRainwater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] heights = new int[n];

        for (int index = 0; index < n; index++) {
            heights[index] = scanner.nextInt();
        }

        System.out.println(trappedWater(heights));

        scanner.close();
    }

    private static int trappedWater(int[] nums) {
        // Write your solution here.
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(prefix[i - 1], nums[i]);
            }
            if (n - 1 == n - i - 1) {
                suffix[n - i - 1] = nums[n - 1 - i];
            } else {
                suffix[n - i - 1] = Math.max(nums[n - 1 - i], suffix[n - i]);
            }

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.min(prefix[i], suffix[i]) - nums[i];
        }

        //reducing space complexity now
        int left = 0;
        int right = n - 1;
        int lmax = 0;
        int rmax = 0;
        int maxi = 0;
        while (left < right) {
            if (nums[left] <= nums[right]) {
                if (lmax > nums[left]) {
                    maxi += lmax - nums[left];
                } else {

                    lmax = nums[left];
                }
                left++;
            } else {
                if (rmax > nums[right]) {
                    maxi += rmax - nums[right];
                } else {
                    rmax = nums[right];
                }
                right--;
            }
        }
        return maxi;
    }
}
