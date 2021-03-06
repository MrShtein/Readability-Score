package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextGrabber textGrabber = new TextGrabber(args[0]);
        try {
            TextAnalyzer textAnalyzer = new TextAnalyzer(textGrabber.getText());
            ReportPrinter reportPrinter = new ReportPrinter(textAnalyzer.analyzeText());
            reportPrinter.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
