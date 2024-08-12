package EunJi.Algogaza.Week12_0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1068 {
    static boolean[] passNode;
    static int node;
    static int[] nodeArr;
    static int removeNode;
    static int leafNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());

        passNode = new boolean[node];
        nodeArr = new int[node];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < node; i++) {
            nodeArr[i] = Integer.parseInt(st.nextToken());
        }

        removeNode = Integer.parseInt(br.readLine());



        deleteDfs(removeNode);

//        System.out.println("passNode = " + Arrays.toString(passNode));

        for (int i = 0; i < node; i++) {
            if(!passNode[i]){
//                System.out.println("dfs로 처음 들어가는 i = " + i);
                dfs(i);
            }
        }

//        System.out.println("passNode = " + Arrays.toString(passNode));

        int removeRootLeaf = 0; // 지우는 잎에 연결된게 없다는 그게 리프노트여서 그걸 추가하는 코드
        for (int i = 0; i < node; i++) {
            if(nodeArr[i] == nodeArr[removeNode]) removeRootLeaf++;
        }

        leafNode = 0;

        for(boolean temp : passNode){
            if(!temp) leafNode++;
        }
//        System.out.println(leafNode);
//        System.out.println("removeRootLeaf = " + removeRootLeaf);
//        System.out.println(" nodeArr[removeRootLeaf] = " + nodeArr[removeRootLeaf]);
        if(removeRootLeaf == 1 && nodeArr[removeNode] != -1) leafNode++;

        System.out.println(leafNode);

    }
    static void deleteDfs(int startNode){
        passNode[startNode] = true;
        for (int i = 0; i < node; i++) {
            if(nodeArr[i] == startNode && !passNode[i]) deleteDfs(i);
        }
    }

    static void dfs(int startNode){
        for (int i = 0; i < node; i++) {
            if(nodeArr[i] == startNode && startNode != i) {
//                System.out.println("i = " + i);
                passNode[startNode] = true;
                dfs(i);
            }
        }
    }

}
