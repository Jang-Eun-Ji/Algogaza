package EunJi.Week08_0517;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Beak_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int cheater = Integer.parseInt(br.readLine());
        Integer[] people = new Integer[number - 1];


        for (int i = 0; i < number - 1; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(people);
//        System.out.println("people = " + Arrays.toString(people));

        int answer = 0;

        for (int i = 0; i < number -1; i++) {
            Arrays.sort(people);

            if(people[number-2] < cheater){
                break;
            } else if (people[number - 2] == cheater){
                answer++;
                break;
            }

            double temp = (double) (people[number - 2] - cheater)/2;
//            System.out.println("temp = " + temp);
            temp = Math.ceil(temp);
            people[number-2] -= (int)temp;
            cheater += (int)temp;
            answer+= (int)temp;
        }

        System.out.println(answer);

    }
}
