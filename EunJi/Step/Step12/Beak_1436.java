package EunJi.Step.Step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Beak_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> movieList = new ArrayList<>();


        // "666"앞의 1자리, 뒤의 1자리, 앞의 2자리, 뒤의 2자리, 앞뒤 2자리,

//        for (int i = 0; i < 10000; i++) {
//            String temp = "666".concat(String.valueOf(i));
//            String frontTemp = String.valueOf(i).concat("666");
//            int numBack = Integer.parseInt(temp);
//            int numFront = Integer.parseInt(frontTemp);
//            movieList.add(numBack);
//            movieList.add(numFront);
//
//            if(i > 9 && i < 100){ // 2자릿수 앞 뒤 1개씩
//                String tempFB = String.valueOf(i/10).concat("666".concat(String.valueOf(i%10)));
//                int numTB = Integer.parseInt(tempFB);
//                movieList.add(numTB);
//            }
//            if(i >= 100 && i < 1000){ // 3자릿수 2개 앞/뒤 + 1개 앞/뒤
//                String tempFront2 = String.valueOf(i/100).concat("666".concat(String.valueOf(i%100)));
//
//                String tempBack2 = String.valueOf(i/10).concat("666".concat(String.valueOf(i%10)));
//
//                int numFront2 = Integer.parseInt(tempFront2);
//                int numBack2 = Integer.parseInt(tempBack2);
//
//                movieList.add(numFront2);
//                movieList.add(numBack2);
//            }
//            if(i >= 1000){// 4자릿수 2 + "666" + 2 // 1 + "666" + 3 // 3 + "666" + 1
//
//                String tempF2B2 = String.valueOf(i/100).concat("666".concat(String.valueOf(i%100)));
//                int numF2B2 = Integer.parseInt(tempF2B2);
//                movieList.add(numF2B2);
//
//
//                String tempF1B3 = String.valueOf(i/10).concat("666".concat(String.valueOf(i%10)));
//                int numF1B3 = Integer.parseInt(tempF1B3);
//                movieList.add(numF1B3);
//
//                String tempF3B1 = String.valueOf(i/1000).concat("666".concat(String.valueOf(i%1000)));
//                int numF3B1 = Integer.parseInt(tempF3B1);
//                movieList.add(numF3B1);
//            }
//
//            if(movieList.size() >= num * num || movieList.size() >= 10000) break;
//        }

        int temp = 666;
        while (movieList.size() < 10000){
            String stTemp = String.valueOf(temp);
            if(stTemp.contains("666")){
                movieList.add(temp);

            }
            if(movieList.size() > num*num) break;
            temp++;
        }
        List<Integer> movieAnswer =  movieList.stream().distinct()
                        .sorted()
                        .collect(Collectors.toList());
        System.out.println(movieAnswer.get(num - 1));
//        System.out.println("movieAnswer = " + movieAnswer.size());






    }
}
