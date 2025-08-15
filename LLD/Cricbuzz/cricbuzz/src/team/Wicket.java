package cricbuzz.src.team;

import cricbuzz.src.inning.BallDetails;
import cricbuzz.src.inning.OverDetails;
import cricbuzz.src.team.player.PlayerDetails;

public class Wicket {
    WicketType wicketType;
    public PlayerDetails takenBy;
    OverDetails overDetails;
    BallDetails ballDetails;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetails, BallDetails ballDetails) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetails = overDetails;
        this.ballDetails = ballDetails;
    }
}
