package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class Kicker extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int kicking, punting;
    
    // class constructor //
    public Kicker(int kicking, int punting)  {
        super();
        this.setPosition("PK");
        this.kicking = kicking;
        this.punting = punting;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Kicking: +" + kicking + "\n" +
                "Punting: +" + punting + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <KICK: +" + kicking + 
                ",  PUNT: +" + punting + "\n";
    }
    
    @Override
    public int getAbility(int kickingWeight, int puntingWeight, int nothingWeight)  {
        int total = (kicking * kickingWeight) + (punting * puntingWeight);
        total = Math.round(total / 20);
        return total;
    }
    
}
