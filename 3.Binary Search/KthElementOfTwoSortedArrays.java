
import java.util.Scanner;

public class KthElementOfTwoSortedArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] first = new int[n];
        int[] second = new int[m];

        for (int i = 0; i < n; i++) {
            first[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            second[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        findKthElement(first, second, k);
        scanner.close();
    }

    private static void findKthElement(int[] a, int[] b, int k) {
        // Write your solution here.
        //brute
        int i = 0, j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            int val;

            if (a[i] <= b[j]) {
                val = a[i];
                i++;
            } else {
                val = b[j];
                j++;
            }

            count++;

            if (count == k) {
                return;
            }
        }
        while (i < a.length) {
            count++;
            if (count == k) {
                return;
            }
            i++;
        }
        while (j < b.length) {
            count++;
            if (count == k) {
                return;
            }
            j++;
        }
        //optimal bsearch
        int m = a.length;
        int n = b.length;
        if (m > n) {
            return findKthElement(b, a, k);
        }
        int left = k;
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

    }
}
