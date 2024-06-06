/* Dijkstra's Algorithm */

import java.util.Scanner;

class ShortestPath {
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    void printSolution(int dist[], int src) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(src + " - " + i + " = " + dist[i]);
    }

    void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist, src);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacency matrix for the graph (" + V + "x" + V + "):");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scanner.nextInt();

        System.out.print("Enter the source vertex: ");
        int src = scanner.nextInt();

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, src);
    }
}


/* Single Source Shortest Path */

import java.util.Scanner;
// Dijkstra's algorithm, The limitation is it doesn't work on negative edge weights
// negative cycles.

class Main { // Single source shortest path algorithm ( Similar to Prims i.e. greedy)
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int src) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(src + " - " + i + " = " + dist[i]);
    }

    void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist, src);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacency matrix for the graph (" + V + "x" + V + "):");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scanner.nextInt();

        System.out.print("Enter the source vertex: ");
        int src = scanner.nextInt();

        Main t = new Main();
        t.dijkstra(graph, src);
    }
}
