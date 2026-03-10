import java.util.*;


public class PalindromeCheckerApp {


    static boolean twoPointer(String input) {

        int start = 0;
        int end = input.length() - 1;

        while(start < end) {
            if(input.charAt(start) != input.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }


    static boolean stackMethod(String input) {

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray())
            stack.push(c);

        String reversed = "";

        while(!stack.isEmpty())
            reversed += stack.pop();

        return input.equals(reversed);
    }


    static boolean dequeMethod(String input) {

        Deque<Character> deque = new LinkedList<>();

        for(char c : input.toCharArray())
            deque.addLast(c);

        while(deque.size() > 1) {

            if(deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }


    static boolean recursion(String str, int start, int end) {

        if(start >= end)
            return true;

        if(str.charAt(start) != str.charAt(end))
            return false;

        return recursion(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string to test: ");
        String input = scanner.nextLine();

        System.out.println("\nPerformance Comparison\n");

        long start, end;


        start = System.nanoTime();
        boolean r1 = twoPointer(input);
        end = System.nanoTime();

        System.out.println("Two Pointer Result: " + r1);
        System.out.println("Execution Time: " + (end - start) + " ns\n");


        start = System.nanoTime();
        boolean r2 = stackMethod(input);
        end = System.nanoTime();

        System.out.println("Stack Result: " + r2);
        System.out.println("Execution Time: " + (end - start) + " ns\n");


        start = System.nanoTime();
        boolean r3 = dequeMethod(input);
        end = System.nanoTime();

        System.out.println("Deque Result: " + r3);
        System.out.println("Execution Time: " + (end - start) + " ns\n");


        start = System.nanoTime();
        boolean r4 = recursion(input, 0, input.length() - 1);
        end = System.nanoTime();

        System.out.println("Recursion Result: " + r4);
        System.out.println("Execution Time: " + (end - start) + " ns\n");

        scanner.close();
    }
}