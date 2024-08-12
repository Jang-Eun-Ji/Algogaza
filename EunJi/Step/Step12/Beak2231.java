package EunJi.Step.Step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int N = Integer.parseInt(num);

        int min = N - (9*num.length());
        int answer = 0;


        for (int i = min; i < N; i++) {
            int sum = 0;
            int temp = i;

            while (temp != 0){
                sum += temp % 10;
                temp/= 10;

            }
            if(sum + i == N) {
                answer = i;
                break;
            }

        }

        System.out.println(answer);
    }
}
