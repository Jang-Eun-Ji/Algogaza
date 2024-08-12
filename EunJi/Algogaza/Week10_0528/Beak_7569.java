package EunJi.Algogaza.Week10_0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_7569 {
    static int X;
    static int Y;
    static int Z;

    static int[][][] tomato;

    static int[] dz = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dx = {0, 0, 1, 0, 0, -1};

    static int answer = 0;
    static boolean[][][] pass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        X = Integer.parseInt(str.nextToken());
        Y = Integer.parseInt(str.nextToken());
        Z = Integer.parseInt(str.nextToken());

        tomato = new int[Z][Y][X];

        pass = new boolean[Z][Y][X];

        int badTomato = 0;

        List<int[]> goodList = new ArrayList<>();
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < X; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    tomato[i][j][k] = temp;
                    if (temp == 1) {
                        goodList.add(new int[]{i,j,k}); // x, y, z 순서
                    }
                    if(temp == 0) badTomato++;
                }
            }
        }

        if(badTomato > 0) setTomato(goodList);

        loop:
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if(tomato[i][j][k] == 0) {
                        answer = -1;
                        break loop;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void setTomato(List<int[]> goodList) {

        List<int[]> nextGoodList = new ArrayList<>();

        for (int[] temp : goodList) {
//            System.out.println("현재 1인것" + Arrays.toString(temp));

            int x = temp[2];
            int y = temp[1];
            int z = temp[0];

            pass[z][y][x] = true;

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (nextZ >= Z || nextZ < 0 || nextY >= Y || nextY < 0 || nextX >= X || nextX < 0){
                    continue;
                }

                if (pass[nextZ][nextY][nextX]) {
                    continue;
                }

                if (tomato[nextZ][nextY][nextX] == 0) {
                    pass[nextZ][nextY][nextX] = true;
                    tomato[nextZ][nextY][nextX] = 1;
                    nextGoodList.add(new int[]{nextZ,nextY, nextX});
                }
            }
        }
        if(!nextGoodList.isEmpty()){
            answer ++;
            setTomato(nextGoodList);
        }

    }


}
