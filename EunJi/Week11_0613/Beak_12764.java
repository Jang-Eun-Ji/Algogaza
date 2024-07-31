package EunJi.Week11_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_12764 {
    public static void main(String[] args) throws IOException {
        // 맵에 사람마다 들어오는 시간 +1 나가는 시간 -1을 입력한다
        // 컴수보다 + 1인 사람의 수가 더 많다면 컴의 숫자를 늘리고 arrayList에 늘어난 컴을 입력하고 숫자를 더한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());

        int[] computerArr = new int[people];
        int temp = 0;
        HashMap<Integer, Integer> come = new HashMap<>(); // 들어올때마다 +1
        HashMap<Integer, Integer> out = new HashMap<>(); // 나갈때 마다 -1

        List<Integer> timeScript = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempCome = Integer.parseInt(st.nextToken());
            int tempOut = Integer.parseInt(st.nextToken());

            come.put(tempCome, tempOut);
            out.put(tempOut, tempCome);
            timeScript.add(tempCome);
            timeScript.add(tempOut);
        }

        timeScript.sort(Comparator.naturalOrder()); // 오고 나가는 시간
//        System.out.println("timeScript = " + timeScript);
        int computer = 0;
        int nowComputerUser = 0;
        List<int[]> computerUser = new ArrayList<>();
        // index는 컴의 번호, int[0] 기록용,int[1]은 come의 value값, 현재 없으면 -1
        // 만약에 out의 키값이 computerUser의 int[1]값이면

//        HashMap<Integer,Integer> computerUser = new HashMap<>(); // 키는 종료시간, 값은 기록용
        for (int i = 0; i < timeScript.size(); i++) {
            if(come.containsKey(timeScript.get(i))){
                nowComputerUser++;
                if(computer < nowComputerUser){
                    computer++;
                    computerUser.add(new int[]{1, come.get(timeScript.get(i))});

                }else {

                    for (int j = 0; j < computerUser.size(); j++) {
                        if(computerUser.get(j)[1] == -1){
                            computerUser.get(j)[1] = timeScript.get(i);
                            computerUser.get(j)[0] = computerUser.get(j)[0] + 1;

                            break;
                        }
                    }
                }
            }else {
                nowComputerUser--;
                for (int j = 0; j < computerUser.size(); j++) {
                    if(computerUser.get(j)[1] == timeScript.get(i)){
                        computerUser.get(j)[1] = -1;
                        break;
                    }
                }
            }

        }

//        System.out.println(computer);
//        for (int[] temp : computerUser) {
//            System.out.print(temp[0] + " ");
//        }

    }

}
