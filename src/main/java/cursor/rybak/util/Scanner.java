package cursor.rybak.util;

public class Scanner {
    private static Scanner instance;

    private java.util.Scanner in;

    private Scanner() {
        this.in = new java.util.Scanner(System.in);
    }

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner();
        }

        return instance;
    }

    public String getInput() {
        return this.in.nextLine();
    }
}
