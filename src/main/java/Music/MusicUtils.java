package Music;

import java.util.HashMap;

public class  MusicUtils {
    public static DoublyLinkedList<Character> pitches = new DoublyLinkedList<>();
    public static HashMap<Integer, Integer> intervalToDistance = new HashMap<>();
    public static HashMap<Character, Integer> pitchToSteps = new HashMap<>();
    public static HashMap<Integer, Character> stepsToPitch = new HashMap<>();
    public static HashMap<Integer, String> accidentalToNumber = new HashMap<>();
    static {
        pitches.add('A');
        pitches.add('B');
        pitches.add('C');
        pitches.add('D');
        pitches.add('E');
        pitches.add('F');
        pitches.add('G');
        pitches.getEnd().setNext(pitches.getRoot());

        intervalToDistance.put(1, 0);
        intervalToDistance.put(4, 5);
        intervalToDistance.put(5, 7);
        intervalToDistance.put(8, 12);

        intervalToDistance.put(2, 2);
        intervalToDistance.put(3, 4);
        intervalToDistance.put(6, 9);
        intervalToDistance.put(7, 11);
        intervalToDistance.put(0, 11);

        pitchToSteps.put('A', 0);
        pitchToSteps.put('B', 2);
        pitchToSteps.put('C', 3);
        pitchToSteps.put('D', 5);
        pitchToSteps.put('E', 7);
        pitchToSteps.put('F', 8);
        pitchToSteps.put('G', 10);

        stepsToPitch.put(0, 'A');
        stepsToPitch.put(2, 'B');
        stepsToPitch.put(3, 'C');
        stepsToPitch.put(5, 'D');
        stepsToPitch.put(7, 'E');
        stepsToPitch.put(8, 'F');
        stepsToPitch.put(10, 'G');

        accidentalToNumber.put(-2, "double flat");
        accidentalToNumber.put(-1, "flat");
        accidentalToNumber.put(0, "natural");
        accidentalToNumber.put(1, "sharp");
        accidentalToNumber.put(2, "double sharp");
    }
}
