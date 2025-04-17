public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList<Integer> LL = new SinglyLinkedList<>();
//        LL.insertAtEndM1(2);
//        LL.insertAtStart(4);
//        LL.insertAtStart(5);
//        LL.traverse();
        
//        CircularLinkedList<String> n = new CircularLinkedList<>();
//        n.insertAtEnd("Noman");
//        n.insertAtStart("Khan");
//        n.insertAtStart("Muhammad");
//        System.out.println(n.deleteAtStart());
//        System.out.println(n.deleteAtEnd());
//        n.traverse();
//        System.out.print("\n" + n.search("Khan"));
    
        StackUsingLL<String> stack = new StackUsingLL<>();
        stack.push("I");
        stack.push("II");
        stack.push("III");
        stack.push("IV");
        stack.pop();
        System.out.println(stack.peek());
        
    }
}
