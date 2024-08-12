package EunJi.Algogaza.Week10_0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Beak_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int pokemon = Integer.parseInt(st.nextToken());
        int problem = Integer.parseInt(st.nextToken());

        //str.matches("[+-]?\\d*(\\.\\d+)?"); - 숫자인거 확인하는 메소드

        HashMap<Integer, String> pokemonNumBook = new HashMap<>();
        HashMap<String, Integer> pokemonNameBook = new HashMap<>();
        for (int i = 0; i < pokemon; i++) {
            String name = br.readLine();
            pokemonNumBook.put(i + 1, name);
            pokemonNameBook.put(name,i + 1);
        }

        for (int i = 0; i < problem; i++) {
            String temp = br.readLine();
            if(temp.matches("[+-]?\\d*(\\.\\d+)?")){
                int number = Integer.parseInt(temp);
                sb.append(pokemonNumBook.get(number)).append("\n");
            }else {
                sb.append(pokemonNameBook.get(temp)).append("\n");

            }
        }
        System.out.println(sb);
    }
}
