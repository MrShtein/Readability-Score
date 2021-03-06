package readability;


public class TextAnalyzer {

    private final String data;

    public TextAnalyzer(String text) {
        data = text;
    }

    public String analyzeText() {
        String[] sentences = data.split("[.!?]");
        int sumOfWords = 0;

        for (String sentence : sentences) {
            sumOfWords += countWords(sentence);
        }
        return giveAnswer(sumOfWords / sentences.length);
    }

    private int countWords(String sentence) {
        return sentence.split(" ").length;
    }

    private String giveAnswer(int wordsOnAverage) {
        if (wordsOnAverage > 10) {
            return "HARD";
        } else {
            return "EASY";
        }
    }


}
