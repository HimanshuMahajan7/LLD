package cricbuzz.src.scoreupdater;

import cricbuzz.src.inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
