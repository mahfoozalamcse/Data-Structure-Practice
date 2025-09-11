package Graph;

import java.util.LinkedList;

public class DirectedGraph {

    private int V;
    private LinkedList<Integer>[] adjList;

    DirectedGraph(int v) {
        this.V = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // directed eadge
    void addEdge(int src, int des) {
        adjList[src].add(des); // src -> des
    }

    // print graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(" Connected src " + i + " to : ");
            for (Integer node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        g.printGraph();
        
    }
}
