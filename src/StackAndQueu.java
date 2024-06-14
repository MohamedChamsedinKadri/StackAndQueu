import java.util.Scanner;
import java.util.Stack;

class StackAndQueu {
    public static void ReversInteger() {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter some integers for me to reverse :");
        while (true) {
            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            stack.push(input);
        }
        System.out.print("The integers reversed are : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(", ");
            }


        }
    }

}
