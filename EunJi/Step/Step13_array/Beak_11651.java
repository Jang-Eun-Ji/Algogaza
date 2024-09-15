package EunJi.Step.Step13_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dot = Integer.parseInt(br.readLine());
        int[][] spot = new int[dot][2];

        for (int i = 0; i < dot; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            spot[i][0] = Integer.parseInt(st.nextToken());
            spot[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] streamArr = Arrays.stream(spot)
                .sorted((a, b) -> {
                    if (a[1] == b[1]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(a[1], b[1]);
                    }
                }).toArray(int[][]::new);

        for (int i = 0; i < dot; i++) {
            sb.append(streamArr[i][0]).append(" ").append(streamArr[i][1]).append("\n");
        }

        System.out.println(sb);
        System.out.println("숫자 비교" + Integer.compare(3, 2));
    }
}
