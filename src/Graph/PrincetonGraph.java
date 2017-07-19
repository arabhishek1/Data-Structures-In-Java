package Graph;

/**
 * Created by abhishek.ar on 14/07/17.
 */
public class PrincetonGraph {
    private int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    public PrincetonGraph(int V) {
        this.vertices = V;
        this.edges = 0;
        adj = new Bag[V];
        for(int i=0; i < vertices; ++i)
            adj[i] = new Bag<Integer>();
    }

    public int V(){
        return vertices;
    }

    public int E(){
        return edges;
    }

    public void addEdge(int u, int v){
        validateVertex(u);
        validateVertex(v);
        adj[u].add(v);
        adj[v].add(u);
        ++edges;
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices-1));
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
