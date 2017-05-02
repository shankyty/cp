public class PrimeSoccer {

  public double getProbability(int skillOfTeamA, int skillOfTeamB) {
    int ncr = 18;
    double roundGoalA = skillOfTeamA / 100.0;
    double roundGoalB = skillOfTeamB / 100.0;
    double roundNoGoalA = 1 - roundGoalA;
    double roundNoGoalB = 1 - roundGoalB;
    double resA = 0.0;
    double resB = 0.0;
    for (int i = 1; i < 18; i++) {
      if (i == 2 || i == 3 || i == 5 || i == 7 || i == 11 || i == 13 || i == 17) {
        resA += ncr * Math.pow(roundGoalA, i) * Math.pow(roundNoGoalA, 18 - i);
        resB += ncr * Math.pow(roundGoalB, i) * Math.pow(roundNoGoalB, 18 - i);
      }
      ncr = ncr * (18 - i) / (i + 1);
    }

    return resA + resB - resA * resB;
  }
}
