package EunJi.Week08_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Beak_9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);


        int compare = 0;
        for (int i = 0; i < n; i++) {
            if(compare < tree[i] - i){
                compare = tree[i] - i;
            }
        }

        System.out.println(compare + n + 1);
    }
}
