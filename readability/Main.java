package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextGrabber textGrabber = new TextGrabber();
        TextAnalyzer textAnalyzer = new TextAnalyzer(textGrabber.getText());
        System.out.println(textAnalyzer.analyzeText());

    }
}
