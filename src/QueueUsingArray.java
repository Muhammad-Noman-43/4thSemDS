public class QueueUsingArray<G>{
    G[] arr;
    
    QueueUsingArray(int size){
        arr = (G[]) new Object[size];
    }
    
    int tail = -1;
    
    void enqueue(G data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        
        arr[++tail] = data;
    }
    
    // This executes in O(n)
    G dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        
        G data = arr[0];
        arr[0] = null;
        for(int i = 0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        tail--;
        
        return data;
    }
    
    G peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        
        return arr[0];
    }
    
    boolean isEmpty(){
        if(tail == -1)
            return true;
        return false;
    }
    
    boolean isFull(){
        if(tail == arr.length-1)
            return true;
        return false;
    }
    
    void traverse(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
