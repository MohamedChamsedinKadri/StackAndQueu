import java.util.Stack;

public class DelimiterMatchingWithBlockComments {
    public static boolean isMatching(String input) {
        Stack<Character> stack = new Stack<>();
        boolean inString = false;
        boolean inLineComment = false;
        boolean inBlockComment = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (inString) {
                if (ch == '"') {
                    inString = false;
                }
            } else if (inLineComment) {
                if (ch == '\n') {
                    inLineComment = false;
                }
            } else if (inBlockComment) {
                if (ch == '*' && i < input.length() - 1 && input.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i++;
                }
            } else {
                if (ch == '"') {
                    inString = true;
                } else if (ch == '/' && i < input.length() - 1) {
                    if (input.charAt(i + 1) == '/') {
                        inLineComment = true;
                        i++;
                    } else if (input.charAt(i + 1) == '*') {
                        inBlockComment = true;
                        i++;
                    }
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
}

