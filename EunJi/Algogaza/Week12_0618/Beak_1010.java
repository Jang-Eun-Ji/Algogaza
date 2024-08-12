package EunJi.Algogaza.Week12_0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());



            int mother = 1;
            int son = 1;
            for (int j = 0; j < M - N; j++) {
                mother *= M - j;
            }
            for (int j = 1; j <= M - N; j++) {
                son *= j;
            }

            System.out.println("mother = " + mother);
            System.out.println("son = " + son);

            System.out.println(mother/son);


//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
        }


    }
}
