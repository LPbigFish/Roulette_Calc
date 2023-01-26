package me.LPbigFish;

import java.security.Key;

public class Strategy {

    private String name;

    int[] betAmounts;

    String[] betTypes;
    private String statement;

    public Strategy(String name, String bet, int amount) {
        this.name = name;
        betTypes = new String[]{bet};
        betAmounts = new int[]{amount};
    }

    public Strategy(String name, String[] betTypes, int[] betAmounts) {
        this.name = name;
        this.betTypes = betTypes;
        this.betAmounts = betAmounts;
    }

    public Strategy(String name, String[] betTypes, int[] betAmounts, String statement) {
        this.name = name;
        this.betTypes = betTypes;
        this.betAmounts = betAmounts;
        this.statement = statement;
    }

    public boolean resolveStrategy(int lastWin, int lastLose, Color lastColor) {
        if (statement == null) {
            return true;
        }
        String[] splitter = statement.split(";");
        for (int i = 0; i < splitter.length; i += 2) {
            if (KeyWords.valueOf(splitter[i]) == KeyWords.ALL) {
                return true;
            } else if (KeyWords.valueOf(splitter[i]) == KeyWords.WHEN) {
                String[] splitter2 = splitter[i + 1].split(" ");
                if (splitter2[0].equals("WIN")) {
                    if (lastWin == Integer.parseInt(splitter2[1])) {
                        return true;
                    }
                } else if (splitter2[0].equals("LOSE")) {
                    if (lastLose == Integer.parseInt(splitter2[1])) {
                        return true;
                    }
                } else if (splitter2[0].equals("COLOR")) {
                    if (lastColor == Color.valueOf(splitter2[1])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean resolveStrategy() {
        return true;
    }

    private enum KeyWords {
        ALL, WHEN, END, DOUBLE
    }

    public String getBet(int i) {
        return betTypes[i];
    }

    public int getAmount(int i) {
        return betAmounts[i];
    }
}
