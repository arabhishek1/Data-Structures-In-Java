package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhishek.ar on 16/07/17.
 */
public class DFSPath {

    private boolean visited[];
    private int[] edgeTo;
    private final int s;

    public DFSPath(Graph G, int s){
        this.s = s;
        edgeTo = new int[G.V()];
        visited = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        visited[v] = true;
        for(int u : G.adj(v)){
            if (!visited[u]) {
                edgeTo[u] = v;
                dfs(G, u);
            }
        }
    }

    public boolean hasPathTo(int v){
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);

        System.out.println(graph.toString());
        int s =0;
        DFSPath dfs = new DFSPath(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.printf("%d to %d :", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s)
                        System.out.print("-" + x);
                    else
                        System.out.print("-" + x);
                }
                System.out.println();
            } else {
                System.out.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }



}
