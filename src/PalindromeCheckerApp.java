import java.util.*;


interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}


class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray())
            stack.push(c);

        String reversed = "";

        while(!stack.isEmpty())
            reversed += stack.pop();

        return input.equals(reversed);
    }
}


class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        Deque<Character> deque = new LinkedList<>();

        for(char c : input.toCharArray())
            deque.addLast(c);

        while(deque.size() > 1) {

            if(deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }
}


class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}


public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if(choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if(result)
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");

        scanner.close();
    }
}