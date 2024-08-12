package EunJi.Algogaza.Week11_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_17071 {

    static int soo;
    static int sister;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        soo = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());


        arr = new int[2][500001];
        Arrays.fill(arr[0], -1);
        Arrays.fill(arr[1], -1);

        if(soo == sister){
            System.out.println(0);
        } else {
            System.out.println(bfs(soo));
        }

    }

    static int bfs(int start){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        int seconds = 0;
        int doubleTime = 0;
        int qSize = 0;

        while (!q.isEmpty()){
            qSize = q.size();
            seconds++;
            doubleTime = seconds%2;

            for (int i = 0; i < qSize; i++) { // 큐의 사이즈만큼 돈다 == 그 초에 있는 큐를 여기서 다 돈다

                int temp = q.poll();
                int[] sooWalk = new int[]{temp -1, temp + 1, temp * 2};
                for (int j = 0; j < 3; j++) {
                    if(sooWalk[j] >= 0 && sooWalk[j] <= 500000 && arr[doubleTime][sooWalk[j]] == -1){
                        q.add(sooWalk[j]);
//                        System.out.println("sooWalk = " + sooWalk[j]);
                        arr[doubleTime][sooWalk[j]] = seconds;
                    }
                }
            }
            int tempSister = sister + (seconds * (seconds + 1) /2);
//            System.out.println("tempSister = " + tempSister);

            if(tempSister > 500000 ) {
//                System.out.println("크기가 크다");
                break;
            }
            if(arr[doubleTime][tempSister] != -1 ) {
//                System.out.println("tempSister = " + tempSister);
                return seconds;
            }

        }
        return -1;

    }

}
