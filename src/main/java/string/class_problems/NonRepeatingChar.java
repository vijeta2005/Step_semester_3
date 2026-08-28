package string.class_problems;

public class NonRepeatingChar {

    public static void main(String[] args) {
        try {
            processWord("swiss");
            processWord("aabbcc");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void processWord(String word) {
        char ch = findFirstNonRepeatingChar(word);
        if (ch != '\0') {
            System.out.println("Input: \"" + word + "\" -> First Non-Repeating Character: '" + ch + "'");
        } else {
            System.out.println("Input: \"" + word + "\" -> No Non-Repeating Character Found");
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }
}