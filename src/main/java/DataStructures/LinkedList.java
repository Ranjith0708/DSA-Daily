package DataStructures;

public class LinkedList {

    Node node;

    LinkedList(int value){
        this.node = new Node(value,null);
    }

    void addNode(int value){
        Node node = new Node(value,null);
        this.node.next = node;
        this.node = node;
    }

    void addNodeAtStart(int value){
        Node node = new Node(value,this.node);
        this.node = node;
    }

    void display(){
        Node node = this.node;
        while (node!=null){
            if (node.next == null) {
                System.out.print(node.value);
            }else{
                System.out.print(node.value+"->");
            }
            node = node.next;
        }
    }


    public class Node{
        int value;
        Node next;
        
        Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

    }
}
