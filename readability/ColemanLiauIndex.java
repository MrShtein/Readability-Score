package readability;

import java.util.HashMap;

public class ColemanLiauIndex implements CalculationStrategy {

    @Override
    public Report calculateScoresAndGradeLevel(Report data, HashMap<Integer, Integer> gradeTable) {
        double lAverage = data.getCharacters() / data.getWords() * 100;
        double sAverage = data.getSentences()  / data.getWords() * 100;
        double index = ((0.0588 * lAverage) - (0.296  * sAverage)) - 15.8;
        data.setScore(index);
        data.setAge(gradeTable.get((int) Math.round(index)));
        return data;
    }

}
