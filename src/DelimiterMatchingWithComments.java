import java.util.Stack;

public class DelimiterMatchingWithComments {
    public static boolean isMatching(String input) {
        Stack<Character> stack = new Stack<>();
        boolean inString = false;
        boolean inComment = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (inString) {
                if (ch == '"') {
                    inString = false;
                }
            } else if (inComment) {
                if (ch == '*' && i < input.length() - 1 && input.charAt(i + 1) == '/') {
                    inComment = false;
                    i++;
                }
            } else {
                if (ch == '"') {
                    inString = true;
                } else if (ch == '/' && i < input.length() - 1 && input.charAt(i + 1) == '*') {
                    inComment = true;
                    i++;
                } else if (ch == '(' || ch == '[' || ch == '{') {
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

    public static void main(String[] args) {
        String input = "/* Comment with ( ) and [ ] */ (a + b[(x+y)] + 10) \"String with ( ) and [ ]\"";
        if (isMatching(input)) {
            System.out.println("All delimiters match.");
        }
    }
}
