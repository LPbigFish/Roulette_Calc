package me.LPbigFish;

import java.util.HashMap;
import java.util.Map;

public class Table {
    public final Map<String, Integer> ratios = new HashMap<>();

    public Table() {
        String[] ratios_arr = "RED 2 BLACK 2 GREEN 14 ODD 2 EVEN 2 1-18 2 19-36 2 1ST12 3 2ND12 3 3RD12 3 1stR 3 2ndR 3 3rdR 3".split(" ");
        for (int i = 0; i < ratios_arr.length; i += 2) {
            ratios.put(ratios_arr[i], Integer.parseInt(ratios_arr[i + 1]));
        }
    }

}

