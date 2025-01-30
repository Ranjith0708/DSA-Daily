package DataStructures;

import java.util.*;
import java.util.LinkedList;

public class Graph2 {
     private Map<Integer, List<Integer>> adjList;

     Graph2(){
          adjList = new HashMap<>();
     }
     public void addVertex(int node){
         adjList.putIfAbsent(node,new ArrayList<>());
     }
      public void addNode(int source,int destination){
         addVertex(source);
         addVertex(destination);
         adjList.get(source).add(destination);
         adjList.get(destination).add(source);
      }

      public void printGraph(){
         for(var entry : adjList.entrySet()){
             System.out.println(entry.getKey()+"->"+entry.getValue());
         }
      }

      public List<Integer> BFS(int node){
         boolean[] visitedVertex = new boolean[adjList.size()+1];
         List<Integer> bfs = new ArrayList<>();
         Queue<Integer> vertexQueue = new LinkedList<>();
         List<Integer> vertices = adjList.get(node);
         for(int vertex : vertices){
             vertexQueue.offer(vertex);
         }
         vertices.clear();
         bfs.add(node);
         visitedVertex[node] = true;
         while(vertexQueue.size()>0){
             int currentVertex = vertexQueue.poll();
             vertices = adjList.get(currentVertex);
             for(int vertex : vertices){
                 if(!visitedVertex[vertex]){
                     vertexQueue.offer(vertex);
                 }
             }
             if(!visitedVertex[currentVertex]){
                 bfs.add(currentVertex);
                 visitedVertex[currentVertex] = true;
             }
         }
         return bfs;
      }

      public List<Integer> DFS(int node){
         boolean[] visitedArray = new boolean[adjList.size()+1];
         Stack<Integer> vertexStack = new Stack<>();
         List<Integer> vertices = adjList.get(node);
         List<Integer> dfs = new ArrayList<>();
         for(int vertex : vertices){
             vertexStack.push(vertex);
         }
         dfs.add(node);
         vertices.clear();
         visitedArray[node] = true;
         while ((vertexStack.size()>0)){
             int currentVertex = vertexStack.pop();
             vertices = adjList.get(currentVertex);
             for(int vertex : vertices){
                 if(!visitedArray[vertex]){
                     vertexStack.push(vertex);
                 }
             }
             if(!visitedArray[currentVertex]){
                 dfs.add(currentVertex);
                 visitedArray[currentVertex] = true;
             }
         }
         return dfs;
      }
}
