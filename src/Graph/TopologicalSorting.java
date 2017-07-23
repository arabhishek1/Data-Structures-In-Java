package Graph;

import java.util.Stack;

/**
 * Created by abhishek.ar on 21/07/17.

 Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge
 uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological
 sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”.
 The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).

            5 --> 0 <---4
            |           |
            2-->  3 --> 1
 5->0
 5->2
 4->0
 4->1
 2->3
 3->1
 */
public class TopologicalSorting {

    public static void TopologicalSortingUtil(Graph G, int s, boolean[] visited, Stack stack){
        visited[s] = true;
        for(int u : G.adj(s)){
            if (!visited[u])
                TopologicalSortingUtil(G, u, visited, stack);
        }
        stack.push(s);
    }

    public static void TopologicalSorting(Graph G){
        boolean visited [] = new boolean[G.V()];
        Stack<Integer> stack = new Stack<>();
        for(int i=G.V()-1; i >= 0; --i){
            if (!visited[i])
                TopologicalSortingUtil(G, i, visited, stack);
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addDirectedEdge(5,2);
        G.addDirectedEdge(5,0);
        G.addDirectedEdge(4,0);
        G.addDirectedEdge(4,1);
        G.addDirectedEdge(2,3);
        G.addDirectedEdge(3,1);
        TopologicalSorting(G);
    }
}
