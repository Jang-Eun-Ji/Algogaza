package EunJi.Step.Step42_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int compare = Integer.parseInt(st.nextToken());

        int[][] compareArr = new int[compare][2];

        int[][] relation = new int[people + 1][2];

        for (int i = 0; i < compare; i++) { // 집입 당하는것이 키
            StringTokenizer str = new StringTokenizer(br.readLine());
            int tempFirst = Integer.parseInt(str.nextToken());
            compareArr[i][0] = tempFirst;

            int tempSecond = Integer.parseInt(str.nextToken());
            compareArr[i][1] = tempSecond;

            relation[tempSecond][1]++;

        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= people; i++) {
            if(relation[i][1] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int temp = queue.poll();

            sb.append(temp).append(" ");

            for (int i = 0; i < compare; i++) {
                if(compareArr[i][0] == temp){
                    relation[compareArr[i][1]][1] --;
                    if(relation[compareArr[i][1]][1] == 0){
                        queue.add(compareArr[i][1]);
                    }
                }
            }

        }

        System.out.println(sb);




    }





}
