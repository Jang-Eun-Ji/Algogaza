package EunJi.Algogaza.Week11_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_3190 {
    // 뱀의 길이를 temp로 두고 사과를 먹으면 temp의 길이가 1씩 늘어가고,
    // Queue에서 만약 매초마다 다음 땅을 담고 temp의 크기보다 크기가 커지면 1개씩 뺀다
    // 여기서 다음 땅을 담을때 Queue랑 같은 값이 있는지 확인하고 같은 값이 있다면 현재의 초를 리턴한다
    // 여기서 다음 땅을 담을때 사과랑 같은지도 확인하기

    // 0 : -왼쪽 i = 3, 오른쪽 i = 1
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    static HashMap<Integer, Integer> turnMap;
    static List<int[]> appleArr;
    static int apple;
    static int world;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        world = Integer.parseInt(br.readLine());

        apple = Integer.parseInt(br.readLine());

        appleArr = new ArrayList<>();
        for (int i = 0; i < apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            appleArr.add(new int[]{temp2,temp1});
        }


        int turn = Integer.parseInt(br.readLine());
        turnMap = new HashMap<>();
        for (int i = 0; i < turn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int tempTurn = 1; // 오른쪽이면 dx,dy에서  + 1
            if(st.nextToken().equals("L")){ // 만약 왼쪽 이면 -1 이다
                tempTurn = -1;
            }
            turnMap.put(temp,tempTurn);
        }

        System.out.println(snack());
    }
    static int snack (){
        int seconds = 0;

        int snackSize = 1;
        Deque<int[]> snackGround = new ArrayDeque<>();
        snackGround.addFirst(new int[]{1,1});
        // 값이 1보다 작거나 world보다 크거나, 큐에 같은 값이 있을때 break
        int way = 2; // 처음은 오른쪽인 i가 2일때 시작한다.
        while (true){
            int[] snackHead = snackGround.peekFirst();

            seconds ++;

            int HeadX = snackHead[0];
            int HeadY = snackHead[1];
            int nextX = HeadX + dx[way];
            int nextY = HeadY + dy[way];


            if(nextX < 1 || nextX > world || nextY < 1 || nextY > world) {
                return seconds;
            }
//            System.out.println("HeadX = " + HeadX);
//            System.out.println("HeadY = " + HeadY);
//            System.out.println("nextX = " + nextX);
//            System.out.println("nextY = " + nextY);

            for(int[] temp : appleArr){
                if(temp[0] == nextX && temp[1] == nextY){
                    snackSize ++;
                    appleArr.remove(temp);
                    break;
                }
            }
            for(int[] temp : snackGround){
                if(temp[0] == nextX && temp[1] == nextY) return seconds;
            }

            if(snackGround.size() > snackSize - 1){ // 넣기 전에 먼저 제거한다.
                snackGround.removeLast();
            }


            snackGround.addFirst(new int[] {nextX, nextY});

//            System.out.println("nextX = " + nextX);
//            System.out.println("nextY = " + nextY);
//            for (int[] temp : snackGround){
//                System.out.println("temp = " + Arrays.toString(temp));
//            }

            if(turnMap.containsKey(seconds)){ // 방향을 틀기
                way = way + turnMap.get(seconds);

                if(way > 3) way = 0;
                if(way < 0) way = 3;

            }

        }


    }

}
