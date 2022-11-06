public class Main {
    public static void main(String[] args) {
        String exp1 = " )(( )){([( )])}";
        String exp2 = "()";
        String expr = "a+b";
        System.out.println((infixToPostfix(expr)));
    }

    public static boolean isMatched(String expression) {
    final String opening = "({[";
    final String closing = ")}]";
    Stack<Character> buffer=new ArrayStack<>(1000);
    for (char c:expression.toCharArray()
         ) {
        if(opening.indexOf(c)!=-1){
            buffer.push(c);
        }
        else if(closing.indexOf(c)!=-1){
            if(buffer.isEmpty()){
                return false;
            }
            if (closing.indexOf(c)!=opening.indexOf(buffer.pop())){
                return false;
            }
        }
    }
    return buffer.isEmpty( );


    }
    public static boolean isPalindrome(String s){
        char[]expression=s.toCharArray();
        int length=expression.length;
        Stack stack=new LinkedStack();
        int mid=length/2;
        int j=length/2;
        if(length%2!=0){
            mid++;
        }
        for (int i = 0; i < mid; i++) {
            stack.push(expression[i]);
        }

        while (j<length){
            char ele= (char) stack.pop();
            if(ele!=expression[j]){
                return false;
            }
            j++;
        }
        return true;
    }
    //helper for precedence
    public static int Prec(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp){
        String result="";
        Stack<Character> stack=new LinkedStack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }
            else if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                while (!stack.isEmpty()&&stack.top()!='('){
                    result+=stack.top();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty()&&Prec(c)<=Prec(stack.top())){
                    result+=stack.top();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.top() == '(')
                return "Invalid Expression";
            result += stack.top();
            stack.pop();
        }
        return result;
    }

}
