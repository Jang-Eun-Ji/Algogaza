package EunJi.Algogaza.Week10_0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Beak_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nonListen = Integer.parseInt(st.nextToken());
        int nonWatch =  Integer.parseInt(st.nextToken());

        HashSet<String> nonListenList = new HashSet<>();

        for (int i = 0; i < nonListen; i++) {
            nonListenList.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < nonWatch; i++) {
            String temp = br.readLine();
            if(nonListenList.contains(temp)){
                answer.add(temp);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (String a : answer){
            System.out.println(a);
        }
    }
}
