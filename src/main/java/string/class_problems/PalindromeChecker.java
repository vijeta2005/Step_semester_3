package string.class_problems;
public class PalindromeChecker {

    public static void main(String[] args) {
        try {
            checkAndPrint("madam");
            checkAndPrint("hello");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void checkAndPrint(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean arrRev = isPalindromeArrayReversal(text);

        String iterRes = iter ? "Palindrome" : "Not Palindrome";
        String recurRes = recur ? "Palindrome" : "Not Palindrome";
        String arrRes = arrRev ? "Palindrome" : "Not Palindrome";

        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + iterRes + " | Recursive: " + recurRes + " | Array Reversal: " + arrRes);
        System.out.println("---------------------------------------------------------");
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        return text.equals(new String(reversed));
    }
}
