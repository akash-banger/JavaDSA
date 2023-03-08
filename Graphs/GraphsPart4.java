package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphsPart4 {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // bellmann ford algorithm: to find paths from src to all the edges (Includes negative edges also)
    // does'nt work for negative weighted cycles (if there exist a cycle the sum of the edge wt should not be negative)
    public static void bellmann(ArrayList<Edge>[] graph, int src){ // O(V*E)
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<graph.length-1; i++){

            // time complexity of these two loops is O(E) we are just traversing each edge
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // if dist[u] is +infinity then adding a number to it will give a negative number which is not what we want
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }

        System.out.println();
    }


    static class Pair implements Comparable<Pair>{
        int v;  // vertex
        int cost; // cost
        int src;

        Pair(int src, int v, int cost){
            this.src = src;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    // prims algorithm
    public static void prims(ArrayList<Edge> graph[]){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> mst[] = new ArrayList[graph.length];
        for(int i=0; i<mst.length; i++){
            mst[i] = new ArrayList<>();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        boolean visited[] = new boolean[graph.length];
        int finalcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.v]){
                if(curr.v != 0){
                    mst[curr.v].add(new Edge(curr.src, curr.v, curr.cost));
                }
                visited[curr.v] = true;
                finalcost += curr.cost;
                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.src, e.dest, e.wt));
                }
            }
        }

        System.out.println("Final cost of MST " + finalcost);
        
        for(int i=0; i<mst.length; i++){
            for(int j=0; j<mst[i].size(); j++){
                Edge e = mst[i].get(j);
                System.out.print("(" + e.src + " " + e.dest + " " + e.wt + ") ");
            }
        }
        System.out.println();
    }


    public static void main(String arg[]){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        bellmann(graph, 0);


        // MST: Minimum Spanning Tree
        // Minimum spanning tree or minimum weight spanning tree is a subset of edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycle and with the minimum possible total edge weight.


        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph1[] = new ArrayList[4];
        for(int i=0; i<graph1.length; i++){
            graph1[i] = new ArrayList<>();
        }

        graph1[0].add(new Edge(0, 1, 10));
        graph1[0].add(new Edge(0, 2, 15));
        graph1[0].add(new Edge(0, 3, 30));

        graph1[1].add(new Edge(1, 3, 40));

        graph1[2].add(new Edge(2, 3, 50));

        // Prim's algorithm (To find the mst)
        prims(graph1);


    }
}
