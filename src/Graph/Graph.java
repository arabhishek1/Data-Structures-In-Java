package Graph;

import java.util.LinkedList;

/**
 * Created by abhishek.ar on 16/07/17.
 */
public class Graph {
    private int vertices;
    private int edges;
    private LinkedList<Integer>[] adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adj = new LinkedList[vertices];
        for(int v=0; v < vertices; ++v){
            adj[v] = new LinkedList<Integer>();
        }
    }

    public int V(){
        return vertices;
    }

    public int E(){
        return edges;
    }

    public void addEdge(int u, int v){
        adj[v].add(u);
        adj[u].add(v);
        ++edges;
    }

    public void addDirectedEdge(int u, int v){
        adj[u].add(v);
        ++edges;
    }

    public LinkedList<Integer> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + '\n');
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }
}


