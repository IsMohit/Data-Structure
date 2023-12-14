import java.util.*;
public class DFS{
    LinkedList<Integer> adj[];
    boolean visited[];

    DFS(int v){
        adj = new LinkedList[v];
        visited = new boolean[v];

        for(int i =0 ; i < v ; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src , int dest){
        adj[src].add(dest);
    }

    public void Dfs(int curr){
        visited[curr] = true;
        System.out.print(curr+" ");

        Iterator<Integer> it = adj[curr].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if(!visited[n]){
                Dfs(n);
            }
        } 
    }

    public static void main(String[] args) {
        DFS b = new DFS(6);
        b.addEdge(0, 1);
        b.addEdge(0, 3);
        b.addEdge(0, 4);
        b.addEdge(4, 5);
        b.addEdge(3, 5);
        b.addEdge(1, 2);
        b.addEdge(1, 0);
        b.addEdge(2, 1);
        b.addEdge(4, 1);
        b.addEdge(3, 1);
        b.addEdge(5, 4);
        b.addEdge(5, 3);
        System.out.print("\nDFS Traveral => ");
        b.Dfs(0);
    }
}