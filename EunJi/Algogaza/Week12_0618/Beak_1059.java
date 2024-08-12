package EunJi.Algogaza.Week12_0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] s = new int[sSize];

        int low = 0;
        int high = 1001;

        for (int i = 0; i < sSize; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int containNum = Integer.parseInt(br.readLine());
        int answer = 1001;

        for(int temp : s){
            if(temp == containNum) {
                answer = 0;
                break;
            }
            if(temp < containNum && temp > low) low = temp;
            if(temp > containNum && temp < high) high = temp;
        }
//        System.out.println("low = " + low);
//        System.out.println("high = " + high);
        if(answer != 0){
            answer = (containNum - low - 1) * (high - containNum);
            answer += high - containNum - 1;
        }
        System.out.println(answer);



    }


}
