
import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int answer = findLongestConsecutiveSequence(array);
        System.out.println(answer);

        scanner.close();
    }

    private static int findLongestConsecutiveSequence(int[] nums) {
        // Write your solution here.
        int maxi = 0;
        //brute
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cnt = 1;
            while (linearsearch(num + 1, nums) == true) {
                num++;
                cnt++;
            }
            maxi = Math.max(cnt, maxi);

        }
        //better
        Arrays.sort(nums);
        int lastsmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastsmaller) {
                cnt++;
                lastsmaller = nums[i];
            } else if (nums[i] - 1 != lastsmaller) {
                cnt = 1;
                lastsmaller = nums[i];

            }
            longest = Math.max(longest, cnt);
        }

        //optimal
        int logest1 = 1;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);

        }
        for (int it : st) {
            if (!st.contains(it - 1)) {
                cnt = 1;
                int x = it;
                while (st.contains(x + 1)) {
                    x++;
                    cnt++;
                }
                logest1 = Math.max(logest1, cnt);
            }
        }

        return longest;
    }

    private static boolean linearsearch(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }
}
