package Entities;

import Concepts.OffensiveConcept;
import Concepts.DefensiveConcept;
import Helpers.Numbers;
import Helpers.Calculator;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

public class Game {
    
    // class fields //
    @Getter @Setter
    private Team homeTeam, awayTeam;
    
    @Getter @Setter
    private String state;
    
    @Getter @Setter
    private int homeScore, awayScore, turn, maxTurn, down, distance, differential, ydLine, ydsGained, offensiveRoll, defensiveRoll;
    
    @Getter @Setter
    private boolean homeHasBall;
    
    @Getter @Setter
    private OffensiveConcept currentOffensiveConcept;
    
    @Getter @Setter
    private DefensiveConcept currentDefensiveConcept;
    
    
    // class constructor //
    public Game(Team homeTeam, Team awayTeam)  {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScore = 0;
        awayScore = 0;
        turn = 1;
        maxTurn = 100;
        down = 1;
        distance = 10;
        ydLine = 20;
        ydsGained = 0;
        homeHasBall = false;
        offensiveRoll = 0;
        defensiveRoll = 0;
        currentOffensiveConcept = hasBall().getOffensiveConcepts().get(0);
        currentDefensiveConcept = onDefense().getDefensiveConcepts().get(0);
        state = "NORMAL";
    }
    
    
    // class methods //
    private void changePossession()  {
        if (homeHasBall == true)  {
            homeHasBall = false;
        } else if (homeHasBall == false)  {
            homeHasBall = true;
        }
    }
    
    private Team hasBall()  {
        Team hasBall = homeTeam;
        if (homeHasBall == true)  {
            hasBall = homeTeam;
        } else if (homeHasBall == false)  {
            hasBall = awayTeam;
        }
        
        return hasBall;
    }
    
    private Team onDefense()  {
        Team onDefense = homeTeam;
        if (homeHasBall == true)  {
            onDefense = awayTeam;
        } else if (homeHasBall == false)  {
            onDefense = homeTeam;
        }
        
        return onDefense;
    }
    
    private String prePlayLog()  {
        return "Has Ball: " + hasBall().getName() + "\n" +
                "Down: " + down + "\n" + 
                "Distance: " + distance + "\n" +
                "Yd Line: " + fieldPosition() + "\n" +
                "Turn: " + turn + "/" + maxTurn;
    }
    
    private String postPlayLog()  {
        return "Result: " + hasBall().getName() + " gains " + ydsGained + " yds" + "\n" +
                "Offensive Concept: " + currentOffensiveConcept.getName() + " (+" + offensiveRoll + ")" + "\n" +
                "Defensive Concept: " + currentDefensiveConcept.getName() + " (+" + defensiveRoll + ")" + "\n";
        
    }
    
    private String fieldPosition()  {
        String fieldPosition = " ";
        if (ydLine == 50)  {
            fieldPosition = "50 yd line";
        } else if (ydLine < 50)  {
            fieldPosition = hasBall().getName() + " " + ydLine + " yd line";
        } else if (ydLine > 50)  {
            fieldPosition = onDefense().getName() + " " + (100 - ydLine) + " yd line";
        }
        
        return fieldPosition;
    }
    
    private void checkForTouchdown()  {
        if (ydLine >= 100)  {
            if (hasBall() == homeTeam)  {
                homeScore = homeScore + 6;
            } else if (hasBall() == awayTeam)  {
                awayScore = awayScore + 6;
            }
            
            changePossession();
            down = 1;
            distance = 10;
            ydLine = 20;
        }
    }
    
    private void checkForFirstDown()  {
        if (ydsGained >= distance)  {
            down = 1;
            distance = 10;
        } else {
            down++;
            distance = distance - ydsGained;
        }
    }
    
    private void checkForSafety()  {
        if (ydLine <= 0)  {
            if (hasBall() == homeTeam)  {
                homeScore = homeScore + 2;
            } else if (hasBall() == awayTeam)  {
                awayScore = awayScore + 2;
            }
            
            changePossession();
            down = 1;
            distance = 10;
            ydLine = 40;
        }
    }
    
    private void checkForTurnoverOnDowns()  {
        if (down > 4)  {
            changePossession();
            down = 1;
            distance = 10;
            ydLine = 100 - ydLine;
        }
    }
    
    private void checkForHalftime()  {
        if (turn == 50)  {
            homeHasBall = true;
            down = 1;
            distance = 10;
            ydLine = 20;
        }
    }
    
    private void selectConcepts()  {
        currentOffensiveConcept = hasBall().chooseOffensiveConcept();
        currentDefensiveConcept = onDefense().chooseDefensiveConcept();
    }
    
    private HashMap<String, Integer> getRolls()  {
        HashMap<String, Integer> teamRolls = Calculator.calculatePlay(hasBall(), currentOffensiveConcept, onDefense(), currentDefensiveConcept);
        return teamRolls;
    }
    
    
    private void runPlay()  {
        System.out.println(prePlayLog());
        selectConcepts();
        HashMap<String, Integer> results = getRolls();
        offensiveRoll = results.get("OFFENSIVE_ROLL");
        defensiveRoll = results.get("DEFENSIVE_ROLL");
        differential = offensiveRoll - defensiveRoll;
        ydsGained = Calculator.calculateYds(currentOffensiveConcept, differential);
        state = Calculator.calculateState(currentOffensiveConcept, differential);
        ydLine = ydLine + ydsGained;
        System.out.println(postPlayLog());
        checkForSafety();
        checkForTouchdown();
        checkForFirstDown();
        checkForTurnoverOnDowns();
        checkForHalftime();
        turn++;
    }
    
    public void testGame()  {
        while (turn <= maxTurn)  {
            runPlay();
        }
        System.out.println(homeTeam.getName() + " " + homeScore + "\n" +
                awayTeam.getName() + " " + awayScore + "\n");
    }
    
    
    
}
