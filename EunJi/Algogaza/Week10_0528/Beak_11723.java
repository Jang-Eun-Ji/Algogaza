package EunJi.Algogaza.Week10_0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            if(temp.contains("add")){
                int tempNumber = Integer.parseInt(st.nextToken());
                arr.add(tempNumber);
            }else if(temp.contains("remove")){
                int tempNumber = Integer.parseInt(st.nextToken());
                if(arr.contains(tempNumber)){
                    int indx = arr.indexOf(tempNumber);
                    arr.remove(indx);
                }
            }else if(temp.contains("check")){
                int tempNumber = Integer.parseInt(st.nextToken());
                if(arr.contains(tempNumber)){
                    sb.append("1").append("\n");
                }else sb.append("0").append("\n");
            }else if(temp.contains("toggle")){
                int tempNumber = Integer.parseInt(st.nextToken());
                if(arr.contains(tempNumber)){
                    int indx = arr.indexOf(tempNumber);
                    arr.remove(indx);
                }else arr.add(tempNumber);
            }else if(temp.contains("all")){
                arr = new ArrayList<>();
                for (int j = 1; j < 21; j++) {
                    arr.add(j);
                }
            }else{
                arr = new ArrayList<>();
            }
        }

        System.out.println(sb);
    }
}
