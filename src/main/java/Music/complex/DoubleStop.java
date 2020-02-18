package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;

import java.util.ArrayList;

public class DoubleStop extends MultiPitch {
    private ArrayList<Pitch> pitches;
    private Pitch root;
    private ArrayList<Interval> intervalList;
    public DoubleStop(Pitch root, Pitch other)
    {
        pitches.add(root);
        pitches.add(other);
        this.root = root;
        intervalList.add(new Interval(root, other));
    }
    public DoubleStop(Pitch root, Interval interval)
    {
        pitches.add(root);
        this.root = root;
        pitches.add(root.getPitchIntervalAbove(interval));
        intervalList.add(interval);
    }
    @Override
    public Pitch getRoot() { return root; }

    @Override
    public ArrayList<Interval> getIntervalList() {
        return intervalList;
    }

    public int pitchCount() { return pitches.size(); }
    public ArrayList<Pitch> getPitches() { return pitches; }
}
