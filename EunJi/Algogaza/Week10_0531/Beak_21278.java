package EunJi.Algogaza.Week10_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_21278 {
    static int[][] arr;
    static int node;
    static int line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];


        for (int i = 1; i < node + 1; i++) {
            for (int j = 1; j < node + 1; j++) {
                if(i == j) arr[i][j] = 0;
                else {
                    arr[i][j] = 1000;
                }
            }
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(str.nextToken());
            int temp2 = Integer.parseInt(str.nextToken());

            arr[temp1][temp2] = arr[temp2][temp1] = 1;
        }/// 바로 연결된것을 1로

//        System.out.println("arr = " + Arrays.deepToString(arr));

        for (int i = 1; i < node + 1; i++) {
            for (int j = 1; j < node + 1; j++) {
                if(i == j) continue;
                for (int k = 1; k < node + 1; k++) {
                    if(i == k || j == k) continue;
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        int MinSum = Integer.MAX_VALUE;
        int chicken1 = 0;
        int chicken2 = 0;

        for (int i = 1; i < node; i++) { // 1번 치킨집

            for (int j = i + 1; j < node + 1; j++) { // 2번 치킨집
                int temp = 0;
                for (int k = 0; k < node + 1; k++) { // 비교할 노드들
                    if(i == k || j == k) continue;
                    if(arr[i][k] > arr[j][k]){
                        temp += arr[j][k];
                    }else {
                        temp += arr[i][k];
                    }
                }
                temp = temp *2;

                if(MinSum > temp){
                    chicken1 = i;
                    chicken2 = j;
                    MinSum = temp;
                }
            }

        }
        System.out.print(chicken1 + " ");
        System.out.print(chicken2 + " ");
        System.out.println(MinSum);


    }

}
