package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhishek.ar on 16/07/17.
 */
public class BFS {
    private boolean[] visited;
    private int count;

    public BFS(Graph G, int s) {
        visited = new boolean[G.V()];
        bfs(G, s);
    }

    public boolean isVisited(int v){
        return visited[v];
    }
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        ++count;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : G.adj(v)) {
                if (!isVisited(u)) {
                    visited[u] = true;
                    ++count;
                    queue.add(u);
                }
            }
        }
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

        BFS bfs = new BFS(graph, 0);
        if (bfs.count == graph.V())
            System.out.println("connected");
        else
            System.out.println("not connected");
    }
}
