
import java.util.Scanner;

public class KokoEatingBananas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }

        int hours = scanner.nextInt();
        minEatingSpeed(piles, hours);
        scanner.close();
    }

    private static void minEatingSpeed(int[] piles, int hours) {
        // Write your solution here.
        //linear serach
        int maxi = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        for (int i = 1; i <= maxi; i++) {
            int total = 0;
            for (int j = 0; j < piles.length; j++) {
                total += Math.ceil(piles[j] / i);
            }
            if (total <= hours) {
                mini = total;
                break;
            }
        }
        //bsearch
        int ans = 0;
        int low = 0;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalh = eat(piles, mid);
            if (totalh <= hours) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
    }

    private static int eat(int[] piles, int h) {
        int total = 0;
        for (int j = 0; j < piles.length; j++) {
            total += Math.ceil(piles[j] / h);
        }
        return total;
    }
}
