package readability;

import java.util.Scanner;

public class TextGrabber {

    Scanner scanner;

    public TextGrabber() {
        scanner = new Scanner(System.in);
    }

    public String getText() {
        return scanner.nextLine();
    }

}
