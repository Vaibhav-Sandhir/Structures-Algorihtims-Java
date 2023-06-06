import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for(char character : input.toCharArray()){
            if(character == '(' || character == '<' || character == '[' || character == '{')
                stack.push(character);
            if (character == ')' || character == '>' || character == ']' || character == '}') {
                if(stack.isEmpty())
                    return false;
                var top = stack.pop();
                if(character == ')' && top != '('
                  || character == '>' && top != '<'
                  || character == '}' && top != '{'
                  || character == ']' && top != '[')
                    return false;
            }
        }
        return stack.empty();
    }
}
