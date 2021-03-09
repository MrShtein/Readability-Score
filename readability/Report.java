package readability;

public class Report {

    private final double words;
    private final double sentences;
    private final double characters;
    private final double syllables;
    private final double polysyllables;
    private double score;
    private int age;
    private final String text;

    public Report(double words, double sentences, double characters, String text, double syllables, double polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.text = text;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    public double getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public double getWords() {
        return words;
    }

    public double getSentences() {
        return sentences;
    }

    public double getCharacters() {
        return characters;
    }

    public double getSyllables() {
        return syllables;
    }

    public double getPolysyllables() {
        return polysyllables;
    }

}
