package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class OffensiveLineman extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int runBlock, passBlock, zoneBlock;
    
    // class constructor //
    public OffensiveLineman(int runBlock, int passBlock, int zoneBlock)  {
        super();
        this.setPosition("OL");
        this.runBlock = runBlock;
        this.passBlock = passBlock;
        this.zoneBlock = zoneBlock;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Run Blocking: +" + runBlock + "\n" +
                "Pass Blocking: +" + passBlock + "\n" +
                "Zone Blocking: +" + zoneBlock + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <RBK: +" + runBlock + 
                ",  PBK: +" + passBlock + 
                ",  ZBK: +" + zoneBlock + ">" + "\n";
    }
    
    @Override
    public int getAbility(int runBlockWeight, int passBlockWeight, int zoneBlockWeight)  {
        int total = (runBlock * runBlockWeight) + (passBlock * passBlockWeight) + (zoneBlock * zoneBlockWeight);
        total = Math.round(total / 20);
        return total;
    }
    
}
