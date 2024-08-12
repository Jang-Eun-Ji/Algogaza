package EunJi.Step.Step42_topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int problem = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        int[] arrPr = new int[problem +1];
        int[][] pare = new int[relation][2];


        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            pare[i][0] = Integer.parseInt(st.nextToken());
            pare[i][1] = Integer.parseInt(st.nextToken());
            arrPr[pare[i][1]]++;
        }

        PriorityQueue<Integer> pr = new PriorityQueue<>();

        for (int i = 1; i <= problem; i++) {
            if(arrPr[i] == 0){
                pr.add(i);
            }
        }
//        System.out.println("pr = " + pr);

        while (!pr.isEmpty()){
            int temp = pr.poll();
            sb.append(temp).append(" ");

            for (int i = 0; i < relation; i++) {
                if(pare[i][0] == temp){
                    arrPr[pare[i][1]]--;
                    if(arrPr[pare[i][1]] == 0) pr.add(pare[i][1]);
                }
            }
        }

        System.out.println(sb);


    }
}
