package Graph;

import java.util.LinkedList;

public class DFSGraph {
    private int V;
    private LinkedList<Integer>[] adjList;

    DFSGraph(int v){
        V = v;
        adjList = new LinkedList[v];

        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge
    void addEdge(int src, int des){
        adjList[src].add(des);
        adjList[des].add(src);

    }

    void DFS(int start){
        boolean visited[] = new boolean[V];
        DFSUtile(start, visited);
    }

    void DFSUtile(int node, boolean visited[]){
        visited[node] = true;
        System.out.print(node + " ");

        for(int neighour : adjList[node]){
            if (!visited[neighour]) {
                DFSUtile(neighour, visited);
            }
        }
    }

    public static void main(String[] args) {

        DFSGraph g = new DFSGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.print("DFS starting from 0: ");
        g.DFS(0);
    }
}
