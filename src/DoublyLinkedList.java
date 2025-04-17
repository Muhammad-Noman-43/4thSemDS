public class DoublyLinkedList <T>{
    private class Node{
        T data;
        Node next;
        Node prev;
    }
    
    private Node start = null;
    private Node end = null;
    
    public void insertAtStart(T data){
        Node n = new Node();
        n.data = data;
        n.prev = null;
        
        if(start == null){
            start = n;
            end = n;
        } else {
            start.prev = n;
            n.next = start;
            start = n;
        }
    }
    
    public void insertAtEnd(T data){
        Node n = new Node();
        n.data = data;
        n.next = null;
        n.prev = null;
        
        if(start == null){
            start = n;
        } else {
            n.prev = end;
            end.next = n;
        }
        end = n;
    }
    
    public T deleteAtStart(){
        T data = start.data;
        if(start == null){
            System.out.println("List is already empty");
            return null;
        } else if (start == end){
            start = null;
            end = null;
        } else {
            start = start.next;
            start.prev = null;
        }
        return data;
    }
    
    public T deleteAtEnd(){
        T data = end.data;
        if(start == null){
            System.out.println("List is already empty");
            return null;
        } else if (start == end){
            start = null;
            end = null;
        } else {
            end = end.prev;
            end.next = null;
        }
        return data;
    }
    
    public void traverse(){
        Node temp = start;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    
    public boolean search(T data){
        Node t = start;
        while(t != null){
            if(data == t.data)
                return true;
            t = t.next;
        }
        return false;
    }
}
