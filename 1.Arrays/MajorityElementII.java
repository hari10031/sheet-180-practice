
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElementII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        List<Integer> majorityElements = findMajorityElements(array);
        System.out.println(majorityElements);

        scanner.close();
    }

    private static List<Integer> findMajorityElements(int[] nums) {
        // Write your solution here.
        List<Integer> ans = new ArrayList<>();
        int ele1 = 0;
        int ele2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (ele2 != nums[i] && cnt1 == 0) {
                ele1 = nums[i];
                cnt1 = 1;
            } else if (ele1 != nums[i] && cnt2 == 0) {
                ele2 = nums[i];
                cnt2 = 1;
            } else if (nums[i] == ele1) {
                cnt1++;
            } else if (nums[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }

        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                cnt1++;
            }
            if (nums[i] == ele2) {
                cnt2++;
            }
        }
        int mini = n / 3;
        if (cnt1 >= mini) {
            ans.add(ele1);
        }
        if (cnt2 > mini && ele1 != ele2) {
            ans.add(ele2);
        }

        return ans;
    }
}
