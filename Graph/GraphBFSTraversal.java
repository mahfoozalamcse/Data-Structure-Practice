package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSTraversal {
    private int V; // for vertex
    private LinkedList<Integer>[] adjList; // for adjecency list

    GraphBFSTraversal(int v){
       V = v;
       adjList = new LinkedList[v];
       for(int i=0; i< v; i++){
        adjList[i] = new LinkedList<>();
       }
    }

    // add edges
    void addEdge(int src, int des){
        adjList[src].add(des);
        adjList[des].add(src);
    }

    // BFS traversal level by level order
    void BFS(int start){
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node+" ");

            for(int neighour : adjList[node]){
                if (!visited[neighour]) {
                    visited[neighour] = true;
                    q.add(neighour);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFSTraversal g = new GraphBFSTraversal(5);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.print("BFS starting from 0: ");
        g.BFS(0);
    }
}
