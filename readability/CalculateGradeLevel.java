package readability;

import java.util.HashMap;

public class CalculateGradeLevel implements CalculationStrategy {

    private CalculationStrategy strategy;
    final HashMap<Integer, Integer> gradeLevel = setGradeTable();

    @Override
    public Report calculateScoresAndGradeLevel(Report report, HashMap<Integer, Integer> gradeTable) {
        return this.strategy.calculateScoresAndGradeLevel(report, gradeTable);
    }

    public void setStrategy(CalculationStrategy curStr) {
        strategy = curStr;
    }

    private HashMap<Integer, Integer> setGradeTable() {
        HashMap<Integer, Integer> gradeTable = new HashMap<>();
        gradeTable.put(1, 6);
        gradeTable.put(2, 7);
        gradeTable.put(3, 9);
        gradeTable.put(4, 10);
        gradeTable.put(5, 11);
        gradeTable.put(6, 12);
        gradeTable.put(7, 13);
        gradeTable.put(8, 14);
        gradeTable.put(9, 15);
        gradeTable.put(10, 16);
        gradeTable.put(11,17);
        gradeTable.put(12, 18);
        gradeTable.put(13, 24);
        gradeTable.put(14, 24);
        return gradeTable;
    }
}
