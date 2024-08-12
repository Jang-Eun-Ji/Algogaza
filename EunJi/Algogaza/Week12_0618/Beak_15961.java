package EunJi.Algogaza.Week12_0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dish = Integer.parseInt(st.nextToken());
        int kind = Integer.parseInt(st.nextToken());
        int couponCount = Integer.parseInt(st.nextToken());
        int couponDishNumber = Integer.parseInt(st.nextToken());

        // 변수를 넣어서 만약 쿠폰숫자랑 같은 숫자가 있다면 size에서 -
        // 만약에 가짓수가 kind랑 같으면 break
        List<Integer> sushiDish = new ArrayList<>();
        for (int i = 0; i < dish; i++) {
            sushiDish.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < couponCount; i++) {
            sushiDish.add(sushiDish.get(i));
        }

//        System.out.println("sushiDish = " + sushiDish);

        int start = 0;
        int end = couponCount - 1;
        int[] sushiKind = new int[kind + 1];

        int answer = 0;
        for (int i = 0; i <= end; i++) {
//            System.out.println("sushiDish = " + sushiDish.get(i));
            if(sushiKind[sushiDish.get(i)] == 0 && sushiDish.get(i) != couponDishNumber){
//                System.out.println("hi");
                answer ++;
            }
            sushiKind[sushiDish.get(i)]++;
        }

        int[] answerArr = new int[sushiDish.size()];
        answerArr[0] = answer;
        int max = answer;
        while(true){
//            System.out.println("sushiDish.get(start) = " + sushiDish.get(start));
            if(end >= sushiDish.size() -1) break;

            int temp = answerArr[start]; // 전의 값으로
            sushiKind[sushiDish.get(start)]--;

            if(sushiKind[sushiDish.get(start)] == 0 && sushiDish.get(start) != couponDishNumber){
//                System.out.println("여기선 빼기");
                temp--;
            }

            start++;
            end++;

            if(sushiKind[sushiDish.get(end)] == 0 && sushiDish.get(end) != couponDishNumber){
//                System.out.println("sushiDish.get(end) = " + sushiDish.get(end));
                temp++;
            }
            sushiKind[sushiDish.get(end)]++;

            answerArr[start] = temp;
            if(temp> max) max = temp;
        }
//        System.out.println("answerArr = " + Arrays.toString(answerArr));

        System.out.println(max +1);
    }

}

