package EunJi.Step.Step13_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dot = Integer.parseInt(br.readLine());

        int[][] arr = new int[dot][2];
        for (int i = 0; i < dot; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] sortedArr = Arrays.stream(arr)
                .sorted((a,b) -> {
                    if(a[0] == b[0]){
                        return Integer.compare(a[1], b[1]);
                    }else {
                        return Integer.compare(a[0], b[0]);
                    }
                })
                .toArray(int[][] :: new);

        for (int[] temp : sortedArr) {
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }

        System.out.println(sb);
    }
}
