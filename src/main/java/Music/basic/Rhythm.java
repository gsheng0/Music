package Music.basic;

public class Rhythm {

    private double beats;
    private int dotCounter = 0;

    public Rhythm(double beats)
    {
        this.beats = beats;
    }
    public Rhythm dot() {
        beats *= 1.5;
        dotCounter++;
        return this;
    }
    public Rhythm unDot() {
        if(dotCounter > 0) {
            beats /= 1.5;
            dotCounter--;
        }
        return this;
    }
    public double getBeats() { return beats; }


    public static final Rhythm QUARTER = new Rhythm(1); //based on 4/4 time
    public static final Rhythm HALF = new Rhythm(2);
    public static final Rhythm WHOLE = new Rhythm(4);
    public static final Rhythm EIGHT = new Rhythm(0.5);
    public static final Rhythm SIXTEENTH = new Rhythm(0.25);
    public static final Rhythm THIRTYSECOND = new Rhythm (0.125);
}
