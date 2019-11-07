package Entities;

import lombok.Getter;
import lombok.Setter;
import Interfaces.Inspectable;
import Interfaces.Numerical;

public class Quarterback extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int throwing, running, intelligence;
    
    // class constructor //
    public Quarterback(int throwing, int running, int intelligence)  {
        super();
        this.setPosition("QB");
        this.throwing = throwing;
        this.running = running;
        this.intelligence = intelligence;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Throwing: +" + throwing + "\n" +
                "Running: +" + running + "\n" +
                "Intelligence: +" + intelligence + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <THR: +" + throwing + 
                ",  RUN: +" + running + 
                ",  INT: +" + intelligence + ">" + "\n";
    }
    
    @Override
    public int getAbility(int throwingWeight, int runningWeight, int intelligenceWeight)  {
        int total = (throwing * throwingWeight) + (running * runningWeight) + (intelligence * intelligenceWeight);
        return Math.round(total / 20);
    }
    
}
