package Graph;

import java.util.LinkedList;
import java.util.List;

public class GraphIntro {

    static class Graph1 { // <-- made static
        private final int V; // number of vertices
        private final List<Integer>[] adjList; // adjacency list

        // constructor
        Graph1(int v) {
            this.V = v;
            adjList = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        // add an edge in undirected graph
        public void addEdge(int src, int des) {
            adjList[src].add(des); // connect src -> des
            adjList[des].add(src); // connect des -> src
        }

        // print graph
        public void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (Integer node : adjList[i]) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Graph1 g = new Graph1(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();

    }
}
