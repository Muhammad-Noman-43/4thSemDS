public class StackUsingArray<T>{
    T[] array;
    StackUsingArray(int n){
        T[] array = (T[]) new Object[n];
    }
    int top = -1;
    
    public void push(T data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        array[++top] = data;
    }
    
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        T data = array[top];
        array[top--] = null;
        return data;
    }
    
    public T peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return null;
        }
        return array[top];
    }
    
    private boolean isEmpty(){
        if(top == -1)
            return true;
        return false;
    }
    
    private boolean isFull(){
        if(top == array.length-1)
            return true;
        return false;
    }
}
