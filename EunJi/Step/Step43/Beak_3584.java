package EunJi.Step.Step43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Beak_3584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int node = Integer.parseInt(br.readLine());

            int[][] tree = new int[node - 1][2];

            for (int j = 0; j < node - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tree[j][0] = Integer.parseInt(st.nextToken());
                tree[j][1] = Integer.parseInt(st.nextToken());
            }
//            System.out.println("tree = " + Arrays.deepToString(tree));
            StringTokenizer str = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(str.nextToken());
            int second = Integer.parseInt(str.nextToken());

            ArrayList<Integer> firstArr = new ArrayList<>();
            ArrayList<Integer> secondArr = new ArrayList<>();

            boolean[] firstVisited = new boolean[node + 1];
            firstArr.add(first);
            ArrayList<Integer> firstTemp = findParents(tree, firstVisited, first, firstArr, node);
//            System.out.println("firstTemp = " + firstTemp);

            boolean[] secondVisited = new boolean[node + 1];
            secondArr.add(second);
            ArrayList<Integer> secondTemp = findParents(tree, secondVisited, second, secondArr, node);

//            System.out.println("secondTemp = " + secondTemp);
            HashSet<Integer> set = new HashSet<>(firstTemp);

            for(int temp : secondTemp){
                if(set.contains(temp)){
                    System.out.println(temp);
                    break;
                }
            }


        }
    }

    static ArrayList<Integer> findParents(int[][] tree, boolean[] visited, int start, ArrayList<Integer> arr, int node) {
        visited[start] = true;
        for (int i = 0; i < node - 1; i++) {
            if(!visited[tree[i][0]] && tree[i][1] == start){
                visited[tree[i][0]] = true;
                arr.add(tree[i][0]);
                findParents(tree,visited, tree[i][0] ,arr,node);
            }
        }
        return arr;
    }
}
