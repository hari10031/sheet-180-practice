
import java.util.Scanner;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int answer = findSingleElement(array);
        System.out.println(answer);

        scanner.close();
    }

    private static int findSingleElement(int[] nums) {
        // Write your solution here.
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        //bsearch
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        int low = 1;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((nums[mid] != nums[mid + 1]) && (nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }

        }
        return 0;
    }
}
