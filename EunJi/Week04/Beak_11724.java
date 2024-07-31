package EunJi.Week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_11724 {
    static boolean[] pass;
//    static int[][] arr;
    static int node;
    static int line;
    static int answer = 0;
    static int[][] nodeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

//        arr = new int[line][2];

        nodeArr = new int[node + 1][node + 1];
        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(str.nextToken());
            int temp2 = Integer.parseInt(str.nextToken());
//            arr[i][0] = temp1;
//            arr[i][1] = temp2;
            nodeArr[temp1][temp2] = nodeArr[temp2][temp1] = 1;

        }
        pass = new boolean[node + 1];

        for (int i = 1; i < node + 1; i++) {
            if(!pass[i]){
                dfs(i);
                answer ++;
            }
        }
        System.out.println(answer);
    }
    static void dfs(int start){
        pass[start] = true;
        for (int i = 0; i <= node; i++) {
            if(nodeArr[start][i] == 1 && !pass[i]){
                dfs(i);
            }
        }
    }

}
