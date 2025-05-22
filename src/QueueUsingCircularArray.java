public class QueueUsingCircularArray <T> {
    T[] arr;
    int head = -1, tail = -1, noOfElements = 0;
    
    QueueUsingCircularArray(int size){
        arr = (T[]) new Object[size];
    }
    
    boolean isEmpty(){
        return noOfElements == 0;
    }
    
    boolean isFull(){
        return noOfElements == arr.length;
    }
    
    void enqueue(T data){
        if(isFull()){
            System.out.println("Queue is full. Can't enqueue");
            return;
        }
        if(isEmpty()){
            head = ++head % arr.length;
            arr[head] = data;
        }
        tail = ++tail % arr.length;
        arr[tail] = data;
        noOfElements++;
    }
    
    T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to dequeue.");
            return null;
        }
        
        T data = arr[head];
        arr[head] = null;
        // Head is passed near to tail so that if there were two elements, both can be at the same index after
        // de-queueing the first element
        head = ++head % arr.length;
        if(noOfElements == 2)
            tail = ++tail % arr.length;
        noOfElements--;
        return data;
    }
    
    T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to peek.");
            return null;
        }
        return arr[head];
    }
    
    void traverse(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to traverse.");
            return;
        }
        
        for(int i = head;; i = ++i % arr.length){
            System.out.print(arr[i] + " ");
            if(i == tail)
                break;
        }
    }
}
