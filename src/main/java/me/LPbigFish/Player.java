package me.LPbigFish;

import java.util.HashMap;
import java.util.Map;

public class Player {

    public Map<String, Integer> bets = new HashMap<>();

    public int capital;
    private Strategy strategy;

    public Player(int capital) {
        this.capital = capital;
        strategy = new Strategy("Default", "1-18", 10);
    }

    public void bet(String bet, int amount) {
        if (bets.containsKey(bet)) {
            bets.put(bet, bets.get(bet) + amount);
        } else {
            bets.put(bet, amount);
        }
    }

    public void resetBets() {
        bets.clear();
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
