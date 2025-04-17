public class CircularLinkedList <T>{
    class Node{
        T data;
        Node next;
        Node prev;
    }
    
    Node start = null;
    
    public void insertAtStart(T data){
        Node n = new Node();
        n.data = data;
        
        if(start == null){
            start = n;
            n.next = start;
            n.prev = start;
        } else {
            n.next = start;
            n.prev = start.prev;
            start.prev.next = n;
            start.prev = n;
            start = n;
        }
    }
    
    public void insertAtEnd(T data){
        Node n = new Node();
        n.data = data;
        
        if(start == null){
            start = n;
            n.next = start;
            n.prev = start;
        } else {
            n.next = start;
            n.prev = start.prev;
            start.prev.next = n;
            start.prev = n;
        }
    }
    
    public T deleteAtStart(){
        if(start == null){
            System.out.println("List is already empty");
            return null;
        } else {
            T data = start.data;
            if(start.next == start){
                start = null;
                return data;
            }
            
            start.next.prev = start.prev;
            start.prev.next = start.next;
            start = start.next;
            
            return data;
        }
    }
    
    public T deleteAtEnd(){
        start = start.prev;
        return deleteAtStart();
    }
    
    
    public void traverse(){
        Node temp = start;
        System.out.print(temp.data + " -> ");
        temp = temp.next;
        while(temp != start){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    
    public boolean search(T data){
        if(start == null){
            System.out.println("List is empty");
            return false;
        }
        Node temp = start;
        if(data == temp.data)
            return true;
        
        temp = temp.next;
        while(temp != start){
            if(data == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }
}
