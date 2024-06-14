import java.util.Stack;

public class DelimiterMatching {
    public static boolean isMatching(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Error: Missing opening delimiter for " + ch);
                    return false;
                }
                char last = stack.pop();
                if (!isPair(last, ch)) {
                    System.out.println("Error: Mismatched delimiter " + ch);
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: Missing closing delimiter for " + stack.pop());
            return false;
        }
        return true;
    }

    private static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
