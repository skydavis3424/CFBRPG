package Entities;

import Interfaces.Numerical;
import Interfaces.Inspectable;
import lombok.Getter;
import lombok.Setter;

public class WideReceiver extends Player implements Inspectable, Numerical {
    
    // class fields //
    @Getter @Setter
    private int speed, hands, routeRunning;
    
    // class constructor //
    public WideReceiver(int speed, int hands, int routeRunning)  {
        super();
        this.setPosition("WR");
        this.speed = speed;
        this.hands = hands;
        this.routeRunning = routeRunning;
    }
    
    // class methods //
    @Override
    public String getInfo()  {
        return getProfile() + 
                "Speed: +" + speed + "\n" +
                "Hands: +" + hands + "\n" +
                "Route Running +" + routeRunning + "\n";
    }
    
    @Override
    public String getQuickInfo()  {
        return this.getPosition() + 
                " " + this.getFirstName() + 
                " " + this.getLastName() + 
                "  <SPD: +" + speed + 
                ",  HND: +" + hands + 
                ",  ROU: +" + routeRunning + ">" + "\n";
    }
    
    @Override
    public int getAbility(int speedWeight, int handsWeight, int routeWeight)  {
        int total = (speed * speedWeight) + (hands * handsWeight) + (routeRunning * routeWeight);
        total = Math.round(total / 20);
        return total;
    }
    
}

