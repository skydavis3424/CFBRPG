package Concepts;

import lombok.Getter;
import lombok.Setter; 
import java.util.HashMap;

public class DefensiveConcept {
    
    // class fields //
    @Getter
    private String name;
    
    @Getter @Setter
    private HashMap<OffensiveConcept, Integer> affinities;
    
    
    // class constructor //
    public DefensiveConcept(String name)  {
        this.name = name;
        this.affinities = new HashMap();
    }
    
    
    // class methods //
    public int getAffinity(OffensiveConcept offensiveConcept)  {
        return affinities.get(offensiveConcept);
    }
    
}
