package EunJi.Step.Step13_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[people];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < people; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[people - k]);
    }
}
