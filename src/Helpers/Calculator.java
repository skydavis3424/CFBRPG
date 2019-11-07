package Helpers;

import Concepts.DefensiveConcept;
import Concepts.OffensiveConcept;
import Entities.Team;
import java.util.HashMap;

public class Calculator {
    
    // class methods //
    private static int calculateOffensiveRoll(Team offense, OffensiveConcept offensiveConcept)  {
        return offense.getOffensiveSkill(offensiveConcept) + Numbers.dice(1, 20);
    }
    
    private static int calculateDefensiveRoll(Team defense, DefensiveConcept defensiveConcept, OffensiveConcept offensiveConcept)  {
        return defense.getDefensiveSkill(offensiveConcept) + defensiveConcept.getAffinity(offensiveConcept) + offensiveConcept.getDifficulty();
    }
    
    public static HashMap<String, Integer> calculatePlay(Team offense, OffensiveConcept offensiveConcept, Team defense, DefensiveConcept defensiveConcept)  {
        HashMap<String, Integer> results = new HashMap();
        int offensiveRoll = calculateOffensiveRoll(offense, offensiveConcept);
        int defensiveRoll = calculateDefensiveRoll(defense, defensiveConcept, offensiveConcept);
        results.put("OFFENSIVE_ROLL", offensiveRoll);
        results.put("DEFENSIVE_ROLL", defensiveRoll);
        return results;
    }
    
    public static int calculateYds(OffensiveConcept offensiveConcept, int differential)  {
        return offensiveConcept.getYds(differential);
    }
    
    public static String calculateState(OffensiveConcept offensiveConcept, int differential)  {
        return offensiveConcept.getState(differential);
    }
    
}
