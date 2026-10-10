
import java.util.HashMap;
import java.util.Scanner;

public class CountSubarraysWithGivenXOR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int answer = countSubarraysWithXor(array, k);
        System.out.println(answer);

        scanner.close();
    }

    private static int countSubarraysWithXor(int[] nums, int k) {
        // Write your solution here.
        //brute
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int xor = 0;
            for (int j = i; j < nums.length; j++) {
                xor ^= nums[j];
                if (xor == k) {
                    cnt++;
                }
            }
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int xor = 0;
        cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            int rem = xor ^ k;
            if (mpp.containsKey(rem)) {
                cnt += mpp.get(rem);
            }
            mpp.put(xor, mpp.getOrDefault(xor, 0) + 1);
        }
        return cnt;
    }
}
