package Graph;

/**
 * Created by abhishek.ar on 18/07/17.
 *
 *
 Print all paths from a given source to a destination
 Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’.

 Consider the following directed graph. Let the s be 2 and d be 3. There are 4 different paths from 2 to 3.
 */
public class PrintAllPathsInDAG {

    private int[] paths;
    private boolean[] visited;

    public PrintAllPathsInDAG(Graph G, int s , int d) {
        paths = new int[G.V()];
        visited = new boolean[G.V()];
        int index =0;
        dfs(G, s, d, index);
    }

    public boolean isVisited(int v) {
        return visited[v];
    }

    private void dfs(Graph G, int s, int d, int index) {
        visited[s] = true;
        paths[index] = s;
        ++index;
        if (s == d){
            for(int i=0; i < index; ++i){
                System.out.print(paths[i] + " ");
            }
            System.out.println();
        } else {
            for (int u : G.adj(s)) {
                if (!isVisited(u)) {
                    dfs(G, u, d, index);
                }
            }
        }
        --index;
        visited[s] = false;
    }

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addDirectedEdge(0, 1);
        G.addDirectedEdge(0, 2);
        G.addDirectedEdge(0, 3);
        G.addDirectedEdge(1, 3);
        G.addDirectedEdge(2, 0);
        G.addDirectedEdge(2, 1);
        PrintAllPathsInDAG printAllPathsInDAG = new PrintAllPathsInDAG(G, 2, 3);
    }
}
