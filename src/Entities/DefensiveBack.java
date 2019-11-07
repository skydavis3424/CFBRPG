package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class DefensiveBack extends Player implements Inspectable, Numerical {
    
    // class methods //
    @Getter @Setter
    private int speed, coverage, tackling;
    
    // class constructor //
    public DefensiveBack(int speed, int coverage, int tackling)  {
        super();
        this.setPosition("DB");
        this.speed = speed;
        this.coverage = coverage;
        this.tackling = tackling;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Speed: +" + speed + "\n" +
                "Coverage: +" + coverage + "\n" +
                "Tackling: +" + tackling + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <SPD: +" + speed + 
                ",  COV: +" + coverage + 
                ",  TKL: +" + tackling + ">" + "\n";
    }
    
    @Override
    public int getAbility(int speedWeight, int coverageWeight, int tacklingWeight)  {
        int total = (speed * speedWeight) + (coverage * coverageWeight) + (tackling * tacklingWeight);
        total = Math.round(total / 20);
        return total;
    }
}
