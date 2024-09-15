package EunJi.Step.Step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0;
        double totalTime = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String trash = st.nextToken();
            double time = Double.parseDouble(st.nextToken());
            String scoreSt = st.nextToken();

            double score = 4.5;

            if (scoreSt.equals("P")) {
                continue; // P인 경우 점수와 시간 둘 다 무시
            }

            if (scoreSt.equals("F")) {
                score = 0.0;
            }else if (scoreSt.equals("D0")) {
                score = 1.0;
            }else if (scoreSt.equals("D+")) {
                score = 1.5;
            }else if (scoreSt.equals("C0")) {
                score = 2.0;
            }else if (scoreSt.equals("C+")) {
                score = 2.5;
            }else if (scoreSt.equals("B0")) {
                score = 3.0;
            }else if (scoreSt.equals("B+")) {
                score = 3.5;
            }else if (scoreSt.equals("A0")) {
                score = 4.0;
            }else if(scoreSt.equals("A+")){
                score = 4.5;
            }
//            System.out.println("scoreSt = " + scoreSt);

            totalScore+= score*time;
            totalTime += time;


        }
        System.out.println("totalTime = " + totalTime);
        System.out.printf("%.6f", totalScore/totalTime);
    }
}
