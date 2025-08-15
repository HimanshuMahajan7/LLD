package cricbuzz.src.team.player;

import java.util.*;

public class PlayerBowlingController {
    Deque<PlayerDetails> bowlerList;
    Map<PlayerDetails, Integer> bowlerVsOverCount;
    PlayerDetails currentBowler;

    public PlayerBowlingController(List<PlayerDetails> bowlers) {
        setBowlerList(bowlers);
    }

    private void setBowlerList(List<PlayerDetails> bowlerList) {
        this.bowlerList = new LinkedList<>();
        this.bowlerVsOverCount = new HashMap<>();
        for (PlayerDetails bowler: bowlerList) {
            this.bowlerList.add(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxCountPerBowler) {
        PlayerDetails nextBowler = bowlerList.poll();
        if (bowlerVsOverCount.get(nextBowler) + 1 == maxCountPerBowler) {
            currentBowler = nextBowler;
        } else {
            currentBowler = nextBowler;
            bowlerList.addLast(nextBowler);
            bowlerVsOverCount.put(nextBowler, bowlerVsOverCount.get(nextBowler) + 1);
        }
    }

    public PlayerDetails getCurrentBowler() {
        return currentBowler;
    }
}
