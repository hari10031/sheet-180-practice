
import java.util.Scanner;

public class PeakElementII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        findPeakElement(matrix);
        scanner.close();
    }

    private static void findPeakElement(int[][] matrix) {
        // Write your solution here.
        //bsearch algo
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findmax(matrix, mid);
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            if (mid - 1 >= 0) {
                left = matrix[row][mid - 1];
            }
            if (mid + 1 < m) {
                left = matrix[row][mid + 1];
            }
            if (left < matrix[row][mid] && right < matrix[row][mid]) {
                return;
            } else if (left > matrix[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    private static int findmax(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > max) {
                idx = i;
                max = matrix[i][col];
            }
        }
        return idx;
    }
}
