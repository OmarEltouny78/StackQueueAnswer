import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String expr="()";
        String expr1="({)";
        String hello="Hello world";
        System.out.print(balancedPar(expr));
        System.out.println(balancedPar(expr1));
        reverseString(hello);
        printDirsFiles("C:\\Users\\omare");
    }
    public static void printDirsFiles(String inputDir)
    {
        /* make a queue to store files and directories */
        Queue<File> queue = new LinkedQueue<>();

        queue.enqueue(new File(inputDir));

        /* loop until queue is empty -*/
        while (!queue.isEmpty()) {

            /* get next file/directory from the queue */
            File current = queue.dequeue();

            File[] fileDirList = current.listFiles();

            if (fileDirList != null) {

                /* Enqueue all directories and print
                all files. */
                for (File fd : fileDirList) {
                    if (!fd.isDirectory())
                        queue.enqueue(fd);
                    else
                        System.out.println(fd);
                }
            }
        }
    }

    public static boolean balancedPar(String expr){

        LinkedStack<Character>stack=new LinkedStack<>();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());


    }
    public static void reverseString(String str){
        StringBuilder reversed= new StringBuilder();
        LinkedStack<Character>stack=new LinkedStack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        System.out.println(reversed.toString());
    }
}
