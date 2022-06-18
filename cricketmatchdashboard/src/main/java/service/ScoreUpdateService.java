package service;

import model.BallScore;
import model.Player;
import model.PlayerScore;
import model.TeamScore;

import java.util.List;

public class ScoreUpdateService {
    TeamScore teamScore;
    Player  otherPlayer;
    Player currPlayer;
    List<Player > players;
    int nextPlayerNumber = 0;

    public ScoreUpdateService(List<Player > players) {
        this.players = players;
    }

    public TeamScore getTeamScore(BallScore[] over) throws Exception {
        currPlayer = players.get(nextPlayerNumber++);
        otherPlayer =  players.get(nextPlayerNumber++);
        teamScore.setOvers(teamScore.getOvers() + 1);
        for(BallScore ballScore : over){
            PlayerScore playerScore = teamScore.getPlayerScores().get(currPlayer);
            playerScore.setBalls(playerScore.getBalls() + 1);
             switch (ballScore){
                 case ONE :
                     playerScore.setRun(playerScore.getRun() + 1);
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 1);
                     currPlayer = otherPlayer;
                     otherPlayer = currPlayer;
                     break;
                 case TWO :
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 2);
                     playerScore.setRun(playerScore.getRun() + 2);
                     break;
                 case THREE:
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 3);
                     playerScore.setRun(playerScore.getRun() + 3);
                     currPlayer = otherPlayer;
                     otherPlayer = currPlayer;
                     break;
                 case FOUR:
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 4);
                     playerScore.setRun(playerScore.getRun() + 4);
                     playerScore.setFour(playerScore.getFour()+ 1);
                     break;
                 case SIX:
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 6);
                     playerScore.setRun(playerScore.getRun() + 6);
                     playerScore.setSix(playerScore.getSix()+ 1);
                     break;
                 case OUT:
                     teamScore.setWicket(teamScore.getWicket() + 1);
                     if(nextPlayerNumber >= players.size()){
                        return teamScore;
                     }
                     Player player = players.get(nextPlayerNumber++);
                     currPlayer = player;
                     break;
                 case WIDE:
                 case NO:
                     teamScore.setTotalRuns(teamScore.getTotalRuns()+ 1);
                     break;
                 default:
                     throw  new Exception("Ball Type Incorrect");
             }
        }

        return teamScore;
    }
}
