package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class DefensiveLineman extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int runStop, passRush, tackling;
    
    // class constructor //
    public DefensiveLineman(int runStop, int passRush, int tackling)  {
        super();
        this.setPosition("DL");
        this.runStop = runStop;
        this.passRush = passRush;
        this.tackling = tackling;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Run Stopping: +" + runStop + "\n" +
                "Pass Rushing: +" + passRush + "\n" +
                "Tackling: +" + tackling + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <RST: +" + runStop + 
                ",  PSR: +" + passRush + 
                ",  TKL: +" + tackling + ">" + "\n";
    }
    
    @Override
    public int getAbility(int runStopWeight, int passRushWeight, int tacklingWeight)  {
        int total = (runStop * runStopWeight) + (passRush * passRushWeight) + (tackling * tacklingWeight);
        total = Math.round(total / 20);
        return total;
    }
}
