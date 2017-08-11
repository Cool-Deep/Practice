package com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
class GraphTraversal {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public void DFS(Graph<Integer> graph){
//        Set<Long> visited = new HashSet<Long>();
//        for(Vertex<Integer> vertex : graph.getAllVertex()){
//            if(!visited.contains(vertex.getId())){
//                DFSUtil(vertex,visited);
//            }
//        }
//
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private void DFSUtil(Vertex<Integer> v,Set<Long> visited){
        visited.add(v.getId());
        System.out.print(v.getId() + " ");
        for(Vertex<Integer> vertex : v.getAdjacentVertexes()){
            if(!visited.contains(vertex.getId()))
                DFSUtil(vertex,visited);
        }
    }
    
    private void BFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<Integer>> q = new LinkedList<>();
        
        for(Vertex<Integer> vertex: graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                q.add(vertex);
                visited.add(vertex.getId());
                while(q.size() != 0){
                    Vertex<Integer> vq = q.poll();
                    System.out.print(vq.getId()+ " ");
                    for(Vertex<Integer> v : vq.getAdjacentVertexes()){
                        if(!visited.contains(v.getId())){
                            q.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }
        
    }
    
    
    public static void main(String args[]){
        
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3);
        
        GraphTraversal g = new GraphTraversal();
        g.BFS(graph);
    }
}
