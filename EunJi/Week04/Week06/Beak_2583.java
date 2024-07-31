package EunJi.Week04.Week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2583 {
    static List<int[]> arr = new ArrayList<>();
    static int y;
    static int x;
    static int k;
    static boolean[][] pass;
    static int answer;
    static List<Integer> answerSize = new ArrayList<>();

    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[] {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());

        int[][] rectangle = new int[k][4];
        for (int i = 0; i < k; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            rectangle[i][0] = Integer.parseInt(str.nextToken());
            rectangle[i][1] = Integer.parseInt(str.nextToken());
            rectangle[i][2] = Integer.parseInt(str.nextToken());
            rectangle[i][3] = Integer.parseInt(str.nextToken());
        }

        pass = new boolean[x][y]; // 여기를 지나거나 색칠된 곳이면 true, 아니면 true

        for (int i = 0; i < k; i++) {
            // 모든 차있는 직사각형의 왼쪽 아래의 꼭짓점을 배열에 넣기
            for (int j = rectangle[i][0]; j <rectangle[i][2]; j++) { //x 축의
                for (int l = rectangle[i][1]; l < rectangle[i][3]; l++) { //y축을 1씩 더해가며 추가
                    pass[j][l] = true;
                }
            }
        }
        System.out.println("pass = " + Arrays.deepToString(pass));

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(!pass[i][j]){
                    answerSize.add(checkEmpty(new int[] {i,j}));
                    answer++;
                }
            }
        }
        System.out.println("answerSize = " + answerSize);
        System.out.println("answer = " + answer);
    }

    static int checkEmpty (int[] start){
        Queue<int[]> queue = new LinkedList<>();
        int size = 1;
        queue.add(start);
        while (queue.isEmpty()){
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = temp[0] + dx[i];
                int nextY = temp[0] + dy[i];

                if(nextX < 0 || nextX >= x || nextY <0 || nextY >=y) continue;
                if(pass[nextX][nextY]) continue;

                size++;
                queue.add(new int[]{nextX, nextY});
            }
        }
        return size;
    }

}
