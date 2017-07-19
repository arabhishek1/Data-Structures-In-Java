package Graph;



/**
 * Created by abhishek.ar on 14/07/17.
 */
public class DFS {
    private boolean[] visited;
    private int count;

    public DFS(PrincetonGraph G, int s) {
        visited = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(PrincetonGraph G, int v){
        ++count;
        visited[v] = true;

        for(int u : G.adj(v)){
            if (!isVisited(u))
                dfs(G, u);
        }
    }

    public boolean isVisited(int v){
        return visited[v];
    }
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        PrincetonGraph princetonGraph = new PrincetonGraph(13);
        princetonGraph.addEdge(0, 5);
        princetonGraph.addEdge(4, 3);
        princetonGraph.addEdge(0, 1);
        princetonGraph.addEdge(9, 12);
        princetonGraph.addEdge(6, 4);
        princetonGraph.addEdge(6,7);
        princetonGraph.addEdge(5, 4);
        princetonGraph.addEdge(0, 2);
        princetonGraph.addEdge(11,12 );
        princetonGraph.addEdge(9 ,10);
        princetonGraph.addEdge(0, 6);
        princetonGraph.addEdge(7, 8);
        princetonGraph.addEdge(9, 8);
        princetonGraph.addEdge(9, 11);
        princetonGraph.addEdge(5, 3);
        System.out.println(princetonGraph.toString());
        DFS dfs = new DFS(princetonGraph, 0);
        for (int v = 0; v < princetonGraph.V(); v++) {
            if (dfs.isVisited(v))
                System.out.println(v + " ");
        }

        if (dfs.count() != princetonGraph.V())
            System.out.println("NOT connected");
        else
            System.out.println("connected");
    }
}
