package EunJi.Step.Step13_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] numArr = new int[5];
        int avg = 0;
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(br.readLine());
            numArr[i] = temp;
            avg+= temp;
        }
        Arrays.sort(numArr);
//        System.out.println("numArr = " + Arrays.toString(numArr));
        System.out.println(avg/5);
        System.out.println(numArr[2]);


    }
}
