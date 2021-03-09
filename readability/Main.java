package readability;



public class Main {
    public static void main(String[] args) {
        boolean work = true;
        TextGrabber textGrabber = new TextGrabber(args[0]);
        try {
            while (work) {
                TextAnalyzer textAnalyzer = new TextAnalyzer(textGrabber.getText());
                Report tempReport = textAnalyzer.analyzeText();
                ReportPrinter reportPrinter = new ReportPrinter(tempReport);
                reportPrinter.printData();
                System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
                String algorithmName = textGrabber.getAlgorithmName();
                CalculateGradeLevel strategy = new CalculateGradeLevel();

                switch (algorithmName) {
                    case "ARI":
                        strategy.setStrategy(new AutomatedReadabilityIndex());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).",
                                tempReport.getScore(), tempReport.getAge());
                        work = false;
                        break;
                    case "FK":
                        strategy.setStrategy(new FleschKincaidTest());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).",
                                tempReport.getScore(), tempReport.getAge());
                        work = false;
                        break;
                    case "SMOG":
                        strategy.setStrategy(new SimpleMeasureOfGobbledygook());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).",
                                tempReport.getScore(), tempReport.getAge());
                        work = false;
                        break;
                    case "CL":
                        strategy.setStrategy(new ColemanLiauIndex());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).",
                                tempReport.getScore(), tempReport.getAge());
                        work = false;
                        break;
                    case "all":
                        double age = 0;
                        strategy.setStrategy(new AutomatedReadabilityIndex());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("\nAutomated Readability Index: %.2f (about %d-year-olds).\n",
                                tempReport.getScore(), tempReport.getAge());
                        age += tempReport.getAge();

                        strategy.setStrategy(new FleschKincaidTest());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n",
                                tempReport.getScore(), tempReport.getAge());
                        age += tempReport.getAge();

                        strategy.setStrategy(new SimpleMeasureOfGobbledygook());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n",
                                tempReport.getScore(), tempReport.getAge());
                        age += tempReport.getAge();

                        strategy.setStrategy(new ColemanLiauIndex());
                        tempReport = strategy.calculateScoresAndGradeLevel(tempReport, strategy.gradeLevel);
                        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n",
                                tempReport.getScore(), tempReport.getAge());
                        age += tempReport.getAge();

                        System.out.printf("This text should be understood in average by %.2f-year-olds.", age / 4);
                        work = false;
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
