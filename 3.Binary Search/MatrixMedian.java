
import java.util.Scanner;

public class MatrixMedian {

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

        findMedian(matrix);
        scanner.close();
    }

    private static void findMedian(int[][] matrix) {
        // Write your solution here.
        //brute
        int n = matrix.length;
        int m = matrix[0].length;
        int[] mat = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i + j] = matrix[i][j];
            }

        }
        int med = mat[(n * m) / 2];
        //bserach

    }
}
