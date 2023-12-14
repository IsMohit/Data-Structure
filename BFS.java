import java.util.*;
public class BFS{
    int vert;
    LinkedList<Integer> adj[];
    Queue<Integer> queue;

    BFS(int v){
        this.vert = v;
        adj = new LinkedList[v];

        for(int i = 0 ; i < v ; i++){
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<>();
    }

    public void addEdge(int src , int dest){
        adj[src].add(dest);
    }

    public void Bfs(int node){
        boolean visited[] = new boolean[vert];
        int a = 0;
        visited[node] = true;
        queue.add(node);

        while(queue.size()!=0){
            node = queue.poll();
            System.out.print(node+" ");

            for(int i = 0 ; i < adj[node].size();i++){
                a = adj[node].get(i);

                if(!visited[a]){
                    visited[a]=true;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS(6);
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
        System.out.print("\nBFS Traveral => ");
        b.Bfs(0);
    }
}