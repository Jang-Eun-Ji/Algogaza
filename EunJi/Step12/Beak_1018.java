package EunJi.Step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1018 {
    static int wide;
    static int height;
    static int[][] black;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        wide = Integer.parseInt(st.nextToken());
        String[][] chess = new String[height][wide];

        // 0,0이 블랙으로 칠해진다면 칠해지는 곳은 1로 표시
        black = new int[height][wide];
//        int[][] white = new int[height][wide];

        for (int i = 0; i < height; i++) {
            String temp = br.readLine();
            for (int j = 0; j < wide; j++) {
                String tempColor = temp.substring(j, j+1);
                chess[i][j] = tempColor;
                if((i+j) % 2 == 0){
                    if(!tempColor.equals("B")){
                        black[i][j] = 1;
                    }
                }else {
                    if(tempColor.equals("B")){
                        black[i][j] = 1;
                    }
                }
            }
        }
        // 각각 인덱스가 (0,0)에서 홀수만큼의 인덱스가 움직이면 반대로 짝수만큼 움직이면 그대로여도 된다.
        // 그러니 모든 칸의 인덱스 (0,0)이 검정,하양색일 때 칠해야하는 블록을 각각 표시한다
        // 그리고 가장 왼쪽 위인 인덱스를 한칸씩 옮기면서 검정, 흰색중 어떤것이 가장 적게 되는지 8*8인지 확인하기
//        System.out.println("chess = " + Arrays.deepToString(chess));
//        System.out.println("black = " + Arrays.deepToString(black));


        int firstChess = checkChess(0,0);

        if(wide > 8 || height > 8){
            for (int i = 0; i <= height - 8; i++) {
                for (int j = 0; j <= wide - 8; j++) {
                    if(i == 0 && j == 0) continue;
                    int temp = checkChess(i, j);
                    if(temp < firstChess) firstChess = temp;
                }

            }
        }

        System.out.println(firstChess);

    }

    static int checkChess(int startHeight, int startWide){
        int chess = 0;

        for (int i = startHeight; i < startHeight + 8; i++) {
            for (int j = startWide; j < startWide + 8; j++) {
                chess += black[i][j];
            }
        }
        if(chess > 64 - chess) {
            chess = 64 - chess;
        }
        return chess;
    }
}
