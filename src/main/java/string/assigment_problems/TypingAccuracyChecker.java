package string.assigment_problems;

import java.util.Locale;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based indexing position
            }
        }

        double accuracy = ((double) matched / totalChars) * 100;
        
        System.out.print(String.format(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | ", matched, totalChars, accuracy));

        if (firstMismatchPos != -1) {
            System.out.println(String.format("First Mismatch at position %d ('%c' vs '%c')", 
                    firstMismatchPos, original.charAt(firstMismatchPos - 1), typed.charAt(firstMismatchPos - 1)));
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
