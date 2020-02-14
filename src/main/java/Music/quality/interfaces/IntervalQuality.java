package Music.quality.interfaces;

public interface IntervalQuality {
    enum Quality
    {
        DIMINISHED,
        MINOR,
        MAJOR,
        AUGMENTED,
        PERFECT
    }
    public static final String DIMINISHED = "Diminished";
    public static final String MINOR = "Minor";
    public static final String MAJOR = "Major";
    public static final String AUGMENTED = "Augmented";
    public static final String PERFECT = "Perfect";
    public Quality getIntervalQuality();
}
