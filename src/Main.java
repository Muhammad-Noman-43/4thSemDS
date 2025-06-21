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
        
//        QueueUsingCircularArray<Integer> q = new QueueUsingCircularArray<>(4);
//        q.enqueue(1);
//        q.traverse();
//        System.out.println("\n"+q.peek());
//        q.enqueue(2);
//        q.traverse();
//        System.out.println("\n"+q.peek());
//        System.out.println(q.dequeue());
//        System.out.println(q.peek());
//        q.traverse();
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.enqueue(6);
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        q.traverse();
//        System.out.println("\n"+q.peek());
        
//        PriorityQueue<Integer> p = new PriorityQueue<>();
//        p.enqueue(10, 1);
//        p.enqueue(20, 2);
//        p.enqueue(30, 3);
//        p.enqueue(50, 4);
//        p.enqueue(60, 1);
//        p.enqueue(70, 2);
//        p.dequeue();
//        System.out.println(p.peek());
//        p.dequeue();
//        System.out.println(p.peek());
//        System.out.println(p.isEmpty());
//        System.out.println(p.isFull());
        
        AVL_Tree b = new AVL_Tree();
        b.insert(5);
        b.insert(4);
        b.insert(3);
        b.levelOrderTraversal();
        b.insert(2);
        
//        System.out.println("In-Order");
//        b.inOrderTraversal();
//        System.out.println("\nPre-Order");
//        b.preOrderTraversal();
//        System.out.println("\nPost-Order");
//        b.postOrderTraversal();
//        System.out.println("\nLevel Order");
//        b.levelOrderTraversal();
        
        b.insert(1);
        b.insert(1);
        b.insert(1);
//        b.insert(0);
//        b.insert(-1);
//        b.insert(6);
//        b.insert(8);
//        b.insert(11);
//        b.insert(19);
//        b.insert(13);
//        b.insert(1);
//        b.insert(14);
//        b.insert(15);
//        b.insert(17);
        b.levelOrderTraversal();
        
//        b.delete(12);
//        b.delete(11);
//        b.delete(4);
//        b.levelOrderTraversal();
        
        b.search(3);
    }
}
