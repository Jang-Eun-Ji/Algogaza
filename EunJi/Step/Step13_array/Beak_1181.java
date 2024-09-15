package EunJi.Step.Step13_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int word = Integer.parseInt(br.readLine());
        String [] wordArr = new String[word];

        for (int i = 0; i < word; i++) {
            wordArr[i] = br.readLine();
        }

        String [] streamArr = Arrays.stream(wordArr)
                .distinct()
                .sorted((a, b )->{
            if(a.length() == b.length()){
                return alpabeticalOrder(a, b);
            }else {
                return Integer.compare(a.length(), b.length());
            }
        }).toArray(String[]::new);


        for (int i = 0; i < streamArr.length; i++) {
            sb.append(streamArr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int alpabeticalOrder(String a, String b){
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if(a.charAt(i) == b.charAt(i)) continue;
            else {
                return a.charAt(i) - b.charAt(i);
            }
        }
        return -1;
    }


}
