import java.util.Scanner;

public class MajorityElementI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            array[index] = scanner.nextInt();
        }

        int majorityElement = findMajorityElement(array);
        System.out.println(majorityElement);

        scanner.close();
    }

    private static int findMajorityElement(int[] array) {
        // Write your solution here.
        int cnt = 0;
        int ele = 0;
        for (int i = 0; i < array.length; i++) {
            if (cnt == 0) {
                ele = array[i];
                cnt = 1;
            }else if(ele != array[i]){
                cnt--;
            }else{
                cnt++;
            }
        }
        int cnt1= 0;
        for(int i =0;i<array.length;i++){
            if(array[i]==ele) cnt1++;
        }
        if(cnt1 > (array.length/2)) return ele;
        return -1;
    }
}
