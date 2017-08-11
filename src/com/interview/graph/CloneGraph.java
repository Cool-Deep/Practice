package com.interview.graph;

import java.util.*;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//// * https://leetcode.com/problems/clone-graph/
//// */
////public class CloneGraph {
////
////    class UndirectedGraphNode {
////        final int label;
////        final List<UndirectedGraphNode> neighbors;
////        // --Commented out by Inspection (8/10/17, 5:13 PM):UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
////     }
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//////        if (node == null) {
//////            return null;
//////        }
//////        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
//////        Set<Integer> visited = new HashSet<>();
//////        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
//////        map.put(clone.label, clone);
//////        dfs(node, clone, map, visited);
//////        return clone;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private void dfs(UndirectedGraphNode current, UndirectedGraphNode clone, Map<Integer, UndirectedGraphNode> map,  Set<Integer> visited) {
////        if (visited.contains(current.label)) {
////            return;
////        }
////        visited.add(current.label);
////        for (UndirectedGraphNode adj : current.neighbors) {
////            if (adj.label != current.label) {
////                UndirectedGraphNode adjClone = map.get(adj.label);
////                if (adjClone == null) {
////                    adjClone = new UndirectedGraphNode(adj.label);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//                    map.put(adjClone.label, adjClone);
//                }
//                clone.neighbors.add(adjClone);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
                dfs(adj, adjClone, map, visited);
            } else {
                clone.neighbors.add(clone);
            }
        }
    }
}
