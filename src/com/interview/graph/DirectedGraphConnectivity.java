package com.interview.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class DirectedGraphConnectivity {

    private boolean scc(Graph<Integer> graph) {
        Deque<Vertex<Integer>> stack = new ArrayDeque<>();
        Map<Vertex<Integer>, Boolean> visited = new HashMap<>();
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.containsKey(vertex)) {
                continue;
            }
            DFSUtil(vertex, visited, stack);
        }

        System.out.println(stack);
        
        Graph<Integer> reverseGraph = new Graph<>(true);
        Map<Long, Vertex<Integer>> vertexMap = new HashMap<>();
        for (Edge<Integer> edge : graph.getAllEdges()) {
            reverseGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1()
                    .getId(), edge.getWeight());
        }
        
        for (Vertex<Integer> vertex : reverseGraph.getAllVertex()) {
            vertexMap.put(vertex.getId(), vertex);
        }
        
        visited.clear();
        Vertex<Integer> vertex = vertexMap.get(stack.poll().getId());
        DFSUtil1(vertex, visited);
        
        for(Vertex<Integer> testVertex : reverseGraph.getAllVertex()){
            if(!visited.containsKey(testVertex)){
                return false;
            }
        }
        return true;
    }

    private void DFSUtil(Vertex<Integer> vertex,
            Map<Vertex<Integer>, Boolean> visited, Deque<Vertex<Integer>> stack) {
        visited.put(vertex, true);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.containsKey(v)) {
                continue;
            }
            DFSUtil(v, visited, stack);
        }
        stack.offerFirst(vertex);
    }

    private void DFSUtil1(Vertex<Integer> vertex,
            Map<Vertex<Integer>, Boolean> visited) {
        visited.put(vertex, true);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.containsKey(v)) {
                continue;
            }
            DFSUtil1(v, visited);
        }
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 0);
        graph.addEdge(2,1);
        graph.addEdge(0,2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        
        DirectedGraphConnectivity scc = new DirectedGraphConnectivity();
        boolean result = scc.scc(graph);
        System.out.println(result);
    }
}
