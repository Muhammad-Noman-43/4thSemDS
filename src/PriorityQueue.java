public class PriorityQueue <D>{
    QueueUsingArray<D> q1 = new QueueUsingArray<>(10);
    QueueUsingArray<D> q2 = new QueueUsingArray<>(10);
    QueueUsingArray<D> q3 = new QueueUsingArray<>(10);
    QueueUsingArray<D> q4 = new QueueUsingArray<>(10);
    
    void enqueue(D data, int priority){
        if(priority == 1)
            q1.enqueue(data);
        else if(priority == 2)
            q2.enqueue(data);
        else if(priority == 3)
            q3.enqueue(data);
        else if(priority == 4)
            q4.enqueue(data);
    }
    
    D dequeue(){
        if(!q1.isEmpty())
            return q1.dequeue();
        else if(!q2.isEmpty())
            return q2.dequeue();
        else if(!q3.isEmpty())
            return q3.dequeue();
        else if(!q4.isEmpty())
            return q4.dequeue();
        else
            return null;
    }
    
    D peek(){
        if(!q1.isEmpty())
            return q1.peek();
        else if(!q2.isEmpty())
            return q2.peek();
        else if(!q3.isEmpty())
            return q3.peek();
        else if(!q4.isEmpty())
            return q4.peek();
        else
            return null;
    }
    
    // Don't know if they are necessary but...
    boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty() && q3.isEmpty() && q4.isEmpty();
    }

    boolean isFull(){
        return q1.isFull() && q2.isFull() && q3.isFull() &&q4.isFull();
    }
}
