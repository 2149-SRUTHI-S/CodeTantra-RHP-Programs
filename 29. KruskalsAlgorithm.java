/* Kruskal's Algorithm */

/*
1 2 8
2 3 7
3 4 9
4 5 10
5 6 2
6 7 1
7 0 8
7 1 11
7 8 7
2 8 2
8 6 6
2 5 4
3 5 14
*/

// Kruskals --> Greedy --> Edge centric---> disconnected
import java.util.*;

class Main {
    public static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }
    
    // Driver code
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List < Edge > gEdges = new ArrayList < Edge > ();
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            gEdges.add(new Edge(s, d, w));
        }
        mstKruskals(V, gEdges);
        sc.close();
    }

    public static void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    public static int find(int parent[], int index) {
        if (parent[index] == index)
            return index;
        return find(parent, parent[index]);
    }


    public static void mstKruskals(int V, List < Edge > edges) {

        int noOfEdges = 0;
        int j = 0;
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        Edge result[] = new Edge[V - 1];
        edges.sort(Comparator.comparingInt(o - > o.weight));
        while (noOfEdges < V - 1 && j < edges.size()) {
            Edge nextE = edges.get(j);
            int s = find(parent, nextE.src);
            int d = find(parent, nextE.dest);
            if (s != d) {
                result[noOfEdges] = nextE;
                union(parent, s, d);
                noOfEdges++;
            }
            j++;
        }
        
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(result[i].src + "---" + result[i].dest + ": " + result[i].weight);
            minCost = minCost + result[i].weight;
        }
        System.out.print("Minnimum cost: " + minCost);
    }
}
