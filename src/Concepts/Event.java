package Concepts;

import lombok.Getter;
import Helpers.Numbers;

public class Event {
    
    // class fields //
    @Getter
    private final String state;
    
    @Getter
    private final int minYds, maxYds;
    
    // class constructor //
    public Event(String state, int maxYds, int minYds)  {
        this.state = state;
        this.minYds = minYds;
        this.maxYds = maxYds;
    }
    
    // class constructor //
    public int getYds()  {
        return Numbers.randomInRange(minYds, maxYds);
    }
    
    
}
