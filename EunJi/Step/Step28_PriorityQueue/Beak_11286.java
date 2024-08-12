package EunJi.Step.Step28_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beak_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pr = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2); // o1이랑 o2를 비교
                    else return Integer.compare(Math.abs(o1), Math.abs(o2));
                }
        );


        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0) pr.add(temp);
            else {
                if(pr.isEmpty()) System.out.println(0);
                else System.out.println(pr.poll());
            }
        }
    }
}

