package me.LPbigFish;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Table {
    public final Map<String, Integer> ratios = new HashMap<>();
    private Player[] players;

    private Pad[] pads = new Pad[37];
    private Random random = new Random();

    public Table() {
        String[] ratios_arr = "RED 2 BLACK 2 GREEN 14 ODD 2 EVEN 2 1-18 2 19-36 2 1ST12 3 2ND12 3 3RD12 3 1stR 3 2ndR 3 3rdR 3 TWOS 17 TREES 11 FOURS 8 SIXES 5".split(" ");
        for (int i = 0; i < ratios_arr.length; i += 2) {
            ratios.put(ratios_arr[i], Integer.parseInt(ratios_arr[i + 1]));
        }
        for (int i = 0; i < pads.length; i++) {
            pads[i] = new Pad(i);
        }
        players = new Player[5];
        players[0] = new Player(2000);
    }

    public void play() {
        for (Player player : players) {
            if (player == null)
                continue;
            player.resetBets();
            if (!player.getStrategy().resolveStrategy())
                break;
            for (int i = 0; i < player.getStrategy().betTypes.length; i++) {
                player.bet(player.getStrategy().betTypes[i], player.getStrategy().betAmounts[i]);
            }
        }

        random.setSeed(System.currentTimeMillis());

    }

}

