public class NotationsWithStack {
    
    // Used when infix notation has brackets according o precedence of operators
    String infixToPostfixConversion(String infixNotation){
        String convertedNotation = "";
        StackUsingArray<Character> s = new StackUsingArray<>(30);
        
        for(int i=0; i<infixNotation.length(); i++){
            char ch = infixNotation.charAt(i);
            
            if (Character.isLetterOrDigit(ch))
                convertedNotation += ch;
            
            else if(ch == ')'){
                while(s.peek() != '('){
                    convertedNotation += s.pop();
                }
                s.pop();
            }
            
            else
                s.push(ch);
        }
        return convertedNotation;
    }
    
    // Used when infix notation has brackets according o precedence of operators
    String infixToPrefixConversion(String infixNotation){
        return reversedString(infixToPostfixConversion(reversedString(infixNotation)));
    }
    
    // Use for single digits only
    double evalPostNotationM1(String notation){
        StackUsingLL<Double> s = new StackUsingLL<>();
        for(int i=0; i<notation.length(); i++){
            char ch = notation.charAt(i);
            if(Character.isDigit(ch)){
                s.push(Double.parseDouble(ch+" "));
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
}
