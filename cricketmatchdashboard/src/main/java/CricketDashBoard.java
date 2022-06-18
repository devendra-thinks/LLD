import model.BallScore;
import model.Player;
import model.TeamScore;
import service.ScoreFormatService;
import service.ScoreUpdateService;

import java.util.ArrayList;
import java.util.List;

public class CricketDashBoard {
  public static void main(String[] args) throws Exception {

      List<Player > indianPlayers = new ArrayList<Player>();

      ScoreUpdateService scoreUpdateServiceForIndia =  new ScoreUpdateService(indianPlayers);

      List<Player > pakPlayers = new ArrayList<Player>();

      ScoreUpdateService scoreUpdateServiceForPak =  new ScoreUpdateService(pakPlayers);

      ScoreFormatService scoreFormatService = new ScoreFormatService();

      List<BallScore [] > oversForIndia = new ArrayList<BallScore[]>();
      List<BallScore [] > oversForPak = new ArrayList<BallScore[]>();

      for(BallScore[] over : oversForIndia ){
          TeamScore teamScore = scoreUpdateServiceForIndia.getTeamScore(over);
          System.out.println(scoreFormatService.showFormattedScore(teamScore));
      }

      for(BallScore[] over : oversForPak ){
          TeamScore teamScore = scoreUpdateServiceForPak.getTeamScore(over);
          System.out.println(scoreFormatService.showFormattedScore(teamScore));
      }
  }
}
