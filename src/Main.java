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
        NotationsWithStack n = new NotationsWithStack();
        System.out.println(n.infixToPostfixConversion("((((a*(b^c))/d)-e)+(f%g))"));
        System.out.println(n.infixToPrefixConversion("((((a*(b^c))/d)-e)+(f%g))"));
        System.out.println(n.evalPostNotationM1(n.infixToPostfixConversion("((((2*(2^3))/9)-5)+(6%6))")));
        System.out.println(n.evalPreNotationM1(n.infixToPrefixConversion("((((2*(2^3))/9)-5)+(6%6))")));
        String s = "10 2 3 ^ * 20 / 10 - 1 6 % +";
        String s2 ="+ - / * 10 ^ 2 3 20 10 % 1 6";
        System.out.println(n.evalPostNotationM2(s));
        System.out.println(n.evalPreNotationM2(s2));
        
    }
}
