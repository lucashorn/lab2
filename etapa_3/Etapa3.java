import java.util.Stack;

public class Etapa3 {
    public boolean checkBrackets(Stack<Character> stack) {
        int balance = 0;
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);
        
        Stack<Character> inverted = new Stack<>();
        while (!temp.isEmpty()) {
            inverted.push(temp.pop());
        }
        
        while (!inverted.isEmpty()) {
            char c = inverted.pop();
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
}