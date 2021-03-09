package readability;

import readability.Report;

import java.util.HashMap;

public interface CalculationStrategy {
    Report calculateScoresAndGradeLevel(Report data, HashMap<Integer, Integer> gradeTable);
}
