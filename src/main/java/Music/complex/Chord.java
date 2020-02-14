package Music.complex;

import Music.basic.Interval;
import Music.basic.Pitch;

import java.util.ArrayList;

public abstract class Chord {
    public abstract ArrayList<Pitch> getPitches();
    public abstract Pitch getRoot();
    public abstract ArrayList<Interval> getIntervalList();
    public abstract int pitchCount();
    public abstract Class getQuality();

}

