package me.LPbigFish;

import java.util.Arrays;

public class Pad {

    public final int number;

    public final Color color;

    public Pad(int number) {
        this.number = number;
        if (number == 0)
            this.color = Color.GREEN;
        else if (Arrays.stream(new int[]{32, 19, 21, 25, 34, 27, 36, 30, 23, 5, 16, 1, 14, 9, 18, 7, 12, 3}).anyMatch(i -> i == number))
            this.color = Color.RED;
        else
            this.color = Color.BLACK;
    }

}
