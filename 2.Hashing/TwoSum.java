
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        int[] answer = findTwoSum(array, target);

        System.out.println(answer[0] + " " + answer[1]);

        scanner.close();
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (values.containsKey(rem)) {
                return new int[]{values.get(rem), i};
            }
            values.put(nums[i], i);
        }

        // Write your solution here.
        return new int[]{-1, -1};
    }
}
