package Concepts;

import lombok.Getter;
import lombok.Setter;

public class OffensiveConcept {
    
    // class fields //
    @Getter
    private final String name, type;
    
    @Getter
    private final int critSuccessThreshold, critFailureThreshold, difficulty;
    
    @Getter @Setter
    private Event criticalFailureEvent, failureEvent, successEvent, criticalSuccessEvent;
    
    
    // class constructor //
    public OffensiveConcept(String name, String type, int difficulty, int critSuccessThreshold, int critFailureThreshold)  {
        this.name = name;
        this.type = type;
        this.difficulty = difficulty;
        this.critSuccessThreshold = critSuccessThreshold;
        this.critFailureThreshold = critFailureThreshold;
    }
    
    
    // class methods //
    private Event retrieveEvent(int differential)  {
        Event event;
        if (differential <= critFailureThreshold)  {
            event = criticalFailureEvent;
        } else if (differential >= critSuccessThreshold)  {
            event = criticalSuccessEvent;
        } else if (differential > 0)  {
            event = successEvent;
        } else  {
            event = failureEvent;
        }
        
        return event;
    }
    
    public int getYds(int differential)  {
        return retrieveEvent(differential).getYds();
    }
    
    public String getState(int differential)  {
        return retrieveEvent(differential).getState();
    }
    
    
}
