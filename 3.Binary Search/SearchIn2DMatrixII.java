
import java.util.Scanner;

public class SearchIn2DMatrixII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        //  matrix = 
        // [ 
        //     [1, 4, 7, 11, 15], 
        //     [2, 5, 8, 12, 19], 
        //     [3, 6, 9, 16, 22], 
        //     [10, 13, 14, 17, 24], 
        //     [18, 21, 23, 26, 30] 
        // ]
        // You are given a matrix where:

        // Each row is sorted in ascending order.
        // Each column is sorted in ascending order.
        int target = scanner.nextInt();
        boolean answer = searchMatrix(matrix, target);
        System.out.println(answer);

        scanner.close();
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        // Write your solution here.
        //lserach
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        //bseearch
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true; 
            }else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
