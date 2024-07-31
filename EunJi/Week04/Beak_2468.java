package EunJi.Week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2468 {
    static int[][] ground;
    static int n;
    static int [] dx = new int[] {1, 0, -1, 0};
    static int [] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int biggest = 0;
        ground = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(biggest < ground[i][j]) biggest = ground[i][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < biggest; i++) {
            int temp = countGround(i);
//            if(temp > (n*n)/2){
//                answer = temp;
//                break;
//            }
            if(temp > answer) answer = temp;
        }
        System.out.println(answer);
    }
    static int countGround(int rain){

        int answer = 0;
        boolean[][] sink = new boolean[n][n];
        boolean[][] pass = new boolean[n][n];
        for (int i = 0; i < n; i++) { //  가라앉지 않은 땅을 표시함
            for (int j = 0; j < n; j++) {
                if(ground[i][j] > rain){
                    sink[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sink[i][j] && !pass[i][j]){
                    answer++;
                    checkSink(new int[]{i,j}, sink, pass);
                }
            }
        }

        return answer;
    }
    static void checkSink(int[] node, boolean[][] sink, boolean[][] pass){
        pass[node[0]][node[1]] = true;
        for (int i = 0; i < 4; i++) {
            int tempX = node[0] + dx[i];
            int tempY = node[1] + dy[i];
            int[] nextNode = new int[]{tempX, tempY};
            if(tempX > n -1 || tempX < 0 || tempY > n -1 || tempY < 0) continue;
            if(sink[tempX][tempY] && !pass[tempX][tempY]){
                checkSink(nextNode, sink, pass);
            }
        }
    }
}
