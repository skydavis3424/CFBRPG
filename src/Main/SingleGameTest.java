package Main;

import Concepts.DefensiveConcept;
import Concepts.OffensiveConcept;
import Concepts.Event;
import Entities.*;
import Helpers.*;
import Interfaces.*;

public class SingleGameTest {

    public static void main(String[] args) {
        // TODO code application logic here
        
 
        Team auburn = new Team("Auburn", "Tigers");
        auburn.init(20, 20);
        Team alabama = new Team("Alabama", "Crimson Tide");
        alabama.init(20, 20);
        
        OffensiveConcept zoneReadOption = new OffensiveConcept("Zone Read Option", "RUN", 5, 10, -10);
        zoneReadOption.setCriticalFailureEvent(new Event("FUMBLE", 1, 0));
        zoneReadOption.setFailureEvent(new Event("NORMAL", 2, 0));
        zoneReadOption.setSuccessEvent(new Event("NORMAL", 7, 3));
        zoneReadOption.setCriticalSuccessEvent(new Event("NORMAL", 20, 10));
        
        OffensiveConcept rbPowerRun = new OffensiveConcept("RB Power Run", "RUN", 3, 10, -10);
        rbPowerRun.setCriticalFailureEvent(new Event("FUMBLE", -1, -5));
        rbPowerRun.setFailureEvent(new Event("NORMAL", 3, -3));
        rbPowerRun.setSuccessEvent(new Event("NORMAL", 7, 3));
        rbPowerRun.setCriticalSuccessEvent(new Event("NORMAL", 20, 10));
        
        OffensiveConcept wrQuickSlants = new OffensiveConcept("WR Quick Slants", "PASS", 7, 8, -8);
        wrQuickSlants.setCriticalFailureEvent(new Event("INTERCEPTION", -1, -5));
        wrQuickSlants.setFailureEvent(new Event("PASS INCOMPLETE", 1, -1));
        wrQuickSlants.setSuccessEvent(new Event("NORMAL", 11, 5));
        wrQuickSlants.setCriticalSuccessEvent(new Event("NORMAL", 30, 15));
        
        
        DefensiveConcept fourThreeCoverOne = new DefensiveConcept("4-3 Cover One");
        fourThreeCoverOne.getAffinities().put(zoneReadOption, 5);
        fourThreeCoverOne.getAffinities().put(rbPowerRun, 6);
        fourThreeCoverOne.getAffinities().put(wrQuickSlants, 4);
        
        DefensiveConcept fourThreeManBlitz = new DefensiveConcept("4-3 Man Blitz");
        fourThreeManBlitz.getAffinities().put(zoneReadOption, 8);
        fourThreeManBlitz.getAffinities().put(rbPowerRun, 8);
        fourThreeManBlitz.getAffinities().put(wrQuickSlants, 0);
        
        DefensiveConcept nickelZoneCoverage = new DefensiveConcept("Nickel Zone Coverage");
        nickelZoneCoverage.getAffinities().put(zoneReadOption, 2);
        nickelZoneCoverage.getAffinities().put(rbPowerRun, 2);
        nickelZoneCoverage.getAffinities().put(wrQuickSlants, 8);
        
        
        auburn.getOffensiveConcepts().add(zoneReadOption);
        auburn.getOffensiveConcepts().add(rbPowerRun);
        auburn.getOffensiveConcepts().add(wrQuickSlants);
        auburn.getDefensiveConcepts().add(fourThreeCoverOne);
        auburn.getDefensiveConcepts().add(fourThreeManBlitz);
        auburn.getDefensiveConcepts().add(nickelZoneCoverage);
        
        alabama.getOffensiveConcepts().add(zoneReadOption);
        alabama.getDefensiveConcepts().add(fourThreeCoverOne);
        alabama.getOffensiveConcepts().add(rbPowerRun);
        alabama.getOffensiveConcepts().add(wrQuickSlants);
        alabama.getDefensiveConcepts().add(fourThreeCoverOne);
        alabama.getDefensiveConcepts().add(fourThreeManBlitz);
        
        Game game = new Game(auburn, alabama);
        game.testGame();
    }
    
}
