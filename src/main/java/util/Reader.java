package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class Reader {
    private static Scanner sc;

    private Reader() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.ScannerUtil");
    }

    public static List<String> readFile(String s) throws IOException {
        FileReader fr = new FileReader("src/main/resources/" + s + ".txt");
        Scanner fsc = new Scanner(fr);
        List<String> list = new LinkedList<>();
        while (fsc.hasNextLine()) {
            list.add(fsc.nextLine());
        }
        fr.close();
        return list;
    }

    private static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }

    static String getString() {
        return getScanner().nextLine();
    }

    /*public static int getInt() {
        return getScanner().nextInt();
    }*/

}
