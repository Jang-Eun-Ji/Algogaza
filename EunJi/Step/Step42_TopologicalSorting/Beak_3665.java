package EunJi.Step.Step42_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_3665 {
    // 작년 입력을 받고 수정된것에서 원래 높았던 숫자에 추가를 하고 원래 낮았던 것은 높았던 숫자가 있다면 삭제하기
    // 5 -   ->
    // 4 - 5 -> 2, 5 ,3
    // 3 - 5, 4 -> 5
    // 2 - 5, 4, 3 -> 5, 3
    // 1-  5, 4, 3, 2

    // 불가능한 경우 q가 채워지지 않거나 결과값이 팀의 수만큼 안나오면
    // 1 -  -> 2
    // 2 - 1 -> 3
    // 3 - 1, 2  -> 1, 4
    // 4 - 1, 2, 3 -> 1, 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringBuilder sb = new StringBuilder();
            int team = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] rank = new int[team];
            HashMap<Integer, ArrayList<Integer>> priority = new HashMap<>();
            for (int j = 0; j < team; j++) {
                rank[j] = Integer.parseInt(st.nextToken());

                ArrayList<Integer> temp = new ArrayList<>();
                if(j != 0){
                    for (int k = 0; k < j; k++) {
                        temp.add(rank[k]);
                    }
                }
                priority.put(rank[j], temp);
            }


            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < change; j++) {
                st = new StringTokenizer(br.readLine());
                int pastHigh = Integer.parseInt(st.nextToken());
                int pastLow = Integer.parseInt(st.nextToken());

                int hightIndex = 0;
                int lowIndex = 0;
                for (int k = 0; k < team; k++) {
                    if(rank[k] == pastHigh) hightIndex = k;
                    if(rank[k] == pastLow) lowIndex = k;
                }
                if(hightIndex < lowIndex) {
                    int temp = pastHigh;
                    pastHigh = pastLow;
                    pastLow = temp;
                }
                // 인덱스 순으로 pastLow가 인덱스가 낮은것 그러니 과거 높은 순위 인것이다.
//                System.out.println("pastLow = " + pastLow);
//                System.out.println("pastHigh = " + pastHigh);

                ArrayList<Integer> tempList = priority.get(pastLow);

                tempList.add(pastHigh);
                priority.put(pastLow, tempList);

                tempList = priority.get(pastHigh);

                if(tempList.contains(pastLow)) {
                    Object tempLow = (Object) pastLow;
                    tempList.remove(tempLow);
                    priority.put(pastHigh, tempList);
                }

            }
//            System.out.println("순서 변경 priority = " + priority);

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j <= team; j++) {
                if(priority.get(j).isEmpty()){
                    queue.add(j);
                }
            }
            if(queue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            int conutTeam = 0;

            while (!queue.isEmpty()){
                int temp = queue.poll();
                conutTeam++;
                sb.append(temp).append(" ");

                for (int j = 1; j <= team ; j++) {
                    if(temp == j) continue;
                    if(priority.get(j).contains(temp)){
                        ArrayList<Integer> arr = priority.get(j);
                        Object obTemp = (Object)temp;
                        arr.remove(obTemp);
                        priority.put(j,arr);

                        if(arr.isEmpty()) queue.add(j);
                    }

                }
            }
            if(conutTeam != team) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println(sb);

        }

    }

}
