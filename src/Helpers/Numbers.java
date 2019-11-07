package Helpers;

import java.util.Random;

public abstract class Numbers {
    
    // class fields //
    public static Random rand = new Random();
    
    // class methods //
    public static int randomInRange(int min, int max)  {
        return rand.nextInt(max - min) + min;
    }
    
    public static boolean isInRange(int num, int min, int max)  {
        boolean result = false;
        if (num >= min && num <= max)  {
            result = true;
        }
        return result;
    }
    
    public static int dice(int times, int sides)  {
        int result = 0;
        for (int i = 0; i < times; i++)  {
            result = result + rand.nextInt(sides) + 1;
        }
        return result;
    }
}
