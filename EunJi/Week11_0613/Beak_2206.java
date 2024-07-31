package EunJi.Week11_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2206 {
    static int x;
    static int y;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] arr;
//    static int[][][] countArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[y][x];
//        int[][][] countArr = new int[y][x][2]; // 0이면 안부순거로 , 1이면 부순거로

//        boolean[][] pass = new boolean[y][x];
        List<int[]> oneCount = new ArrayList<>(); // 1이 담겨있는 리스트

        for (int i = 0; i < y; i++) {
            String temp = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        if(x == 1 && y == 1){
            System.out.println(1);
        }else {
            System.out.println(bfs());

        }


    }

    static int bfs() { // crushNumber와 같은것만 부신다
        int[][][] countArr = new int[y][x][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        countArr[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] nowXY = q.poll();
            int nowY = nowXY[0];
            int nowX = nowXY[1];
            int broken = nowXY[2];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    continue;
                }

                if (arr[nextY][nextX] == 0 && countArr[nextY][nextX][broken] == 0) {
                    countArr[nextY][nextX][broken] = countArr[nowY][nowX][broken] + 1;
                    q.add(new int[]{nextY, nextX, broken});
                }

//                if (arr[nextY][nextX] > 0) { // 이미 값이 있다면 더 작은 절댓값의 음수로 변경
//                    if (countArr[nextY][nextX][broken] > countArr[nowY][nowX][broken] + 1) {
//                        countArr[nextY][nextX][broken] = countArr[nowY][nowX][broken] + 1;
//                        q.add(new int[]{nextY, nextX, broken});
//                    }
//
//                }

                if (arr[nextY][nextX] == 1 && broken == 0 && countArr[nextY][nextX][1] == 0) { // 벽을 볼때마다 확인
                    countArr[nextY][nextX][1] = countArr[nowY][nowX][0] + 1;
                    q.add(new int[]{nextY, nextX, 1});
                }
            }


        }

        int answer0 = countArr[y-1][x-1][0];
        int answer1 = countArr[y-1][x-1][1];

        if(answer0 == 0 && answer1== 0){
            return -1;
        }else if(answer0 == 0){
            return answer1;
        }else if (answer1 == 0){
            return answer0;
        }else {
            return Math.min(answer0, answer1);
        }
    }
}
