package EunJi.Algogaza.Week10_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beak_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] multiple = new int[n + 1];

        multiple[0] = 0;
        multiple[1] = 1;

        for (int i = 2; i <= n; i++) {
            multiple[i] = multiple[i-1] + 1;
            for (int j = 1; i >= j*j; j++) {
                multiple[i] = Math.min( multiple[i], multiple[i - j*j] + 1);
            }
        }

        System.out.println(multiple[n]);
        
    }

}
