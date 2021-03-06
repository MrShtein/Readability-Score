package readability;


import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    private final String data;
    private final HashMap<Integer, Age> GRADE_LEVEL;

    public TextAnalyzer(String text) {
        data = text;
        GRADE_LEVEL = setGradeTable();
    }

    public Report analyzeText() {
        String[] sentences = data.split("[.!?]");
        double sumOfWords = 0.0;
        double sumOfCharacters = countCharacters(data);

        for (String sentence : sentences) {
            sumOfWords += countWords(sentence);
        }
        boolean hasNewLine = "\n".equals(sentences[sentences.length - 1]) || "\n\n".equals(sentences[sentences.length - 1]);
        int sentencesLength = hasNewLine ? sentences.length - 1 : sentences.length;

        double scores = countScores(sumOfWords, sumOfCharacters, sentencesLength);
        int digitForGrade = (int) Math.ceil(scores);
        Age ageGrade = GRADE_LEVEL.get(digitForGrade);
        return new Report((int) sumOfWords, sentencesLength, (int) sumOfCharacters, scores, ageGrade, data);
    }

    private double countWords(String sentence) {
        Pattern wordsPattern = Pattern.compile("\\w+([,-]\\w+)?");
        Matcher wordsMatcher = wordsPattern.matcher(sentence);
        double amount = 0;
        while (wordsMatcher.find()) {
            amount++;
        }
        return amount;
    }

    private double countCharacters(String text) {
        String strWithoutSpaces = text.replaceAll("\\s", "");
        String strWithoutNewLine = strWithoutSpaces.replaceAll("\n", "");
        String strWithoutTab = strWithoutNewLine.replaceAll("\t", "");
        return strWithoutTab.length();
    }

    private double countScores(double sumOfWords, double sumOfCharacters, int sentences) {
        return 4.71 * (sumOfCharacters / sumOfWords) + 0.5 * (sumOfWords / sentences) - 21.43;
    }

    private HashMap<Integer, Age> setGradeTable() {
        HashMap<Integer, Age> gradeTable = new HashMap<>();
        gradeTable.put(1, new Age(5, 6));
        gradeTable.put(2, new Age(6, 7));
        gradeTable.put(3, new Age(7, 9));
        gradeTable.put(4, new Age(9, 10));
        gradeTable.put(5, new Age(10, 11));
        gradeTable.put(6, new Age(11, 12));
        gradeTable.put(7, new Age(12, 13));
        gradeTable.put(8, new Age(13, 14));
        gradeTable.put(9, new Age(14, 15));
        gradeTable.put(10, new Age(15, 16));
        gradeTable.put(11, new Age(16, 17));
        gradeTable.put(12, new Age(17, 18));
        gradeTable.put(13, new Age(18, 24));
        gradeTable.put(14, new Age(24, 24));
        return gradeTable;
    }


}
