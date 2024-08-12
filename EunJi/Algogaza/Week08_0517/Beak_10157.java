package EunJi.Algogaza.Week08_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        int round = 0;
        int[] now = new int[] {0,0};
        boolean[] negative = new boolean[2];
        int tempX = 0;
        int tempY = 0;

        while (k >= 0){

            int temp = x -round - 1;

            if(round % 2 == 0){
                temp = y - round - 1;
            }
            if(k > temp){
                k = k - temp;
                if(!negative[round%2]){
                    now[round%2] = now[round%2] + temp;
                    negative[round%2] = true;
                }else {
                    now[round%2] = now[round%2] - temp;
                    negative[round%2] = true;
                }

            }

            round ++;
        }
    }
}
