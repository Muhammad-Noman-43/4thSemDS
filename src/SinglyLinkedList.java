public class SinglyLinkedList<T>{
    protected class Node{
        T data;
        Node next;
    }
//    Using head, top or any other names to denote the first element should be avoided.
//    As such terms are specific for other DS (Similarly, LL uses start for first node)
    private Node start = null;
    private Node end = null;
    
    public void insertAtStart(T nodeValue){
        Node n = new Node();
        n.data = nodeValue;
        n.next = start;
        if(start == null)
            end = n;
        start = n;
        System.out.println("Value inserted at start in LinkedList");
    }
    
    // INSERT AT END
    // Method 1
    public void insertAtEndM1(T nodeValue){
        Node n = new Node();
        n.data = nodeValue;
        n.next = null;
        
        if(start == null)
            start = n;
        else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        
        System.out.println("Value inserted at end in LinkedList");
    }
    
    // Method 2 (Use the END ode)
    public void insertAtEndM2(T data){
        Node n = new Node();
        n.data = data;
        n.next = null;
        if(start == null){
            start = n;
        } else {
            end.next = n;
        }
            end = n;
        
    }
    
    // To delete any node from LL, simply remove its reference (GC will do the rest)
    public T deleteAtStart(){
        if(start == null){
            System.out.println("List is already empty");
            return null;
        } else if(start == end){
            T data = start.data;
            start = null;
            end = null;
            return data;
        } else {
            T data = start.data;
            start = start.next;
            System.out.println("Value deleted: "+data);
            return data;
        }
    }
    
    //You can also use 2 vars to store the address of the last and the second last Node
    // DELETE AT END
    // Method 1 (Method 2 needs a doubly linked list)
    public T deleteAtEnd(){
        if(start == null){
            System.out.println("List is already empty");
            return null;
        } else if (start.next == null) { // Condition is the same as (start == end)
            T data = start.data;
            start = null;
            end = null;
            System.out.println("Item at end deleted: "+data);
            return data;
        } else {
            Node temp = start;
            while((temp.next).next != null){
                temp = temp.next;
            }
            T data = temp.next.data;
            System.out.println("Item at end deleted: "+data);
            temp.next = null;
            return data;
        }
    }
    
    public void traverse(){
        Node temp = start;
        if(start == null){
            System.out.println("List is empty");
        }
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println();
    }
    
    public boolean search(T target){
        Node temp = start;
        if(start == null)
            return false;
        else{
            while(temp.next != null){
                if(temp.data == target)
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }
}
