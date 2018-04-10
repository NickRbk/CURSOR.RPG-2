package Util;

public class Console {
    public static void fillSpace(int maxLength,int length){
        for (int i = 0; i <maxLength-length ; i++) {
            System.out.print(".");
        }
    }
}
