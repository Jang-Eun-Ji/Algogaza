package EunJi.Step.Step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Beak_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringNum = br.readLine();
        int size = stringNum.length();

        int[] arr = new int[size];

        int num = Integer.parseInt(stringNum);

        for (int i = 0; i < size; i++) {
            arr[i] = num%10;
            num /= 10;
        }
//        System.out.println("num = " + Arrays.toString(arr));


        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if(arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int temp : arr) {
            System.out.print(temp);
        }
    }
}
