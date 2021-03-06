package readability;

public class Report {

    private final int words;
    private final int sentences;
    private final int characters;
    private final double score;
    private final Age grade;
    private final String text;

    public Report(int words, int sentences, int characters, double score, Age grade, String text) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.score = score;
        this.grade = grade;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getWords() {
        return words;
    }

    public int getSentences() {
        return sentences;
    }

    public int getCharacters() {
        return characters;
    }

    public String getScore() {
        return String.format("%.2f", score);
    }

    public Age getAge() {
        return grade;
    }
}
