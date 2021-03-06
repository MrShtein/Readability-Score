package readability;

public class Age {

    private final int MIN_AGE;
    private final int MAX_AGE;

    public Age(int min, int max) {
        MIN_AGE = min;
        MAX_AGE = max;
    }

    public int getMIN_AGE() {
        return MIN_AGE;
    }

    public int getMAX_AGE() {
        return MAX_AGE;
    }
}
