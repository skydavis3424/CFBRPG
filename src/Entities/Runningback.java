package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class Runningback extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int speed, power, vision;
    
    // class constructor //
    public Runningback(int speed, int power, int vision)  {
        super();
        this.setPosition("RB");
        this.speed = speed;
        this.power = power;
        this.vision = vision;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Speed: +" + speed + "\n" +
                "Power: +" + power + "\n" +
                "Vision: +" + vision + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <SPD: +" + speed + 
                ",  PWR: +" + power + 
                ",  VIS: +" + vision + ">" + "\n";
    }
    
    @Override
    public int getAbility(int speedWeight, int powerWeight, int visionWeight)  {
        int total = (speed * speedWeight) + (power * powerWeight) + (vision * visionWeight);
        return Math.round(total / 20);
    }
    
}
