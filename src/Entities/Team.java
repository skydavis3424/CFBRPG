package Entities;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Random;
import Helpers.Numbers;
import Interfaces.Inspectable;
import Concepts.OffensiveConcept;
import Concepts.DefensiveConcept;

public class Team implements Inspectable {
    
    // class fields //
    private static final int MAX_QB = 2;
    private static final int MAX_RB = 3;
    private static final int MAX_WR = 5;
    private static final int MAX_OL = 5;
    private static final int MAX_DL = 5;
    private static final int MAX_LB = 5;
    private static final int MAX_DB = 5;
    private static final int MAX_PK = 1;
    
    @Getter @Setter
    private String name, mascot;
    
    @Getter 
    private ArrayList<Quarterback> qbs;
    
    @Getter 
    private ArrayList<Runningback> rbs;
    
    @Getter 
    private ArrayList<WideReceiver> wrs;
    
    @Getter 
    private ArrayList<OffensiveLineman> ols;
    
    @Getter 
    private ArrayList<DefensiveLineman> dls;
    
    @Getter 
    private ArrayList<Linebacker> lbs;
    
    @Getter 
    private ArrayList<DefensiveBack> dbs;
    
    @Getter 
    private ArrayList<Kicker> pks;
    
    @Getter @Setter
    private ArrayList<OffensiveConcept> offensiveConcepts;
    
    @Getter @Setter
    private ArrayList<DefensiveConcept> defensiveConcepts;
    
    
    // class constructor //
    public Team(String name, String mascot)  {
        this.name = name;
        this.mascot = mascot;
        this.qbs = new ArrayList();
        this.rbs = new ArrayList();
        this.wrs = new ArrayList();
        this.ols = new ArrayList();
        this.dls = new ArrayList();
        this.lbs = new ArrayList();
        this.dbs = new ArrayList();
        this.pks = new ArrayList();
        this.offensiveConcepts = new ArrayList();
        this.defensiveConcepts = new ArrayList();
    }
    
    
    // class methods //
    public void init(int offensiveSkill, int defensiveSkill)  {
        int offMax = offensiveSkill;
        int offMin = offensiveSkill - 3;
        int defMax = defensiveSkill;
        int defMin = defensiveSkill - 3;
        
        for (int i = 0; i < MAX_QB; i++)  {
            int throwing = Numbers.randomInRange(offMin, offMax);
            int running = Numbers.randomInRange(offMin, offMax);
            int intelligence = Numbers.randomInRange(offMin, offMax);
            qbs.add(new Quarterback(throwing, running, intelligence));
        }
        for (int i = 0; i < MAX_RB; i++)  {
            int speed = Numbers.randomInRange(offMin, offMax);
            int power = Numbers.randomInRange(offMin, offMax);
            int vision = Numbers.randomInRange(offMin, offMax);
            rbs.add(new Runningback(speed, power, vision));
        }
        for (int i = 0; i < MAX_WR; i++)  {
            int speed = Numbers.randomInRange(offMin, offMax);
            int hands = Numbers.randomInRange(offMin, offMax);
            int routeRunning = Numbers.randomInRange(offMin, offMax);
            wrs.add(new WideReceiver(speed, hands, routeRunning));
        }
        for (int i = 0; i < MAX_OL; i++)  {
            int runBlock = Numbers.randomInRange(offMin, offMax);
            int passBlock = Numbers.randomInRange(offMin, offMax);
            int zoneBlock = Numbers.randomInRange(offMin, offMax);
            ols.add(new OffensiveLineman(runBlock, passBlock, zoneBlock));
        }
        for (int i = 0; i < MAX_DL; i++)  {
            int runStop = Numbers.randomInRange(offMin, offMax);
            int passRush = Numbers.randomInRange(offMin, offMax);
            int tackling = Numbers.randomInRange(offMin, offMax);
            dls.add(new DefensiveLineman(runStop, passRush, tackling));
        }
        for (int i = 0; i < MAX_LB; i++)  {
            int speed = Numbers.randomInRange(offMin, offMax);
            int tackling = Numbers.randomInRange(offMin, offMax);
            int coverage = Numbers.randomInRange(offMin, offMax);
            lbs.add(new Linebacker(speed, tackling, coverage));
        }
        for (int i = 0; i < MAX_DB; i++)  {
            int speed = Numbers.randomInRange(offMin, offMax);
            int tackling = Numbers.randomInRange(offMin, offMax);
            int coverage = Numbers.randomInRange(offMin, offMax);
            dbs.add(new DefensiveBack(speed, tackling, coverage));
        }
        for (int i = 0; i < MAX_PK; i++)  {
            int kicking = Numbers.randomInRange(10, 20);
            int punting = Numbers.randomInRange(10, 20);
            pks.add(new Kicker(kicking, punting));
        }
    }
    
    @Override
    public String getInfo()  {
        String info = this.name + " " + this.mascot + "\n";
        
        for (int i = 0; i < MAX_QB; i++)  {
            info = info.concat(qbs.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_RB; i++)  {
            info = info.concat(rbs.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_WR; i++)  {
            info = info.concat(wrs.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_OL; i++)  {
            info = info.concat(ols.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_DL; i++)  {
            info = info.concat(dls.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_LB; i++)  {
            info = info.concat(lbs.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_DB; i++)  {
            info = info.concat(dls.get(i).getQuickInfo());
        }
        
        for (int i = 0; i < MAX_PK; i++)  {
            info = info.concat(pks.get(i).getQuickInfo());
        }
        
        return info;
    }
    
    @Override
    public String getQuickInfo()  {
        return this.name + " " + this.mascot;
    }
    
    public String getDetailedRoster()  {
        String info = this.name + " " + this.mascot + "\n";
        
        for (int i = 0; i < MAX_QB; i++)  {
            info = info.concat(qbs.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_RB; i++)  {
            info = info.concat(rbs.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_WR; i++)  {
            info = info.concat(wrs.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_OL; i++)  {
            info = info.concat(ols.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_DL; i++)  {
            info = info.concat(dls.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_LB; i++)  {
            info = info.concat(lbs.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_DB; i++)  {
            info = info.concat(dls.get(i).getInfo());
        }
        
        for (int i = 0; i < MAX_PK; i++)  {
            info = info.concat(pks.get(i).getInfo());
        }
        
        return info;
    }
    
    public OffensiveConcept chooseOffensiveConcept() {
        Random rand = new Random();
        return offensiveConcepts.get(rand.nextInt(offensiveConcepts.size()));
    }
    
    public DefensiveConcept chooseDefensiveConcept() {
        Random rand = new Random();
        return defensiveConcepts.get(rand.nextInt(defensiveConcepts.size()));
    }
    
    public int getOffensiveSkill(OffensiveConcept offensiveConcept)  {
        Quarterback qb = qbs.get(0);
        Runningback rb = rbs.get(0);
        WideReceiver wr1 = wrs.get(0);
        WideReceiver wr2 = wrs.get(1);
        OffensiveLineman ol1 = ols.get(0);
        OffensiveLineman ol2 = ols.get(1);
        OffensiveLineman ol3 = ols.get(2);
        int teamSkill = 0;
        
        switch(offensiveConcept.getName())  {
            case "Zone Read Option":
                teamSkill += qb.getAbility(0, 7, 3) * 2;
                teamSkill += rb.getAbility(4, 4, 3) * 2;
                teamSkill += wr1.getAbility(0, 0, 0) * 0;
                teamSkill += wr2.getAbility(0, 0, 0) * 0;
                teamSkill += ol1.getAbility(5, 0, 5) * 2;
                teamSkill += ol2.getAbility(5, 0, 5) * 2;
                teamSkill += ol3.getAbility(5, 0, 5) * 2;
                break;
                
            case "RB Power Run":
                teamSkill += qb.getAbility(0, 0, 0) * 0;
                teamSkill += rb.getAbility(2, 5, 3) * 4;
                teamSkill += wr1.getAbility(0, 0, 0) * 0;
                teamSkill += wr2.getAbility(0, 0, 0) * 0;
                teamSkill += ol1.getAbility(10, 0, 0) * 2;
                teamSkill += ol2.getAbility(10, 0, 0) * 2;
                teamSkill += ol3.getAbility(10, 0, 0) * 2;
                break;
                
            case "WR Quick Slant":
                teamSkill += qb.getAbility(8, 0, 2) * 3;
                teamSkill += rb.getAbility(0, 0, 0) * 0;
                teamSkill += wr1.getAbility(4, 4, 2) * 2;
                teamSkill += wr2.getAbility(4, 4, 2) * 2;
                teamSkill += ol1.getAbility(0, 10, 0) * 1;
                teamSkill += ol2.getAbility(0, 10, 0) * 1;
                teamSkill += ol3.getAbility(0, 10, 0) * 1;
                break;
        }
        
        return Math.round(teamSkill / 50);
        
     }
    
    public int getDefensiveSkill(OffensiveConcept offensiveConcept)  {
        DefensiveLineman dl1 = dls.get(0);
        DefensiveLineman dl2 = dls.get(1);
        DefensiveLineman dl3 = dls.get(2);
        Linebacker lb1 = lbs.get(0);
        Linebacker lb2 = lbs.get(1);
        DefensiveBack db1 = dbs.get(0);
        DefensiveBack db2 = dbs.get(1);
        int teamSkill = 0;
        
        switch(offensiveConcept.getName())  {
            case "Zone Read Option":
                teamSkill += dl1.getAbility(6, 0, 4) * 2;
                teamSkill += dl2.getAbility(6, 0, 4) * 2;
                teamSkill += dl3.getAbility(6, 0, 4) * 2;
                teamSkill += lb1.getAbility(4, 0, 6) * 2;
                teamSkill += lb2.getAbility(4, 0, 6) * 2;
                teamSkill += db1.getAbility(0, 0, 0) * 0;
                teamSkill += db2.getAbility(0, 0, 0) * 0;
                break;
                
            case "RB Power Run":
                teamSkill += dl1.getAbility(6, 0, 4) * 2;
                teamSkill += dl2.getAbility(6, 0, 4) * 2;
                teamSkill += dl3.getAbility(6, 0, 4) * 2;
                teamSkill += lb1.getAbility(2, 0, 8) * 2;
                teamSkill += lb2.getAbility(2, 0, 8) * 2;
                teamSkill += db1.getAbility(0, 0, 0) * 0;
                teamSkill += db2.getAbility(0, 0, 0) * 0;
                break;
                
            case "WR Quick Slants":
                teamSkill += dl1.getAbility(0, 10, 0) * 1;
                teamSkill += dl2.getAbility(0, 10, 0) * 1;
                teamSkill += dl3.getAbility(0, 10, 0) * 1;
                teamSkill += lb1.getAbility(0, 10, 0) * 2;
                teamSkill += lb2.getAbility(0, 10, 0) * 1;
                teamSkill += db1.getAbility(5, 5, 0) * 2;
                teamSkill += db2.getAbility(5, 5, 0) * 2;
                break;
        }
        
        return Math.round(teamSkill / 50);
                
    }
}
