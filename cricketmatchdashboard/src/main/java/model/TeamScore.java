package model;

import java.util.HashMap;
import java.util.Map;

public class TeamScore {
    Map<Player , PlayerScore> playerScores = new HashMap();
    int  totalRuns;
    int overs;
    int wicket;

    public Map<Player, PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Map<Player, PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }
}
