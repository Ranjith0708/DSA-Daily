package DataStructures;

import java.util.*;
import java.util.LinkedList;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;
    public Graph(){
        adjacencyList = new HashMap<>();
    }
    public void addVertex(int vertex){
        adjacencyList.putIfAbsent(vertex,new ArrayList<>());
    }

    public void addEdge(int source,int destination){
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void printGraph(){
        for(var entry: adjacencyList.entrySet()){
            System.out.println(entry.getKey() +" --> "+entry.getValue());
        }
    }

    public ArrayList<Integer> breathFirstSearch(int vertex){
        ArrayList<Integer> bfs = new ArrayList<>();
        int count=0;
        Queue<Integer> vertexQueue = new LinkedList<>();
        boolean[] visitedArray = new boolean[adjacencyList.size()+1];
        visitedArray[vertex]=true;
        List<Integer> vertexes = adjacencyList.get(vertex);
        bfs.add(vertex);
        for(Integer vertexVal : vertexes){
            vertexQueue.add(vertexVal);
        }
        while(vertexQueue.size()>0){
            Integer currentVertex = vertexQueue.remove();
            if(!visitedArray[currentVertex]){
                bfs.add(currentVertex);
                visitedArray[currentVertex] = true;
                List<Integer> childVertex = adjacencyList.get(currentVertex);
                for(Integer vertexVal : childVertex){
                    vertexQueue.add(vertexVal);
                }
            }
        }

        for(Integer v:bfs){
            count++;
            if(count==bfs.size()){
                System.out.print(v);
            }else{
                System.out.print(v+"-->");
            }
        }
        return bfs;

    }
    public static void main(String[] args) {
        //creating graph
        Map<Integer,ArrayList<Pair>> map = new HashMap<>();
        ArrayList<Pair> pairsLs1 = new ArrayList<>();
        ArrayList<Pair> pairsLs2 = new ArrayList<>();
        ArrayList<Pair> pairsLs3 = new ArrayList<>();
        ArrayList<Pair> pairsLs4 = new ArrayList<>();
        ArrayList<Pair> pairsLs5 = new ArrayList<>();
        ArrayList<Pair> pairsLs6 = new ArrayList<>();
        ArrayList<Pair> pairsLs7 = new ArrayList<>();
        ArrayList<Pair> pairsLs8 = new ArrayList<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <9; i++) {
            adj.add(new ArrayList<>());
        }

        pairsLs1.add(new Pair(2,2));
        pairsLs1.add(new Pair(6,3));
        map.put(1,pairsLs1);

        pairsLs2.add(new Pair(1,6));
        pairsLs2.add(new Pair(4,1));
        pairsLs2.add(new Pair(3,2));
        map.put(2,pairsLs2);

        pairsLs3.add(new Pair(2,3));
        map.put(3,pairsLs3);

        pairsLs4.add(new Pair(2,1));
        pairsLs4.add(new Pair(5,3));
        map.put(4,pairsLs4);

        pairsLs5.add(new Pair(7,6));
        pairsLs5.add(new Pair(4,3));
        map.put(5,pairsLs5);

        pairsLs6.add(new Pair(7,7));
        pairsLs6.add(new Pair(1,1));
        pairsLs6.add(new Pair(8,8));
        map.put(6,pairsLs6);

        pairsLs7.add(new Pair(6,6));
        pairsLs7.add(new Pair(5,5));
        map.put(7,pairsLs7);

        pairsLs8.add(new Pair(6,6));
        map.put(8,pairsLs8);


        ArrayList<ArrayList<Pair>> adj1 = createGraph(adj,map);
        ArrayList<Boolean> visitedNodes = new ArrayList<>();
        for(int i=0;i<9;i++){
            visitedNodes.add(false);
        }
        showNodeDetails(adj1,8);
        ArrayList<Integer> BFS = BFS(1,adj1,visitedNodes);
        for (Integer i:BFS) {
            System.out.print(i+" ");
        }
    }
    public static ArrayList<ArrayList<Pair>> createGraph(ArrayList<ArrayList<Pair>> adj,Map<Integer,ArrayList<Pair>> map) {
        for (Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()){
            ArrayList<Pair> pairs = entry.getValue();
            for(Pair pair :pairs){
                adj.get(entry.getKey()).add(pair);
            }

        }
        return  adj;
    }

    public static void showNodeDetails(ArrayList<ArrayList<Pair>> adj,int node){
        ArrayList<Pair> pairs = adj.get(node);
        for(Pair pair : pairs){
            System.out.println(node+" --> "+pair.node);
//            System.out.println("Node "+node+" is connected to "+pair.node+" and its weight is "+pair.weight);
        }
    }
    public static ArrayList<Integer> BFS(int node,ArrayList<ArrayList<Pair>> adjList,ArrayList<Boolean> visitedNodes){
        ArrayList<Integer> bfs = new ArrayList<>();
        visitedNodes.add(node,true);
        Queue<Integer> nodesQueue = new LinkedList();
        bfs.add(node);
        for(Pair pair : adjList.get(node)){
            nodesQueue.add(pair.node);
        }
        while (nodesQueue.size()>0){
            Integer adjNode = nodesQueue.remove();
            if(!visitedNodes.get(adjNode)){
                visitedNodes.set(adjNode,true);
                bfs.add(adjNode);
                for(Pair pair : adjList.get(adjNode)){
                    if(!visitedNodes.get(pair.node)){
                        nodesQueue.add(pair.node);
                    }
                }
            }
        }
        return bfs;
    }
    public static class Pair{
        int node;
        int weight;

        public Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
}
