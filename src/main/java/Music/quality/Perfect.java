package Music.quality;

import Music.quality.interfaces.IntervalQuality;

public class Perfect implements IntervalQuality {
    @Override
    public Quality getIntervalQuality() {
        return Quality.PERFECT;
    }
}
