package Music.basic;

import Music.*;
import Music.quality.*;
import Music.quality.interfaces.IntervalQuality;

public class Interval
{
    private int distance;
    private Ordinal diatonicInterval;
    private Class<? extends IntervalQuality> quality;

    public Interval(Pitch first, Pitch second)
    {
        if(second.lowerThan(first))
        {
            Pitch temp = first;
            first = second;
            second = temp;
        }
        int difference = Math.abs(first.getSteps() - second.getSteps());
        int diatonicInterval = 1;

        DoublyLinkedList<Character>.ListNode<Character> listNode = MusicUtils.pitches.get(MusicUtils.pitches.indexOf(first.getPitch()));
        while(listNode.getValue() != second.getPitch())
        {
            listNode = listNode.getNext();
            diatonicInterval++;
        }
        this.diatonicInterval = new Ordinal(diatonicInterval + 7 * Math.abs(first.getOctave() - second.getOctave()));
        this.distance = Math.abs(first.getSteps() - second.getSteps());
        this.quality = generateModifier();
    }
    public Interval(Class<? extends IntervalQuality> quality, Ordinal diatonicInterval)
    {
        this.quality = quality;
        this.diatonicInterval = diatonicInterval;
        distance = MusicUtils.intervalToDistance.get(diatonicInterval.getCardinalNumber());
        int interval = diatonicInterval.getCardinalNumber() % 7;
        if(interval == 1 || interval == 4 || interval == 5) {
            if(quality.equals(Augmented.class))
                    distance++;
            else if(quality.equals(Diminished.class))
                    distance--;

            }

        else
        {
            if(quality.equals(Augmented.class))
                distance++;
            else if(quality.equals(Diminished.class))
                distance-=2;
            else if(quality.equals(Minor.class))
                distance--;
        }

    }

    private Class<? extends IntervalQuality> generateModifier()
    {
        int expected = MusicUtils.intervalToDistance.get(diatonicInterval.getCardinalNumber() % 7);
        int difference = (expected - distance) % 12;
        switch(diatonicInterval.getCardinalNumber() % 7)
        {
            case(1):
            case(4):
            case(5):
                switch(difference)
                {
                    case(1):
                        return Diminished.class;
                    case(0):
                        return Perfect.class;
                    case(-1):
                        return Augmented.class;
                }
            case(2):
            case(3):
            case(6):
            case(0):
                switch(difference)
                {
                    case(2):
                        return Diminished.class;
                    case(1):
                        return Minor.class;
                    case(0):
                        return Major.class;
                    case(-1):
                        return Augmented.class;
                }

        }
        return Perfect.class;
    }

    public String toString() { return quality + " " + diatonicInterval; }
    public int getDistance() { return distance; }
    public Ordinal getDiatonicInterval() { return diatonicInterval; }

    public static final Interval PERFECT_FIRST = new Interval(new Pitch('A'), new Pitch('A'));;
    public static final Interval AUG_FIRST = new Interval(new Pitch('C'), new Pitch('C', Pitch.SHARP));
    public static final Interval DIM_FIRST = new Interval(new Pitch('C'), new Pitch('C', Pitch.FLAT));
    public static final Interval MINOR_SECOND = new Interval(new Pitch('C'), new Pitch('D', Pitch.FLAT));;
    public static final Interval MAJOR_SECOND = new Interval(new Pitch('C'), new Pitch('D'));
    public static final Interval DIM_SECOND = new Interval(new Pitch('B'), new Pitch('C', Pitch.FLAT));;
    public static final Interval AUG_SECOND = new Interval(new Pitch('C'), new Pitch('D', Pitch.SHARP));
    public static final Interval DIM_THIRD = new Interval(new Pitch('D'), new Pitch('F', Pitch.FLAT));
    public static final Interval MINOR_THIRD = new Interval(new Pitch('D'), new Pitch('F'));
    public static final Interval MAJOR_THIRD = new Interval(new Pitch('C'), new Pitch('E'));
    public static final Interval AUG_THIRD = new Interval(new Pitch('C'), new Pitch('E', Pitch.SHARP));
    public static final Interval DIM_FOURTH = new Interval(new Pitch('D'), new Pitch('G', Pitch.FLAT));
    public static final Interval PERFECT_FOURTH = new Interval(new Pitch('D'), new Pitch('G'));
    public static final Interval AUG_FOURTH = new Interval(new Pitch('D'), new Pitch('G', Pitch.SHARP));
    public static final Interval DIM_FIFTH = new Interval(new Pitch('C'), new Pitch('G', Pitch.FLAT));
    public static final Interval PERFECT_FIFTH = new Interval(new Pitch('C'), new Pitch('G'));
    public static final Interval AUG_FIFTH = new Interval(new Pitch('C'), new Pitch('G', Pitch.SHARP));
    public static final Interval DIM_SIXTH = new Interval(new Pitch('A'), new Pitch('F', Pitch.FLAT));
    public static final Interval MINOR_SIXTH = new Interval(new Pitch('A'), new Pitch('F'));
    public static final Interval MAJOR_SIXTH = new Interval(new Pitch('A'), new Pitch('F', Pitch.SHARP));;
    public static final Interval AUG_SIXTH = new Interval(new Pitch('B', Pitch.FLAT), new Pitch('G', Pitch.SHARP));;
    public static final Interval DIM_SEVENTH = new Interval(new Pitch('A'), new Pitch('G', Pitch.FLAT));
    public static final Interval MINOR_SEVENTH = new Interval(new Pitch('A'), new Pitch('G'));
    public static final Interval MAJOR_SEVENTH = new Interval(new Pitch('A'), new Pitch('G', Pitch.SHARP));
    public static final Interval AUG_SEVENTH = new Interval(new Pitch('B', Pitch.FLAT), new Pitch('A', Pitch.SHARP, 6));
    public static final Interval DIM_EIGHTH = new Interval(new Pitch('B'), new Pitch('B', Pitch.FLAT, 6));
    public static final Interval PERFECT_EIGHTH = new Interval(new Pitch('B'), new Pitch('B', Pitch.NATURAL, 6));
    public static final Interval AUG_EIGHTH = new Interval(new Pitch('B'), new Pitch('B', Pitch.SHARP, 6));

}
