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

*/
