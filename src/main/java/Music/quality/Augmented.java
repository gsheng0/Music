package Music.quality;

import Music.basic.Interval;
import Music.quality.interfaces.IntervalQuality;
import Music.quality.interfaces.SeventhChordQuality;
import Music.quality.interfaces.TriadQuality;

import java.util.ArrayList;

public class Augmented implements TriadQuality, SeventhChordQuality, IntervalQuality {
    private static ArrayList<Interval> triadIntervals = new ArrayList<>();
    private static ArrayList<Interval> chordIntervals = new ArrayList<>();

    static
    {
        triadIntervals.add(Interval.MAJOR_THIRD);
        triadIntervals.add(Interval.MAJOR_THIRD);

        chordIntervals.add(Interval.MAJOR_THIRD);
        chordIntervals.add(Interval.MAJOR_THIRD);
        chordIntervals.add(Interval.MAJOR_THIRD);
    }
    public Quality getIntervalQuality() { return Quality.AUGMENTED; }
    public ArrayList<Interval> getTriadIntervals() { return triadIntervals; }
    public ArrayList<Interval> getChordIntervals() { return chordIntervals; }
}
