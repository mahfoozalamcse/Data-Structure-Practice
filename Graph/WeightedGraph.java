package Graph;

import java.util.LinkedList;

public class WeightedGraph {
    private int V;
    private LinkedList<Edge>[] adjList;

    static class Edge {
        int des, weight;

        Edge(int d, int w) {
            des = d;
            weight = w;
        }
    }

    WeightedGraph(int v) {
        V = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge
    // for undirected
    void addEdge(int src, int des, int weight) {
        adjList[src].add(new Edge(des, weight));
        adjList[des].add(new Edge(des, weight)); // for directed remove this line only
    }

    // print graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(" Vertex : " + i + " : ");
            for (Edge value : adjList[i]) {
                System.out.print(" " + value.des + " " + value.weight);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        WeightedGraph g = new WeightedGraph(5);
        System.out.println();
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 50);
        g.addEdge(3, 4, 60);

        g.printGraph();
    }
}
