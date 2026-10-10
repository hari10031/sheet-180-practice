
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        List<List<Integer>> triplets = findThreeSum(array);
        System.out.println(triplets);

        scanner.close();
    }

    private static List<List<Integer>> findThreeSum(int[] nums) {
        // Write your solution here.
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        //brute
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        ans.add(temp);

                    }
                }
            }
        }
        //using hashset
        List<List<Integer>> ans1 = new ArrayList<>(ans);

        Set<List<Integer>> ans2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int thrid = -(nums[i] + nums[j]);
                if (hashset.contains(thrid)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(thrid);
                    Collections.sort(temp);
                    ans2.add(temp);

                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> ans3 = new ArrayList<>(ans2);

        //optimal
        Arrays.sort(nums);
        Set<List<Integer>> ans4 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    Collections.sort(temp);
                    ans4.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans1;
    }
}
