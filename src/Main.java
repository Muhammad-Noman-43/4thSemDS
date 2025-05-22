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
    
//        StackUsingLL<String> stack = new StackUsingLL<>();
//        stack.push("I");
//        stack.push("II");
//        stack.push("III");
//        stack.push("IV");
//        stack.pop();
//        System.out.println(stack.peek());
        
        
        // Testing NotationsWithStack class
//        NotationsWithStack n = new NotationsWithStack();
//        System.out.println(n.infixToPostfixConversion("(A^((B*C)/(D+E)))"));
//        System.out.println(n.infixToPrefixConversion("a*b/c^d%e+f-g*h"));
//        System.out.println(n.evalPostNotationM1(n.infixToPostfixConversion("((((2*(2^3))/9)-5)+(6%6))")));
//        System.out.println(n.evalPreNotationM1(n.infixToPrefixConversion("((((2*(2^3))/9)-5)+(6%6))")));
//        String s = "10 2 3 ^ * 20 / 10 - 1 6 % +";
//        String s2 ="+ - / * 10 ^ 2 3 20 10 % 1 6";
//        System.out.println(n.evalPostNotationM2(s));
//        System.out.println(n.evalPreNotationM2(s2));
        
        QueueUsingStack<Integer> q = new QueueUsingStack<>(10);
        q.enqueue(1);
        q.traverse();
        System.out.println("\n"+q.peek());
        q.enqueue(2);
        q.traverse();
        System.out.println("\n"+q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.traverse();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println();
        q.traverse();
        System.out.println("\n"+q.peek());
        
        
    }
}
