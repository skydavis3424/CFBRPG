package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class Linebacker extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int speed, tackling, coverage;
    
    // class constructor //
    public Linebacker(int speed, int tackling, int coverage)  {
        super();
        this.setPosition("LB");
        this.speed = speed;
        this.tackling = tackling;
        this.coverage = coverage;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Speed: +" + speed + "\n" +
                "Tackling: +" + tackling + "\n" +
                "Coverage: +" + coverage + "\n";
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
