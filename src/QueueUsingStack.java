public class QueueUsingStack <T>{
    T[] arr;
    StackUsingArray<T> s1, s2;
    
    QueueUsingStack(int size){
        arr = (T[]) new Object[size];
        s1 = new StackUsingArray<>(size);
        s2 = new StackUsingArray<>(size);
    }
    
    
    void enqueue(T data){
        if(isEmpty()){
            s1.push(data);
            return;
        }
        
        while(!s1.isEmpty())
            s2.push(s1.pop());
        
        s1.push(data);
        
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }
    
    T dequeue(){
        if(isEmpty()){
            System.out.println("Queue empty. Nothing to dequeue.");
            return null;
        }
        
        return s1.pop();
    }
    
    T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to peek.");
            return null;
        }
        
        return s1.peek();
    }
    
    boolean isEmpty(){
        return s1.isEmpty();
    }
    
    boolean isFull(){
        return s1.isFull();
    }
    
    void traverse(){
        if(isEmpty()){
            System.out.print("Queue is empty. Nothing to traverse.");
            return;
        }
        
        while (!s1.isEmpty()){
            T data = s1.pop();
            s2.push(data);
            System.out.print(data + " ");
        }
        
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        System.out.println();
    }
}
