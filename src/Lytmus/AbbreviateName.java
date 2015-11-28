package Lytmus;

public class AbbreviateName {
    /**
     * Returns an abbreviated version of a full name. All names except the last
     * are abbreviated with one letter.
     * <p>
     * This method declaration must be kept unmodified.
     *
     * @param abbreviateName the full name of the person
     * @return the abbreviated version of the full name
     */
    public static String abbreviateName(String name) {

        StringBuilder sb = new StringBuilder();

        String[] names = name.split(" ");

        if (names.length < 2)
            return sb.toString();

        sb.append(names[0] + " ");

        for (int i = 1; i < names.length; i++) {
            sb.append(names[i].charAt(0) + ". ");
        }
        return sb.toString().trim();


    }

    /**
     * Tests the method abbreviate with the examples given in the question. This
     * test code is provided only for your convenience.
     */
    public static void main(String[] args) {
        System.out.print(AbbreviateName.abbreviateName("John Smith") + "\n");
        System.out.print(AbbreviateName.abbreviateName("Anna Maria Simpson") + "\n");
        System.out.print(AbbreviateName.abbreviateName("Bob Alan Faria Stewart") + "\n");
    }
}
