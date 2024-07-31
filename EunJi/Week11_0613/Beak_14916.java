package EunJi.Week11_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] arr = new int[money + 1];


        if(money <= 5) {
            if(money%2 == 0){
                System.out.println(money/2);
            }else if(money == 5) {
                System.out.println(1);
            }else {
                System.out.println(-1);
            }
        }else {
            arr[0] = 0;
            arr[2] = 1;
            arr[4] = 2;
            arr[5] = 1;
            for (int i = 6; i <= money; i++) {
                int temp2 = arr[i -2];
                int temp5 = arr[i -5];
                if(temp2 == 0 && temp5 == 0){
                    arr[i] = -1;
                }else if(temp2 == 0){
                    arr[i] = temp5 + 1;
                }else if(temp5 == 0){
                    arr[i] = temp2 + 1;
                }else {
                    arr[i] = Math.min(temp5, temp2) + 1;
                }
            }

            System.out.println(arr[money]);

        }


    }
}
