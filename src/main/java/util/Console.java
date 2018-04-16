package util;

public class Console implements GameConstants{


    public static void fillSpace(int maxLength, int length, String s) {
        for (int i = 0; i < maxLength - length; i++) {
            System.out.print(s);
        }
    }

    public static void printParagraph(String s) {
        StringBuilder sb = new StringBuilder("    ");
        int index = 0;
        int i = 0;
        while (i < s.length()) {
            sb.append(String.valueOf(s.charAt(i)));
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                index += sb.length();
                if (index > TAB * 9 + 4) {
                    System.out.println();
                    index=sb.length();
                }
                System.out.print(sb);
                sb = new StringBuilder();
            }
            i++;
        }
        System.out.println();
    }

}
