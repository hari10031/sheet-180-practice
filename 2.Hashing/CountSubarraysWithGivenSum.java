
import java.util.HashMap;
import java.util.Scanner;

public class CountSubarraysWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int answer = countSubarrays(array, k);
        System.out.println(answer);

        scanner.close();
    }

    private static int countSubarrays(int[] nums, int k) {
        // Write your solution here.
        //brute
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        //hashing
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int cnt1 = 0;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum - k;
            if (mpp.containsKey(rem)) {
                cnt1 += mpp.get(rem);
            }
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);

        }
        return 0;
    }
}
