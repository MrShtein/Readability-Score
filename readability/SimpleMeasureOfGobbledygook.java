package readability;

import java.util.HashMap;

public class SimpleMeasureOfGobbledygook implements CalculationStrategy {

    @Override
    public Report calculateScoresAndGradeLevel(Report data, HashMap<Integer, Integer> gradeTable) {
        double index = 1.043 * Math.sqrt(data.getPolysyllables() * 30 / data.getSentences()) + 3.1291;
        data.setScore(index);
        data.setAge(gradeTable.get((int) Math.round(index)));
        return data;
    }

}
