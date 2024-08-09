package EunJi.Week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Beak_2644 {
    static int people;
    static int relationshipCount;
    static int[][] relationship;
    static HashMap<Integer, Integer> firstParent = new HashMap<>();
    static HashMap<Integer, Integer> secondParent = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        relationshipCount = Integer.parseInt(br.readLine());
        relationship = new int[relationshipCount][2];
        for (int i = 0; i < relationshipCount; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            relationship[i][0] = Integer.parseInt(str.nextToken());
            relationship[i][1] = Integer.parseInt(str.nextToken());
        }


        firstParent.put(first, 1);
        secondParent.put(second, 1);
        boolean[] firstVisited = new boolean[people + 1];
        boolean[] secondVisited= new boolean[people + 1];

        ArrayList<Integer> firstArr = new ArrayList<>();
        firstArr.add(first);
        ArrayList<Integer> secondArr =  new ArrayList<>();
        secondArr.add(second);

        firstArr = DFS(first, firstVisited, firstArr);
        secondArr = DFS(second, secondVisited, secondArr);
//        System.out.println("firstArr = " + firstArr);
//        System.out.println("secondArr = " + secondArr);

        HashSet<Integer> set = new HashSet<>(firstArr);

        int answer = -1;
        for(int num : secondArr){
            if(set.contains(num)){
                answer = firstArr.indexOf(num) + secondArr.indexOf(num);
                break;
            }
        }

        System.out.println(answer);
    }

    static ArrayList<Integer> DFS(int start, boolean[] visited, ArrayList<Integer> arr){

        for (int i = 0; i < relationshipCount; i++) {
            if(relationship[i][1] == start &&  !visited[relationship[i][0]] ){
                arr.add(relationship[i][0]);
                DFS(relationship[i][0], visited, arr);
            }
        }

        return arr;

    }



}
