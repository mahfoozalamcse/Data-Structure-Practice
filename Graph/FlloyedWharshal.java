package Graph;
// Floyd-Warshall Algorithm
//      All Pairs Shortest Path.
//      Works on negative weights but not negative cycles.
// DP-based solution.
//      Time complexity:O(V³).
// Idea:
//    For each pair(i,j),check if going via k gives a shorter path.

public class FlloyedWharshal {
    static final int INF = 99999;

    void floyedWarshall(int [][] graph, int V){
       int dist[][] = new int[V][V];

       // initialize
       for(int i=0; i<V; i++){
         for(int j=0; j<V; j++){
            dist[i][j] = graph[i][j];
         }
       }

       // Dp
       for(int k=0; k<V; k++){
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                   dist[i][j] = dist[i][k] + dist[k][j]; 
                }
            }
         }
       }

       printWarshall(dist, V);

    }

    void printWarshall(int dist[][], int V){
       System.out.println(" All- pairs Shortest path : ");
       for(int i=0; i<V; i++){
         for(int j=0; j<V; j++){
            if (dist[i][j] == INF) {
                System.out.print("INF ");
            }else{
                System.out.print(dist[i][j]+ " ");
            }
         }

         System.out.println();
       }
    }

    public static void main(String[] args) {
        FlloyedWharshal f = new FlloyedWharshal();
        int V = 4;
        int INF = FlloyedWharshal.INF;
        int[][] graph = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        f.floyedWarshall(graph, V);
    }
}
