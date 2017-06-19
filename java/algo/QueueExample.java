public class QueueExample {

    public static void main(String args[]){
        Queue s = new Queue();
        s.dequeue();
        s.enqueue(new Node(2));
        s.enqueue(new Node(4));
        s.enqueue(new Node(6));
        s.enqueue(new Node(8));
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.enqueue(new Node(10));
        s.dequeue();
        s.dequeue();
    }
}

class Queue {
    private int size=0;
    private Node head = null;
    
    public boolean enqueue(Node node){
        if(head == null){
            head = node;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
        System.out.println("Added :"+node);
        size++;
        print();
        return true;
    }

    public boolean dequeue(){
        if (size ==0) {
           System.out.println("Queue empty. can't remove anything");         
           return false;       
        }
        Node deleted = head;
        head = head.next;
        System.out.println("Deleted :"+deleted);
        size --;
        print();
        return true;
    }

    void print(){
        Node temp = head;
        if (temp == null){
             System.out.println("Queue empty. Nothing to display");                 
             return;
        }
        while(temp!=null){
            System.out.print(temp+" ");
            temp = temp.next;        
        }
        System.out.println();
    }

}

class Node {
    int data;
    Node next;

    public Node(int x){
       data = x;
       next = null;
    }
 
    public Node(){
        data = -999;
        next = null;
    }
    
    public String toString(){
        return ""+data+"";
    }
}
