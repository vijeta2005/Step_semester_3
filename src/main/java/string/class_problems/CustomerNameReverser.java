package string.class_problems;
public class CustomerNameReverser {

    public static void main(String[] args) {
        try {
            String originalName = "Sunil";
            String reversedName = reverseCustomerName(originalName);

            System.out.println("Original Name: " + originalName);
            System.out.println("Reversed Name: " + reversedName);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }

        char[] chars = customerName.toCharArray();
        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }

        return reversed;
    }
}