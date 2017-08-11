package com.interview.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T>{

    private final List<Edge<T>> allEdges;
    private final Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;
    
    public Graph(boolean isDirected){
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        allEdges.addAll(vertex.getEdges());
    }
    
    public void addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            allVertex.get(id);
            return;
        }
        Vertex<T> v = new Vertex<>(id);
        allVertex.put(id, v);
    }
    
    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }
    
    public void addEdge(long id1,long id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public void setDataForVertex(long id, T data){
//        if(allVertex.containsKey(id)){
//            Vertex<T> vertex = allVertex.get(id);
//            vertex.setData(data);
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1()).append(" ").append(edge.getVertex2()).append(" ").append(edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}


class Vertex<T> {
    final long id;
    private T data;
    private final List<Edge<T>> edges = new ArrayList<>();
    private final List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public T getData(){
//        return data;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        return id == other.id;
    }
}

class Edge<T>{
    private boolean isDirected = false;
    private final Vertex<T> vertex1;
    private final Vertex<T> vertex2;
    private int weight;
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
//        this.vertex1 = vertex1;
//        this.vertex2 = vertex2;
//        this.isDirected = isDirected;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    Vertex<T> getVertex1(){
        return vertex1;
    }
    
    Vertex<T> getVertex2(){
        return vertex2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}

 