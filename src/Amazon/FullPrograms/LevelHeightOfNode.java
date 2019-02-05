package Amazon.FullPrograms;

import Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
* In a social media app like where person can have friends, print all the people at level k, where k signifies no of hops
* required to reach that person.
*
* int arr [][] = {
*   { 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
*   { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
*   { 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
*   { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
*   { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
*   { 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
*   { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
*   { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
*   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
*   { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
*   { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
* }
* */
public class LevelHeightOfNode {

    public static int printLevel(int arr[][], int k){

//        Queue<Integer> queue = new LinkedList<>();
//        boolean visited[][] = new boolean[arr.length][arr[0].length];
//
//        for(int i=0; i < arr.length; ++i){
//            for(int j=0; j < arr[0].length; ++j){
//                if (arr[i][j] == 1){
//                    ((LinkedList<Integer>) queue).add();
//                }
//            }
//        }
        return 0;
    }

    public static void printLevelAdjList(Graph g, int k){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[g.V()];
        int [] distance = new int[g.V()];
        visited[0] = true;
        distance[0] = 0;
        queue.add(0);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for(int u : g.adj(v)){
                if (!visited[u]) {
                    visited[u] = true;
                    distance[u] = distance[v] + 1;
                    if (distance[u] == k)
                        System.out.println(u);
                    queue.add(u);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 9);
        graph.addEdge(7, 8);
        graph.addEdge(8, 10);
        printLevelAdjList(graph, 4);
    }

}
