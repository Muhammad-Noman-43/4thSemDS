public class NotationsWithStack {
    
    // Used when infix notation has brackets according to precedence of operators
    String infixToPostfixConversion(String infixNotation){
        String convertedNotation = "";
        StackUsingArray<Character> s = new StackUsingArray<>(30);
        char ch = ' ';
        for(int i=0; i<infixNotation.length(); i++){
            ch = infixNotation.charAt(i);
            
            if (Character.isLetterOrDigit(ch))
                convertedNotation += ch;
            
            else if(ch == '(')
                s.push(ch);
            
            else if(ch == ')'){
                while(s.peek() != '('){
                    convertedNotation += s.pop();
                }
                s.pop();
            }
            
            else if(ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '%'){
//                Here, when we encounter operators with the same precedence, we have to go for the earlier one to be
//                added to the solved expression first and then the second one
                while(s.peek() != null && precedence(s.peek()) >= precedence(ch)){
                    convertedNotation += s.pop();
                }
                s.push(ch);
            }
        }
        
        while(s.peek() != null)
            convertedNotation += s.pop();
        
        return convertedNotation;
    }
    
    // Used when infix notation has brackets according to precedence of operators
    String infixToPrefixConversion(String infixNotation){
        String reversed = reversedString(infixNotation);
        String convertedNotation = "";
        StackUsingArray<Character> s = new StackUsingArray<>(30);
        char ch = ' ';
        for(int i=0; i<reversed.length(); i++){
            ch = reversed.charAt(i);
            
            if (Character.isLetterOrDigit(ch))
                convertedNotation += ch;
            
            else if(ch == '(')
                s.push(ch);
            
            else if(ch == ')'){
                while(s.peek() != '('){
                    convertedNotation += s.pop();
                }
                s.pop();
            }
            
            else if(ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '%'){
//                The difference between in2post and in2pre is this condition. Post uses >= while pre uses > only.
//                The reason is that prefix is reversed before applying this algorithm. So, when we encounter
//                operators with the same precedence, we have to go for the later one to be added to the solved
//                expression and not the first one.
                while(s.peek() != null && precedence(s.peek()) > precedence(ch)){
                    convertedNotation += s.pop();
                }
                s.push(ch);
            }
        }
        
        while(s.peek() != null)
            convertedNotation += s.pop();
        
        return reversedString(convertedNotation);
        
    }
    
    // Use for single digits only
    double evalPostNotationM1(String notation){
        StackUsingLL<Double> s = new StackUsingLL<>();
        for(int i=0; i<notation.length(); i++){
            char ch = notation.charAt(i);
            if(Character.isDigit(ch)){
                s.push(Double.parseDouble(ch+" ")); // parse func accepts only strings arguments (ch + " " = string)
            } else {
                double op2 = s.pop();
                double op1 = s.pop();
                s.push(calculate(ch, op1, op2));
            }
        }
        return s.pop();
    }
    
    //Use for multiple digits separated using empty space ' '
    double evalPostNotationM2(String notation){
        StackUsingLL<Double> s = new StackUsingLL<>();
       String[] str = notation.split(" ");
       for(int i=0; i<str.length; i++){
           if(Character.isDigit(str[i].charAt(0)))
               s.push(Double.parseDouble(str[i]));
           else{
               double op2 = s.pop();
               double op1 = s.pop();
               s.push(calculate(str[i].charAt(0), op1, op2));
           }
       }
       return s.pop();
    }
    
    // Use for single digits only
    double evalPreNotationM1(String notation){StackUsingLL<Double> s = new StackUsingLL<>();
        for(int i=notation.length()-1; i>=0; i--){
            char ch = notation.charAt(i);
            if(Character.isDigit(ch)){
                s.push(Double.parseDouble(ch+" "));
            } else {
                double op1 = s.pop();
                double op2 = s.pop();
                s.push(calculate(ch, op1, op2));
            }
        }
        return s.pop();
    }
    
    //Use for multiple digits separated using empty space ' '
    double evalPreNotationM2(String notation){
        StackUsingLL<Double> s = new StackUsingLL<>();
        String[] str = notation.split(" ");
        for(int i=str.length-1; i>=0; i--){
            if(Character.isDigit(str[i].charAt(0)))
                s.push(Double.parseDouble(str[i]));
            else{
                double op1 = s.pop();
                double op2 = s.pop();
                s.push(calculate(str[i].charAt(0), op1, op2));
            }
        }
        return s.pop();
    }
    
    double calculate(char operation, double op1, double op2){
       switch (operation){
           case '+':
               return op1 + op2;
           case '-':
               return op1 - op2;
           case '*':
               return op1 * op2;
           case '/':
               return op1 / op2;
           case '%':
               return op1 % op2;
           case '^':
               return Math.pow(op1, op2);
       }
       return 0.0;
    }
    
    String reversedString(String originalStr){
        StringBuilder reversedString = new StringBuilder();
        for(int i = originalStr.length()-1; i>=0; i--){
            if(originalStr.charAt(i) == '(')
                reversedString.append(')');
            else if(originalStr.charAt(i) == ')')
                reversedString.append('(');
            else
            reversedString.append(originalStr.charAt(i));
        }
        return reversedString.toString();
    }
    
    int precedence(char ch){
        switch (ch){
            case '^':
                return 3;
            case '*', '%', '/':
                return 2;
            case '+', '-':
                return 1;
        }
        return 0;
    }
}
