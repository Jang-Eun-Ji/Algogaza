package EunJi.Algogaza.Week08_0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            String[] friendArr = new String[number];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < number; j++) {
                friendArr[j] = st.nextToken();
            }

            friends(number, friendArr);
        }
    }
    public static void friends(int number ,String[] friends){
       int answer = 100000;
       loop:
        for (int i = 0; i < number -2; i++) {
            for (int j = i + 1; j < number -1; j++) {
                for (int k = j + 1; k < number; k++) {
                    int temp = 0;
                    for (int l = 0; l < 4; l++) {
                        if(friends[i].charAt(l) != friends[j].charAt(l)) temp++;
                        if(friends[j].charAt(l) != friends[k].charAt(l)) temp++;
                        if(friends[k].charAt(l) != friends[i].charAt(l)) temp++;
                    }
                    if(temp == 0) {
                        answer = 0;
                        break loop;
                    }
                    if(temp < answer) answer = temp;
                }
            }

        }
        System.out.println(answer);
    }
}
