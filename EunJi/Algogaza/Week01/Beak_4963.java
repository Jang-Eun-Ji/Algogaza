package EunJi.Algogaza.Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_4963 {
    static int[] dx = {-1 , 0 , 1 , -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int wide = Integer.parseInt(str.nextToken());
            int height = Integer.parseInt(str.nextToken());
            if(wide == 0 && height == 0) break;


            int[][] land = new int[height][wide];
            boolean[][] visited = new boolean[height][wide];

            int answer = 0;

            for (int i = 0; i < height; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < wide; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < height; i++) {
                for (int j = 0; j < wide; j++) {
                    if(!visited[i][j] && land[i][j] == 1){
                        BFS(visited,land, new int[]{i,j}, wide, height);

                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void BFS(boolean[][] visited, int[][] land, int[] start, int wide, int height) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int[] nowXY = queue.poll();
            int nowY = nowXY[0];
            int nowX = nowXY[1];

           visited[nowY][nowX] = true;

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextY >= height || nextX < 0 || nextX >= wide || nextY < 0){
                    continue;
                }
                if (land[nextY][nextX] == 1 && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.add(new int[] {nextY, nextX});
                }
            }

        }
    }


}
