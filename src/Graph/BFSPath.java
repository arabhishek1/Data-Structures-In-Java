package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abhishek.ar on 16/07/17.
 */
public class BFSPath {
    private boolean[] visited;
    private int[] edgeTo;
    private int[] distTo;

    public BFSPath(Graph G, int s) {
        this.visited = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.distTo = new int[G.V()];
        bfs(G, s);
        assert check(G, s);
    }

    private boolean check(Graph G, int s) {
        if (distTo[s] != 0)
            return false;
        for (int v = 0; v < G.V(); ++v) {
            for (int w : G.adj(v)) {
                if (hasPathTo(w) != hasPathTo(v))
                    return false;
                if (hasPathTo(v) && distTo[w] > distTo[v])
                    return false;
            }
        }

        for (int w = 0; w < G.V(); ++w) {
            if (!hasPathTo(w) || w == s)
                continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1)
                return false;
        }
        return true;
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        visited[s] = true;
        distTo[s] = 0;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : G.adj(v)) {
                if (!isVisited(u)) {
                    edgeTo[u] = v;
                    distTo[u] = distTo[v] + 1;
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }


    }

    public boolean isVisited(int v) {
        return visited[v];
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
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

        int s = 0;
        BFSPath bfs = new BFSPath(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
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
