package Music;

import Music.basic.Pitch;
import Music.quality.Major;
import Music.complex.Scale;
import Music.complex.Triad;


public class Main {

    public static void main(String[] args) {
        Scale dMajor = new Scale(new Pitch('D'), Major.class);
        System.out.println(dMajor.getPitches());
        Triad dMajorTriad = new Triad(new Pitch('D'), Major.class);
        System.out.println(dMajorTriad.getPitches());

    }
}
