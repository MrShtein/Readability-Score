package readability;

public class ReportPrinter {

    Report report;

    public ReportPrinter(Report report) {
        this.report = report;
    }

    public void print() {
        System.out.printf("The text is:\n%s", report.getText());
        System.out.printf("\nWords: %d\n", report.getWords());
        System.out.printf("Sentences: %d\n", report.getSentences());
        System.out.printf("Characters: %d\n", report.getCharacters());
        System.out.printf("The score is: %s\n", report.getScore());
        if (report.getAge().getMIN_AGE() != 24) {
            System.out.printf("This text should be understood by %d-%d-year-olds.",
                    report.getAge().getMIN_AGE(), report.getAge().getMAX_AGE());
        } else {
            System.out.print("This text should be understood by 24+-year-olds.");
        }
    }



}
