package readability;

public class ReportPrinter {

    Report report;

    public ReportPrinter(Report report) {
        this.report = report;
    }

    public void printData() {
        System.out.printf("The text is:\n%s", report.getText());
        System.out.printf("\nWords: %d\n", (int) report.getWords());
        System.out.printf("Sentences: %d\n", (int) report.getSentences());
        System.out.printf("Characters: %d\n", (int) report.getCharacters());
        System.out.printf("Syllables: %d\n", (int) report.getSyllables());
        System.out.printf("Polysyllables: %d\n", (int) report.getPolysyllables());
    }

    public void printResult(Report report, String phrase) {
        System.out.printf("%s %.2f (about %d-year-olds).\n", phrase, report.getScore(), report.getAge());

    }



}
