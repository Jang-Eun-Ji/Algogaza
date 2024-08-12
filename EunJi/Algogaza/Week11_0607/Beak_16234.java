package EunJi.Algogaza.Week11_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_16234 {
    static int N;
    static int min;
    static int max;
    static int[][] arr;
    static int day;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        List<List<int[]>> temp = check();

        while (!temp.isEmpty()){
            day++;
            movePeople(temp);
            temp = check();
        }
        System.out.println(day);

    }
    static List<List<int[]>> check(){ // 나라마다 바꿔야 하는게 있다면 bfs 호출 하며 day를 올림
        List<List<int[]>> list = new ArrayList<>(); // 연합의 큐를 넣어둘 배열들

        boolean[][] pass = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!pass[i][j]){ // 한번도 간적이 없다면
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});

                    pass[i][j] = true;

                    List<int[]> allList = new ArrayList<>();
                    allList.add(new int[]{i,j});


                    while (!q.isEmpty()){

                        int[] tempNow = q.poll();
                        int nowX = tempNow[0];
                        int nowY = tempNow[1];
//                        System.out.println("tempNow = " + Arrays.toString(tempNow));

                        for (int k = 0; k < 4; k++) { //
                            int nextX = nowX + dx[k];
                            int nextY = nowY + dy[k];

                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                                continue;
                            }
                            if(pass[nextX][nextY]) {
                                continue;
                            }

//                            System.out.println("hi" + nowX + " " + nowY + " ");
//                            System.out.println("hi" + nextX + " " + nextY + " ");

                            if(Math.abs(arr[nowX][nowY] - arr[nextX][nextY]) >= min  &&
                                    Math.abs(arr[nowX][nowY] - arr[nextX][nextY]) <= max){

                                pass[nextX][nextY] = true;
                                q.add(new int[]{nextX, nextY});
                                allList.add(new int[]{nextX, nextY});
                            }


                        }
                    }
                    if(allList.size() > 1){ // 위에서 1개만 담았는데 더 담겨 있다면
//                        System.out.println("hi");
                        list.add(allList);
                    }

                }
            }
        }
        return list;
    }

    static void movePeople(List<List<int[]>> moveLand){ //
        for (int i = 0; i < moveLand.size(); i++) {
            int tempAll = 0;
            int size = moveLand.get(i).size();
            for (int j = 0; j < size; j++) {

                int[] temp = moveLand.get(i).get(j);
                int tempX = temp[0];
                int tempY = temp[1];

                tempAll += arr[tempX][tempY];
            }

            for (int j = 0; j < size; j++) {

                int[] temp = moveLand.get(i).get(j);
                int tempX = temp[0];
                int tempY = temp[1];

                arr[tempX][tempY] = tempAll/size;
            }

        }
    }


}
