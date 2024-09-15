package EunJi.Step.Step32_ShortestWay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        int[][] map = new int[node + 1][node + 1];
        int shortCount = Integer.MAX_VALUE;
        int shortNum;
        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int startTemp = Integer.parseInt(str.nextToken());
            int finishTemp = Integer.parseInt(str.nextToken());
            map[startTemp][finishTemp] = Integer.parseInt(str.nextToken());

            if(startTemp == startNode && shortCount > map[startTemp][finishTemp]){
                shortCount = map[startTemp][finishTemp];
                shortNum = finishTemp;
            }

        }

        System.out.println("map = " + Arrays.deepToString(map));



    }
}
