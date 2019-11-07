package Entities;

import Helpers.Names;
import lombok.Getter;
import lombok.Setter;

public abstract class Player {
    
    // class fields //
    @Getter @Setter
    private String firstName, lastName, position;
    
    
    // class constructor //
    public Player()  {
        this.firstName = Names.getRandomPlayerFirstName();
        this.lastName = Names.getRandomPlayerLastName();
    }
    
    
    // class methods //
    public String getProfile()  {
        return "\n" + "Name: " + this.firstName + " " + this.lastName + "\n" +
                "Position: " + this.position + "\n";
    }
    
}
