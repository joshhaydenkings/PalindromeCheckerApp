import java.util.Scanner;

//UC-10
public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {


        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;


        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input))
            System.out.println("The string is a palindrome (ignoring spaces and case).");
        else
            System.out.println("The string is not a palindrome.");

        scanner.close();
    }
}