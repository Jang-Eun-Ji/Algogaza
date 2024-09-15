package EunJi.Step.Step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2563 {
    static boolean[][] color;
    static int[][] arr;
    static int rectangle;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rectangle = Integer.parseInt(br.readLine());
        arr = new int[rectangle][2];
        color = new boolean[100][100];

        answer = rectangle * 100;
        for (int i = 0; i < rectangle; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            setColor(arr[i][0], arr[i][1]);
        }

        System.out.println(answer);

    }
    static void setColor(int x, int y){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(color[x +i][y+j]) answer --;
                else color[x + i][y + j] = true;
            }
        }
    }
}
