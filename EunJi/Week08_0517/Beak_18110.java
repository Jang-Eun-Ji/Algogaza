package EunJi.Week08_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Beak_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        int roundNum = (int) Math.round(n*0.15);
        int[] newArr = IntStream.range(roundNum, arr.size() - roundNum).map(num -> arr.get(num)).toArray();


//        System.out.println("newArr = " + Arrays.toString(newArr));
        double temp = Arrays.stream(newArr).average().orElse(0);
        int answer = (int) Math.round(temp);
        System.out.println(answer);
    }
}
