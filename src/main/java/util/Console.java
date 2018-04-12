package util;

public class Console {
    public final static int TAB = 8;

    public static void fillSpace(int maxLength, int length,String s) {
        for (int i = 0; i < maxLength - length; i++) {
            System.out.print(s);
        }
    }
}
