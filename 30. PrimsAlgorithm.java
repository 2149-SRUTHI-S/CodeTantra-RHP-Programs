/*
Prim's Algorithm

Follow the given steps to utilize the Prim’s Algorithm mentioned above for finding MST of a graph:

• Create a set mstSet that keeps track of vertices already included in MST.
• Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign the key value as 0 for the first vertex so that it is picked first.
• While mstSet doesn’t include all vertices
• Pick a vertex u that is not there in mstSet and has a minimum key value.
• Include u in the mstSet.
• Update the key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices.
• For every adjacent vertex v, if the weight of edge u-v is less than the previous key value of v, update the key value as the weight of u-v.

5
0 2 3 0 6
2 0 7 1 0
3 7 0 4 5
0 1 4 0 2
6 0 5 2 0
0--1 :2
0--2 :3
1--3 :1
3--4 :2
8

*/

import java.util.*;

class Main {
    int noOfVertices;
    Main(int v) {
        noOfVertices = v;
    }


    int searchMinKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < noOfVertices; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    void mstPrims(int aMatrix[][]) {
        int key[] = new int[noOfVertices]; // manage key value for all vertices
        boolean mstSet[] = new boolean[noOfVertices];
        int parent[] = new int[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < noOfVertices; i++) {
            int u = searchMinKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < noOfVertices; v++) {
                if (aMatrix[u][v] != 0 && !mstSet[v] && aMatrix[u][v] < key[v])                 {
                    key[v] = aMatrix[u][v]; // u---v
                    parent[v] = u; // keep track of edges part of MST
                } // if
            } // in for loop
        } // outer for loop
        
        printMST(parent, aMatrix);
    }

    void printMST(int parent[], int aMatrix[][]) {
        int minCost = 0;
        for (int i = 1; i < noOfVertices; i++) {
            System.out.println(parent[i] + "--" + i + " :" + aMatrix[i][parent[i]]);
            minCost += aMatrix[i][parent[i]];
        }
        System.out.print(minCost);
    }


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        Main obj = new Main(V);
        int aMatrix[][] = new int[V][V];
        
        for (int i = 0; i < V; i++) { // V
            for (int j = 0; j < V; j++) { // V--->O(v^2)
                aMatrix[i][j] = sc.nextInt();
            }
        }
        
        obj.mstPrims(aMatrix);
        sc.close();
    }
}
