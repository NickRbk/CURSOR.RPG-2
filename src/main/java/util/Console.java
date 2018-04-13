package util;

public class Console {
    public final static int TAB = 8;

    public static void fillSpace(int maxLength, int length, String s) {
        for (int i = 0; i < maxLength - length; i++) {
            System.out.print(s);
        }
    }

    public static void printParagraph(String s) {
        String s1 = new String();
        int index = 0;
        int i = 0;
        while (i < s.length()) {
            s1 += String.valueOf(s.charAt(i));
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                index += s1.length();
                if (index >= TAB * 9 + 4) {
                    System.out.println();
                    index=s1.length();
                }
                System.out.print(s1);
                s1 = new String();
            }
            i++;
        }
        System.out.println();
    }

}
