public class ListExample {

    public static void main(String args[]){
        List l = new List();
        l.print();
        l.remove();
        l.add(new Node(2));
        l.add(new Node(4));
        l.print();
        l.remove();
        l.add(new Node(6));
        l.print();
        l.remove();
        l.print();
        l.remove();
    }

}

class List {
    private int size=0;
    private Node head = null;
    
    public boolean add(Node node){
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
        return true;
    }

    public boolean remove(){
        if (size ==0) {
           System.out.println("List empty. can't remove anything");         
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
        return true;
    }

    void print(){
        Node temp = head;
        if (temp == null){
             System.out.println("List empty. Nothing to display");                 
             return;
        }
        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;        
        }
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
