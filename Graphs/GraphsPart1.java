package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class GraphsPart1 {


    // Graphs is network of nodes
    // Graphs consistes of edges and vortex 
    

    /* Types of edges 
     * Uni-Directional => Directed Graph
     * Un-Directed is same as Bi-Directtional => Un-Directed Graph
     * Bi-Directional
     */


    // Now every edge can have a value associated with it (Weight) 

    // The graph in which edges have some values given to them are called  WEIGHTED GRAPHS 
    // The graph in which edges do not have any value given to them are called UNWEIGHTED GRAPHS 
    

    // Weight can be negative postive or zero

    // Storing a Graph => Structure representation 

    /* 
    * Adjacency list => list of lists (Array of Arraylists) == optimized
    * Adjacency matrix => square matrix of length as number of vertices(ints) row and col as vertices (at i,j value 1 if there is an edge and 0 if not) == not efficient (Time complexity is more compared to adjacency list but better in some special cases)
    * Edge list => list of all the edges
    * 2D Matrix (Implicit Graph)
    */


    static class Edge{
        int source;
        int dest;
        int wt;

        public Edge(int source, int dest, int wt){
            this.source = source;
            this.dest = dest;
            this.wt = wt;
        }
    }




    public static void bfs(ArrayList<Edge>[] graph){ // O(V + E)
        boolean visited[] = new boolean[graph.length + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // src = 0 you can take anything as source

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){

    }


    public static void main(String arg[]){

        // creating a graph using adjacency list 

        /* 
                            (5)
                        0 ------- 1
                                /   \
                           (1) /     \ (3)
                              /       \
                             2 ------- 3
                             |   (1)
                          (2)|
                             |
                             4
         */



        
        int v = 5;
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];


        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1st vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2nd vertex 
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3rd vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // 4th vertex 
        graph[4].add(new Edge(4, 2, 2));


        // 2's neighbours 
        for(int i=0; i<graph[2].size(); i++){
            System.out.print(graph[2].get(i).dest + " ");
        }
        System.out.println();



        /* graph Traversals
         * Breadth first Search (BFS) similar to level wise traversal in tree (You will traverse the immediate neighbours first)
         * Depth First Search (DFS) going to the depth first instead of the printing level wise 
        */


        // BFS 
        bfs(graph);


        // DFS 
        dfs(graph);


    }
}
