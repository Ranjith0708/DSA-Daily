package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList(5);
//        linkedList.addNodeAtStart(4);
//        linkedList.addNodeAtStart(3);
//        linkedList.addNodeAtStart(2);
//        linkedList.addNodeAtStart(1);
//        linkedList.display();
//        int[][] A = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
//        checkArray(A);
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        nums.add(6);
//        nums.add(7);
//        nums.add(8);
//        List<Integer> res = reverse_array(nums);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.print(res.get(i)+" ");
//        }
//        threadEg();
//        Graph graph = new Graph();
//        graph.addEdge(1,2);
//        graph.addEdge(1,3);
//        graph.addEdge(2,6);
//        graph.addEdge(3,4);
//        graph.addEdge(3,7);
//        graph.addEdge(4,8);
//        graph.addEdge(7,8);
//        ArrayList<Integer> ls = graph.breathFirstSearch(7);
//        for(int node : ls){
//            System.out.print(node+"->");
//        }
        Graph2 graph2 = new Graph2();
//       graph2.addNode(1,2);
//       graph2.addNode(1,6);
//       graph2.addNode(2,3);
//       graph2.addNode(2,4);
//       graph2.addNode(6,7);
//       graph2.addNode(6,8);
//       graph2.addNode(7,5);
//       graph2.addNode(4,5);
        //g2
//        graph2.addNode(1,2);
//        graph2.addNode(1,3);
//        graph2.addNode(2,5);
//        graph2.addNode(2,6);
//        graph2.addNode(3,7);
//        graph2.addNode(3,4);
//        graph2.addNode(4,8);
//        graph2.addNode(7,8);
        //g3
        graph2.addNode(0,4);
        graph2.addNode(0,5);
        graph2.addNode(1,0);
        graph2.addNode(1,2);
        graph2.addNode(2,0);
        graph2.addNode(2,3);
        graph2.addNode(3,0);
        graph2.addNode(3,1);
        graph2.addNode(4,2);
        graph2.addNode(4,4);
        graph2.printGraph();
        graph2.dfsRec(0);
//        List<Integer> bfs = graph2.DFS(1);
//        for(int node : bfs){
//            System.out.print(node+" ");
//        }

    }

    public static void checkArray(int[][] mat){
        // code here
        int[][] temp = mat;
        mat=new int[temp.length][temp.length];
        int fixed_index = 0;
        for(int a=0;a<mat.length;a++){
            for(int b=0;b<mat.length;b++){
                int  tsi = mat.length-1;
                int msi = 0;
                System.out.println("B["+fixed_index+"]["+(msi+b)+"]=A["+(tsi-b)+"]["+fixed_index+"]");
                mat[fixed_index][msi+b] = temp[tsi-b][fixed_index];
            }
            fixed_index++;
        }
        for (int i = 0; i <mat.length ; i++) {
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();

        }
    }

    public static List<Integer> reverse_array(List<Integer> a){
        int l=0;
        int r=a.size()-1;
        while (l<r){
            int temp = a.get(l);
            a.set(l, a.get(r));
            a.set(r,temp);
            l++;
            r--;
        }
        return a;
    }

    public static void threadEg(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int taskID = i;
            executorService.submit(()->{
                System.out.println("Executing task ID"+taskID+" of name"+Thread.currentThread().getName());
            });

        }
//        executorService.shutdown();
    }



}
