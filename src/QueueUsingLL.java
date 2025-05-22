public class QueueUsingLL <G>{
    
    class Node{
        G data;
        Node next;
    }
    
    Node tail = null, head = null;
    
    void enqueue(G data){
        Node n = new Node();
        n.data = data;
        if(isEmpty()){
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
    }
    
    G dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to dequeue.");
            return null;
        }
        
        G data = head.data;
        if(head == tail){
            head = null;
            tail = null;
        }
        
        head = head.next;
        return data;


    }
    
    G peek(){
        if(isEmpty()){
            System.out.println("Nothing to peek.");
            return null;
        }
        
        return head.data;
    }
    
    boolean isEmpty() {
        return head == null;
    }
    
    void traverse(){
        if(isEmpty()){
            System.out.println("Nothing to traverse.");
            return;
        }
        
        Node temp = head;
        while(temp != tail){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
