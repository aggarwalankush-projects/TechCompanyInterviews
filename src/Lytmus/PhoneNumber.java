package Lytmus;

public class PhoneNumber {

    /**
     * Normalize a given phone number.
     * <p>
     * This method declaration must be kept unmodified.
     *
     * @param String phoneNumber: A string containing a phone number.
     * @return String with the normalized phone number if the input phone is
     * valid, or '' otherwise.
     */
    public static String standardizePhoneNumber(String phoneNumber) {

        StringBuilder resultPhone = new StringBuilder();

        int count = 0;
        int attempt = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (Character.isDigit(c)) {
                if (count == 3 && attempt < 2) {
                    resultPhone.append("-");
                    count = 0;
                    attempt++;
                }
                resultPhone.append(c);
                count++;
            }
        }

        if (resultPhone.length() != 12)
            return "";
        return resultPhone.toString();
    }

    // This tests your code with the examples given in the question,
    // and is provided only for your convenience.
    public static void main(String[] args) {
        String[] phoneNumbers = {"(650) 555-1234", "65.0555.1234", "65/05/5512/34", "(650) 555-1234 x111",
                "(650) 555-123"};
        for (String phoneNumber : phoneNumbers) {
            System.out.println(standardizePhoneNumber(phoneNumber));
        }
    }
}
