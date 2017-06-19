public class StackExample {

    public static void main(String args[]){
        Stack s = new Stack();
        s.pop();
        s.push(new Node(2));
        s.push(new Node(4));
        s.push(new Node(6));
        s.push(new Node(8));
        s.pop();
        s.pop();
        s.pop();
        s.push(new Node(10));
        s.pop();
        s.pop();
    }

}

class Stack {
    private int size=0;
    private Node head = null;
    
    public boolean push(Node node){
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

    public boolean pop(){
        if (size ==0) {
           System.out.println("Stack empty. can't remove anything");         
           return false;       
        }
        Node temp = head;
        Node deleted = null;
        if(temp.next == null){
            deleted = head;
            head = null;
        } else {
            while(temp.next.next !=null){
                 temp = temp.next;
            }
            deleted = temp.next;
            temp.next = null;
        }
        System.out.println("Deleted :"+deleted);
        size --;
        print();
        return true;
    }

    void print(){
        Node temp = head;
        if (temp == null){
             System.out.println("Stack empty. Nothing to display");                 
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
