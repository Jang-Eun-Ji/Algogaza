package EunJi.Algogaza.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2606 {
    static int computer;
    static int computerLine;
    static int[][] computerCouple;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        computerLine = Integer.parseInt(br.readLine());

        computerCouple = new int[computerLine][2];

        visited = new boolean[computer + 1];

        for (int i = 0; i < computerLine; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            computerCouple[i][0] = Integer.parseInt(st.nextToken());
            computerCouple[i][1] = Integer.parseInt(st.nextToken());
        }
        virus(1);

        System.out.println(answer);

    }

    static void virus(int start){
        visited[start] = true;
        for (int i = 0; i < computerLine; i++) {
            if(computerCouple[i][0] == start && !visited[computerCouple[i][1]]){
                answer ++;
                virus(computerCouple[i][1]);
            }
            if(computerCouple[i][1] == start && !visited[computerCouple[i][0]]){
                answer ++;
                virus(computerCouple[i][0]);
            }
        }
    }
}
