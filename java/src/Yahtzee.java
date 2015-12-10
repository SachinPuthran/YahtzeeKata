import java.util.*;
import java.util.Map.Entry;

public class Yahtzee {

    protected int[] dice;

    public Yahtzee(int dice1, int dice2, int dice3, int dice4, int dice5) {
        dice = new int[5];
        dice[0] = dice1;
        dice[1] = dice2;
        dice[2] = dice3;
        dice[3] = dice4;
        dice[4] = dice5;
    }

    public int ones() {
        return sumDice(1);
    }

    public int twos() {
        return sumDice(2);
    }

    public int threes() {
        return sumDice(3);
    }

    public int fours() {
        return sumDice(4);
    }

    public int fives() {
        return sumDice(5);
    }

    public int sixes() {
        return sumDice(6);
    }

    private int sumDice(int expectedVal) {
        int sum = 0;
        for (int die : dice) {
            if (expectedVal == die) {
                sum += expectedVal;
            }
        }
        return sum;
    }


    public int pair() {
        Map<Integer, Integer> dieCount = getDieCountMap();
        for (int die = 6; die != 0; die--) {
            Integer count = dieCount.get(die);
            if (count != null && count >= 2) {
                return die * 2;
            }
        }

        return 0;
    }

    private Map<Integer, Integer> getDieCountMap() {
        Map<Integer, Integer> dieCount = new HashMap<>();
        for (int die : dice) {
            Integer count = dieCount.get(die);
            if (count == null) {
                count = 0;
            }
            dieCount.put(die, ++count);
        }
        return dieCount;
    }

    public int twoPairs() {
        Map<Integer, Integer> dieCount = getDieCountMap();
        int pairSum = 0;
        int pairCount = 0;
        for (Entry<Integer, Integer> dieEntry : dieCount.entrySet()) {
            if (dieEntry.getValue() >= 2) {
                pairSum += dieEntry.getKey();
                pairCount++;
            }
        }

        if (2 == pairCount) {
            return pairSum * 2;
        }
        return 0;
    }

    public int threeOfAKind() {
        return diceWithSameNumber(3);
    }

    public int fourOfAKind() {
        return diceWithSameNumber(4);
    }

    private int diceWithSameNumber(int diceKind) {
        Map<Integer, Integer> dieCount = getDieCountMap();
        for (Entry<Integer, Integer> dieEntry : dieCount.entrySet()) {
            if (dieEntry.getValue() >= diceKind) {
                return dieEntry.getKey() * diceKind;
            }
        }

        return 0;
    }

    public int smallStraight() {
        Arrays.sort(dice);
        if (dice[0] == 1 && dice[1] == 2 && dice[2] == 3 && dice[3] == 4 && dice[4] == 5) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        Arrays.sort(dice);
        if (dice[0] == 2 && dice[1] == 3 && dice[2] == 4 && dice[3] == 5 && dice[4] == 6) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        Map<Integer, Integer> dieCount = getDieCountMap();
        int fullHouseSum = 0;
        boolean pairFound = false;
        boolean tripletFound = false;
        for (Entry<Integer, Integer> dieEntry : dieCount.entrySet()) {
            Integer count = dieEntry.getValue();
            if (count == 2) {
                fullHouseSum += dieEntry.getKey() * 2;
                pairFound = true;
            }
            if (count == 3) {
                fullHouseSum += dieEntry.getKey() * 3;
                tripletFound = true;
            }
        }

        if (pairFound && tripletFound) {
            return fullHouseSum;
        }
        return 0;
    }

    public int yahtzee() {
        Map<Integer, Integer> dieCount = getDieCountMap();
        if (dieCount.keySet().size() == 1) {
            return 50;
        }
        return 0;
    }

    public int chance() {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }
}
