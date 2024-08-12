package EunJi.Step.Step28_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beak_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0) {
                maxHeap.add(temp);
            }else {
                if(maxHeap.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(maxHeap.poll());
                }

            }
        }
    }
}
