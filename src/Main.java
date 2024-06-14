import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StackAndQueu.ReversInteger();

        String input = "(a + b[(x+y)] + 10)";
        if (DelimiterMatching.isMatching(input)) {
            System.out.println("All delimiters match.");
        }

        String input2 = "/* Comment with ( ) and [ ] */ (a + b[(x+y)] + 10) \"String with ( ) and [ ]\"";
        if (DelimiterMatchingWithComments.isMatching(input2)) {
            System.out.println("All delimiters match.");
        }

        String input3 = "/* Block comment with ( ) and [ ] */\n" +
                "(a + b[(x+y)] + 10) \n" +
                "// Line comment with ( ) and [ ]\n" +
                "\"String with ( ) and [ ]\"";
        if (DelimiterMatchingWithBlockComments.isMatching(input3)) {
            System.out.println("All delimiters match.");
        }


    }}
