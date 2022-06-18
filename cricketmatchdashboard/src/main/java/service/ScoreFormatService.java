package service;

import model.Player;
import model.PlayerScore;
import model.TeamScore;

import java.util.Map;

public class ScoreFormatService {

      public String showFormattedScore(TeamScore teamScore){
           StringBuilder sb = new StringBuilder();

           Map<Player , PlayerScore> playersScore  =  teamScore.getPlayerScores();

           sb.append("Player Name Score 4s 6s Balls");
           for(Player player : playersScore.keySet()){
               PlayerScore playerScore = playersScore.get(player);
               sb.append( String.format("%s %d %d %d %d\n",player.getPlayerName(), playerScore.getRun(),
                       playerScore.getFour(), playerScore.getSix(), playerScore.getBalls()));
           }
           sb.append(String.format("Total: %d/%d\n",teamScore.getTotalRuns(), teamScore.getWicket() ));
           sb.append(String.format("Overs: %d", teamScore.getOvers()));
           return sb.toString();
      }

}
