package EunJi.Algogaza.Week11_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_2491 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(downCheck());


    }

    static int downCheck(){
        int tempUp = 1;
        int tempDown = 1;

        List<Integer> downArr = new ArrayList<>();
        List<Integer> upArr = new ArrayList<>();
        downArr.add(arr[0]);
        upArr.add(arr[0]);

        for (int j = 1; j < n; j++) {
            if(downArr.get(downArr.size()-1) >= arr[j] ) {
                downArr.add(arr[j]);
                if(tempDown < downArr.size()) tempDown = downArr.size();
            }else if(downArr.get(downArr.size()-1) < arr[j]){
                downArr = new ArrayList<>();
                downArr.add(arr[j]);
            }
//            System.out.println("downArr = " + downArr);

            if(upArr.get(upArr.size()-1) <= arr[j] ) {
                upArr.add(arr[j]);
                if(tempUp < upArr.size()) tempUp = upArr.size();
            }else {
                upArr = new ArrayList<>();
                upArr.add(arr[j]);
            }
//            System.out.println("upArr = " + upArr);
        }
        return Math.max(tempUp, tempDown);
    }
}
