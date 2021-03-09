package readability;

import java.util.HashMap;

public class AutomatedReadabilityIndex implements CalculationStrategy {

    @Override
    public Report calculateScoresAndGradeLevel(Report data, HashMap<Integer, Integer> gradeTable) {
        double index = 4.71 * (data.getCharacters() / data.getWords()) + 0.5 * (data.getWords() / data.getSentences()) - 21.43;
        data.setScore(index);
        data.setAge(gradeTable.get( (int) Math.round(index)));
        return data;
    }
}
