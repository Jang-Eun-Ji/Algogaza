package EunJi.Algogaza.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_1012 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static int wide;
    static int height;
    static int cabbage;
    static int[][] cabbageLocation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wide = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());

            cabbageLocation = new int[wide][height];

            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbageLocation[x][y] = 1;
            }



            boolean[][] visited = new boolean[wide][height];
            int answer = 0;

            for (int k = 0; k < wide; k++) {
                for (int j = 0; j < height; j++) {
                    if(cabbageLocation[k][j] == 1 && !visited[k][j]){
                        answer++;
                        BFS(new int[]{k,j}, visited);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void BFS(int[] start, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){

            int[] tempXY = queue.poll();
            int x = tempXY[0];
            int y = tempXY[1];
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= wide || nextX < 0 || nextY >= height || nextY < 0){
                    continue;
                }
                if(cabbageLocation[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }

        }
    }
}
