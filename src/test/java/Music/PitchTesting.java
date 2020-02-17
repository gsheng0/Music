package Music;

import Music.basic.Interval;
import Music.basic.Pitch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PitchTesting {
    Pitch d, g, a1;
    @Before
    public void setUp() {
        d = new Pitch('d', Pitch.NATURAL, 5);
        g = new Pitch('g', Pitch.NATURAL, 4);
        a1 = new Pitch('a', Pitch.NATURAL, 1);
    }
    @Test
    public void pitchTest()
    {
        assertEquals("Note perfect fifth above G4 should be D5", d.toString(), g.getPitchIntervalAbove(Interval.PERFECT_FIFTH).toString());
        assertSame("Octaves should be stored correctly", d.getOctave(), 5);
        assertSame("Accidentals should be stored correctly", g.getAccidental(), Pitch.NATURAL);
        assertSame("Step counts should be based above A0", a1.getSteps(), 12);

    }
}
