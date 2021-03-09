package readability;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    private final String data;
    private final int POLYSYLLABLES_MIN = 3;

    public TextAnalyzer(String text) {
        data = text;
    }

    public Report analyzeText() {
        String[] sentences = data.split("[.!?]");
        double sumOfWords = 0.0;
        double syllables = 0.0;
        double polysyllables = 0.0;
        double letters = 0.0;
        double sumOfCharacters = countCharacters(data);

        for (String sentence : sentences) {
            sumOfWords += countWords(sentence);
            syllables += countSyllablesInSentence(sentence);
            polysyllables += countPolysyllablesInSentence(sentence);
        }

        boolean hasNewLine = "\n".equals(sentences[sentences.length - 1]) || "\n\n".equals(sentences[sentences.length - 1]);
        int sentencesLength = hasNewLine ? sentences.length - 1 : sentences.length;
        return new Report( sumOfWords, sentencesLength,  sumOfCharacters, data, syllables, polysyllables);
    }

    private double countWords(String sentence) {
        ArrayList<String> words = findWordsInSentence(sentence);
        return words.size();
    }

    private ArrayList<String> findWordsInSentence(String sentence) {
        Pattern wordsPattern = Pattern.compile("\\w+([,-]\\w+)?");
        Matcher wordsMatcher = wordsPattern.matcher(sentence);
        ArrayList<String> words = new ArrayList<>();
        while(wordsMatcher.find()) {
            words.add(wordsMatcher.group());
        }
        return words;
    }

    private double countCharacters(String text) {
        String strWithoutSpaces = text.replaceAll("\\s", "");
        String strWithoutNewLine = strWithoutSpaces.replaceAll("\n", "");
        String strWithoutTab = strWithoutNewLine.replaceAll("\t", "");
        return strWithoutTab.length();
    }

    private double countPolysyllablesInSentence(String sentence) {
        ArrayList<String> words = findWordsInSentence(sentence);
        double polysyllables = 0.0;
        for (String word : words) {
            double syllables = countSyllablesInWord(word);
            if (syllables >= POLYSYLLABLES_MIN) {
                polysyllables++;
            }
        }
        return polysyllables;
    }

    private double countSyllablesInSentence(String sentence) {
        ArrayList<String> words = findWordsInSentence(sentence);
        double syllables = 0.0;
        for (String word : words) {
            syllables += countSyllablesInWord(word);
        }
        return syllables;
    }

    private double countSyllablesInWord(String word) {
        HashSet<String> vowels = new HashSet<>(List.of("a", "e", "i", "o", "u", "y"));
        int amount = 0;
        String currentLetter = null;
        String previousLetter = null;
        String[] letters = word.split("");
        for (int i = 0; i < letters.length; i++) {
            currentLetter = letters[i].toLowerCase();
            if (vowels.contains(currentLetter)) {
                if (i == letters.length - 1 && "e".equals(currentLetter) || vowels.contains(previousLetter)) {
                    continue;
                } else {
                    amount++;
                }
            }
            previousLetter = currentLetter;
        }
        return amount == 0 ? 1 : amount;

    }




}
