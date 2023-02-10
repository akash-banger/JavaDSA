package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphsPart3 {

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


    public static void calInDeg(ArrayList<Edge>[] graph, int arr[]){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                arr[e.dest]++;
            }
        }
    }

    // for a particular node we have some incoming arrows and some outgoing arrows 
    // in degree: is the number of parents(one level) of the node 
    // out degree: is the number of children(1st level) of the node 


    // fact: a dag(directed Acyclic graph) has atleast one node whose in-degree is 0 and oen node whose out-degree is zero
    public static void topologicalSort(ArrayList<Edge>[] graph){ //using kahn's algorithm
        int indeg[] = new int[graph.length];
        calInDeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }


        while(!q.isEmpty()){
            int curr = q.remove(); 
            System.out.print(curr+ " ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);

                indeg[e.dest]--;

                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

    }   


    // all paths from source to target 
    public static void allPathsSrcTar(ArrayList<Edge>[] graph, int src, int dest, String path){

        if(src == dest){
            System.out.println(path + dest);
            return;
        }


        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            allPathsSrcTar(graph, e.dest, dest, path+src);
        }

    }


    public static void shortestPath(ArrayList<Edge>[] graph, int src){

        int shortestDist[] = new int[graph.length];

        for(int i=0; i<shortestDist.length; i++){
            shortestDist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<graph.length; i++){
            Edge e = graph[src].get(i);
            shortestDist[e.dest] = e.wt;
        }

        shortestDist[src] = 0;

        shortestPathUtil(graph, src, src, shortestDist);

    }

    public static int shortestPathUtil(ArrayList<Edge>[] graph, int u, int v, int shortestDist[]){
        shortestDist[v] = Math.min(shortestDist[v], shortestPathUtil(graph, u, v, shortestDist));
        return 0;
    }






    public static void main(String arg[]){
        int dagV = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] dag = new ArrayList[dagV];

        for(int i=0; i<dag.length; i++){
            dag[i] = new ArrayList<>();
        }   

        dag[2].add(new Edge(2, 3, 0));

        dag[3].add(new Edge(3, 1, 0));

        dag[4].add(new Edge(4, 1, 0));
        dag[4].add(new Edge(4, 0, 0));

        dag[5].add(new Edge(5, 2, 0));
        dag[5].add(new Edge(5, 0, 0));


        // topological sorting using BFS (kahn's algorithm)

        topologicalSort(dag);


        System.out.println();


        // All paths from source to target: For directed graph only


        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }   

        graph[0].add(new Edge(0, 4, 0));

        graph[2].add(new Edge(2, 3, 0));

        graph[3].add(new Edge(3, 4, 0));

        graph[4].add(new Edge(4, 1, 0));
        // graph[4].add(new Edge(4, 0, 0));

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        allPathsSrcTar(graph, 5, 1, new String(""));



        // dijkstra's algorithm: to find the shortest path(distance) between a source and all the vertices 
        // here we will use the weight of the edge also 


        int V1 = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph1 = new ArrayList[V];

        for(int i=0; i<graph1.length; i++){
            graph1[i] = new ArrayList<>();
        }   

        graph1[0].add(new Edge(0, 1, 2));
        graph1[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph1[2].add(new Edge(2, 4, 3));

        graph1[3].add(new Edge(3, 5, 1));

        graph1[4].add(new Edge(4, 3, 2));
        graph1[4].add(new Edge(4, 5, 5));

        shortestPath(graph1, 0);
    }
}
