package Helpers;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Names {
    
    // class fields //
    private static final Random rand = new Random();
    
    private static final ArrayList<String> PLAYER_FIRST_NAMES = new ArrayList<>(Arrays.asList("Aaron", "Brian", "Curtis",
            "Derrick", "Ethan", "Jack", "James", "Kendrick", "Greg", "Alex", "Nick", "Kerryon", "Michael", "Cameron", "DeAndre",
            "Antonio", "Jeremy", "Luke", "Tristan", "DeAngelo", "Rashad", "Bo"));
    
    private static final ArrayList<String> PLAYER_LAST_NAMES = new ArrayList<>(Arrays.asList("Smith", "Love", "Robinson", "Abbott", "Myers",
            "Young", "Holiday", "Green", "Allison", "Ellis", "Carrol", "Williams", "Johnson", "Davis", "Klein", "Jackson", "Brown", "Baker", "Mays",
            "Mendenhall", "Scott", "White"));
    
    
    // class methods //
    public static String getRandomPlayerFirstName()  {
        int randIndex = rand.nextInt(PLAYER_FIRST_NAMES.size());
        return PLAYER_FIRST_NAMES.get(randIndex);
    }
    
    public static String getRandomPlayerLastName()  {
        int randIndex = rand.nextInt(PLAYER_LAST_NAMES.size());
        return PLAYER_LAST_NAMES.get(randIndex);
    }
}
