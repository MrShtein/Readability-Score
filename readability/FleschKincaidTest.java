package readability;

import java.util.HashMap;

public class FleschKincaidTest implements CalculationStrategy{

    @Override
    public Report calculateScoresAndGradeLevel(Report data, HashMap<Integer, Integer> gradeTable) {
        double index = 0.39 * (data.getWords() / data.getSentences()) + 11.8 * (data.getSyllables() / data.getWords()) - 15.59;
        data.setScore(index);
        data.setAge(gradeTable.get((int) Math.round(index)));
        return data;
    }

}
