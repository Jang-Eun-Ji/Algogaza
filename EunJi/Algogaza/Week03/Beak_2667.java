package EunJi.Algogaza.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Beak_2667 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static int size;

    static int[][] town;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        town = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String temp = br.readLine();
            for (int j = 0; j < size; j++) {
                town[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
        int[] temp = new int[625];

        int complex = 0; // 단지 수

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(town[i][j] == 1 && !visited[i][j]){
                    temp[complex] = BFS(new int[]{i,j});
                    complex++;
                }
            }
        }

        System.out.println(complex);
//        System.out.println("complex = " + complex);

        int[] houseComplex = new int[complex];

        for (int i = 0; i < complex; i++) {
            houseComplex[i] = temp[i];
//            System.out.println(houseComplex[i]);
        }

        Arrays.sort(houseComplex);

        for (int i = 0; i < complex; i++) {
            System.out.println(houseComplex[i]);
        }



    }

    static int BFS(int[] start){
//        System.out.println("HI");
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int houseCount = 1;
        while (!queue.isEmpty()){
            int[] nowXY = queue.poll();
            int nowX = nowXY[0];
            int nowY = nowXY[1];

//            visited[nowX][nowY] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >= size || nextX < 0 || nextY >= size || nextY < 0){
                    continue;
                }

                if(town[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    houseCount++;
                }
            }

        }
        return houseCount;
    }
}
