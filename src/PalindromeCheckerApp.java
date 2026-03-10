import java.util.Scanner;

class PalindromeChecker {


    public boolean checkPalindrome(String input) {

        if (input == null)
            return false;


        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        char[] characters = normalized.toCharArray();

        int start = 0;
        int end = characters.length - 1;


        while (start < end) {

            if (characters[start] != characters[end])
                return false;

            start++;
            end--;
        }

        return true;
    }
}




public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result)
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");

        scanner.close();
    }
}