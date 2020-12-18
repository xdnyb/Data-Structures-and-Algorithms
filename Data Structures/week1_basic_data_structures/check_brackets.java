import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        boolean output = false;// not to print 2 results
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket b = new Bracket(next,position);
                opening_brackets_stack.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.empty()){
                    System.out.println(position+1);
                    output = true;
                    break;
                }else{
                    if (opening_brackets_stack.peek().Match(next)){
                        opening_brackets_stack.pop();
                    }else{
                        System.out.println(position+1);
                        output = true;
                        break;
                    }
                }
                
            }
        }

        // Printing answer, write your code here
        if (output==false){
            if (opening_brackets_stack.empty()){
                System.out.println("Success");
            }else{
                System.out.println(opening_brackets_stack.peek().position + 1);
            }
        }
        
    }
}
