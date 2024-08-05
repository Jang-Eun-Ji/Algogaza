package EunJi.Week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2293 {
    static int kind;
    static int total;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        kind = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        coin = new int[kind];
        for (int i = 0; i < kind; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }


        int[] dp = new int[total + 1];

        dp[0] = 1;

        for (int i = 0; i < kind; i++) {
            for (int j = 1; j < total + 1; j++) {
                if(j < coin[i]) continue;
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[total]);
    }


}
