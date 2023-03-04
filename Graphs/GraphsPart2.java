package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class GraphsPart2 {
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


    public static void dfs(ArrayList<Edge>[] graph){


        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    }


    public static void dfsUtil(ArrayList<Edge>[] graph, int src, boolean visited[]){
        System.out.print(src + " ");
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }



    public static void bfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, i, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();

        q.add(src);

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


    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(detectCycleUtil(graph, i, -1, visited)){
                    return true;
                }
            }
        }

        return false;
    }




    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, int parent, boolean visited[]){


        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                if(detectCycleUtil(graph, e.dest, curr, visited)){
                    return true;
                }
            }

            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
        }

        return false;

    }



    // bipatite 
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];

        for(int i=0; i<color.length; i++){
            color[i] = -1;
        }


        Queue<Integer> q = new LinkedList<>();

        
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.remove();

                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == color[curr]){
                            return false;
                        }

                        else if(color[e.dest] == -1){
                            int nextColor = color[curr] == 0 ? 1:0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }
                    }
                }
            }
        }

        return true;
    }


    public static boolean detectCycleDir(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i] && detectCycleDirUtil(graph, i, vis, stack)){
                return true;
            }
        }

        return false;
    }





    // cycle detection in directed graph helper function
    public static boolean detectCycleDirUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){

        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest]){
                return true;
            }

            else if(!vis[e.dest]){
                if(detectCycleDirUtil(graph, e.dest, vis, stack)){
                    return true;
                }
            }
        }


        stack[curr] = false;
        return false;

    }


    // Topological Sorting 
    // It is a linear order of vertices such that for every directed edge u-->v, u comes before v 

    public static void topologicalSort(ArrayList<Edge>[] graph){ // O(V + E)
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topologicalSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }

        s.add(curr);
    }


    public static void main(String arg[]){

        // now we will modify our dfs and bfs functions for the connected components of the graph 

        // first component of the graph 

        /* 
                            (5)
                        0 ------- 1
                                /   \
                           (1) /     \ (3)
                              /       \
                             2 ------- 3
                             |   (1)   |
                          (2)|         |(1)
                             |         |
                             4         5
         */


          // second component of the graph 


        /* 
                        6 ------ 7
                               /   \
                              /     \
                             8       9 
         */


        // third component of the graph 

        /*          
                        10 ---- 11
        */


        int v = 12;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }


        // first component
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
         graph[3].add(new Edge(3, 5, 1));
 
         // 4th vertex 
         graph[4].add(new Edge(4, 2, 2));
 
         // 5th vertex 
         graph[5].add(new Edge(5, 3, 1));
        

        // second component 
        graph[6].add(new Edge(6, 7, 2));
        
        graph[7].add(new Edge(7, 6, 2));
        graph[7].add(new Edge(7, 8, 1));
        graph[7].add(new Edge(7, 9, 3));

        graph[8].add(new Edge(8, 7, 1));

        graph[9].add(new Edge(9, 7, 1));


        // third component 
        graph[10].add(new Edge(10, 11, 1));
        graph[11].add(new Edge(11, 10, 1));


        dfs(graph);
        System.out.println();


        bfs(graph);
        System.out.println();


        // cycle detection in undirected graph 
        System.out.println(detectCycle(graph));


        // checking if a graph is bipatite or not 
        // bipatite means you can seprate every element into two groups such that neighbour are not in the same group

        System.out.println(isBipartite(graph));


        // cycle detection in directed graph
        // the approach is almost same as the for the undirected graph but we have to modify the code a little. 


        int dirV = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] DirGraph = new ArrayList[dirV];


        for(int i=0; i<DirGraph.length; i++){
            DirGraph[i] = new ArrayList<>();
        }

        DirGraph[0].add(new Edge(0, 2, 0));
        // DirGraph[0].add(new Edge(0, 1, 0));

        DirGraph[1].add(new Edge(1, 0, 0));

        DirGraph[2].add(new Edge(2, 3, 0));
        
        DirGraph[3].add(new Edge(3, 0, 0));


        System.out.println(detectCycleDir(DirGraph));



        // Topological sorting (only for Directed Acyclic Graph(DAG))
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

        topologicalSort(dag);

    }
}
