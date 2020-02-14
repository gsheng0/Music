package Music.quality;

import Music.basic.Interval;
import Music.quality.interfaces.IntervalQuality;
import Music.quality.interfaces.SeventhChordQuality;
import Music.quality.interfaces.TriadQuality;

import java.util.ArrayList;

public class Diminished implements TriadQuality, SeventhChordQuality, IntervalQuality {
    private static ArrayList<Interval> triadIntervals = new ArrayList<>();
    private static ArrayList<Interval> chordIntervals = new ArrayList<>();

    static
    {
        triadIntervals.add(Interval.MINOR_THIRD);
        triadIntervals.add(Interval.MINOR_THIRD);

        chordIntervals.add(Interval.MINOR_THIRD);
        chordIntervals.add(Interval.MINOR_THIRD);
        chordIntervals.add(Interval.MINOR_THIRD);
    }
    public ArrayList<Interval> getTriadIntervals() { return triadIntervals; }
    public ArrayList<Interval> getChordIntervals() { return chordIntervals; }
    public Quality getIntervalQuality() { return Quality.DIMINISHED; }
}
