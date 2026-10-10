
import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstLength = scanner.nextInt();
        int[] firstArray = new int[firstLength];
        for (int index = 0; index < firstLength; index++) {
            firstArray[index] = scanner.nextInt();
        }

        int secondLength = scanner.nextInt();
        int[] secondArray = new int[secondLength];
        for (int index = 0; index < secondLength; index++) {
            secondArray[index] = scanner.nextInt();
        }

        mergeArrays(firstArray, secondArray);

        for (int value : firstArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int value : secondArray) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    private static void mergeArrays(int[] firstArray, int[] secondArray) {
        // Write your solution here without using extra arrays.
        //brute
        int[] temp = new int[firstArray.length + secondArray.length];
        int left = 0;
        int right = 0;
        int idx = 0;
        while (left < firstArray.length && right < secondArray.length) {
            if (firstArray[left] <= secondArray[right]) {
                temp[idx++] = firstArray[left++];
            } else {
                temp[idx++] = secondArray[right++];
            }
        }
        while (left < firstArray.length) {
            temp[idx++] = firstArray[left++];
        }
        while (right < secondArray.length) {
            temp[idx++] = secondArray[right++];
        }
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = temp[i];
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = temp[firstArray.length + i];
        }
        //second approach
        int lt = firstArray.length - 1;
        int rt = 0;
        while (lt >= 0 && rt < secondArray.length) {
            if (firstArray[lt] > secondArray[rt]) {
                int temp1 = firstArray[lt];
                firstArray[lt] = secondArray[rt];
                secondArray[rt] = temp1;
                lt--;
                rt++;

            } else {
                break;
            }
        }

        // Arrays.sort(firstArray);
        // Arrays.sort(secondArray);
        //shell sort
        int n = firstArray.length;
        int m = secondArray.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int l1 = 0;
            int r1 = l1 + gap;
            while (r1 < len) {
                if (l1 < n && r1 >= n) {
                    if (firstArray[l1] > secondArray[r1 - n]) {
                        int t1 = firstArray[l1];
                        firstArray[l1] = secondArray[r1 - n];
                        secondArray[r1 - n] = t1;
                    }
                } else if (l1 >= n) {
                    if (secondArray[l1 - n] > secondArray[r1 - n]) {
                        int t1 = secondArray[l1 - n];
                        secondArray[l1 - n] = secondArray[r1 - n];
                        secondArray[r1 - n] = t1;
                    }

                } else {
                    if (firstArray[l1] > firstArray[r1]) {
                        int t1 = firstArray[l1];
                        firstArray[l1] = firstArray[r1];
                        firstArray[r1] = t1;
                    }

                }
                l1++;
                r1++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);

        }

    }
}
