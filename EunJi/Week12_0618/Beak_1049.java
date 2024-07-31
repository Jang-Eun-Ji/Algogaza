package EunJi.Week12_0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        int brand = Integer.parseInt(st.nextToken());


        int whole = Integer.MAX_VALUE;
        int each = Integer.MAX_VALUE;

        for (int i = 0; i < brand; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int tempWhole =  Integer.parseInt(str.nextToken());
            if(whole > tempWhole) whole = tempWhole;

            int tempEach = Integer.parseInt(str.nextToken());
            if(each > tempEach) each = tempEach;

        }
        int answer = 0;
        if(line <= 6){
            answer = whole;
            if(whole > each*line) answer = each*line;
        }else {
            int allPackage = whole * (line/6 + 1);
            if(line%6 == 0) allPackage = whole * (line/6);

            int mix = whole * (line/6) + (line%6) * each;

            int allEach = line*each;

            answer = Math.min(allPackage, mix);
            answer = Math.min(answer, allEach);
        }

        System.out.println(answer);


    }
}
