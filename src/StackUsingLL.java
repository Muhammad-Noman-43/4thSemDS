public class StackUsingLL<T>{
    class Node{
        T data;
        Node next;
    }
    private Node top = null;
    
    public void push(T data){
        Node n = new Node();
        n.data = data;
        n.next = top;
        top = n;
    }
    
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    
    public T peek(){
        if(isEmpty()) {
            System.out.println("Stack underflow");
            return null;
        }
        T data = top.data;
        return data;
    }
    
    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }
}
