package Music.quality;

import Music.basic.Interval;
import Music.quality.interfaces.IntervalQuality;
import Music.quality.interfaces.Mode;
import Music.quality.interfaces.SeventhChordQuality;
import Music.quality.interfaces.TriadQuality;

import java.util.ArrayList;

public class Minor implements Mode, TriadQuality, SeventhChordQuality, IntervalQuality {
    private static ArrayList<Interval> intervalList = new ArrayList<>();
    private static ArrayList<Interval> triadIntervals = new ArrayList<>();
    private static ArrayList<Interval> chordIntervals = new ArrayList<>();

    static
    {
        intervalList.add(Interval.MAJOR_SECOND);
        intervalList.add(Interval.MINOR_SECOND);
        intervalList.add(Interval.MAJOR_SECOND);
        intervalList.add(Interval.MAJOR_SECOND);
        intervalList.add(Interval.MINOR_SECOND);
        intervalList.add(Interval.MAJOR_SECOND);
        intervalList.add(Interval.MAJOR_SECOND);

        triadIntervals.add(Interval.MINOR_THIRD);
        triadIntervals.add(Interval.MAJOR_THIRD);

        chordIntervals.add(Interval.MINOR_THIRD);
        chordIntervals.add(Interval.MAJOR_THIRD);
        chordIntervals.add(Interval.MINOR_THIRD);
    }

    public ArrayList<Interval> getIntervalList() {
        return intervalList;
    }
    public ArrayList<Interval> getTriadIntervals() { return triadIntervals; }
    public ArrayList<Interval> getChordIntervals() { return chordIntervals; }
    public Quality getIntervalQuality() { return Quality.MINOR; }
}

