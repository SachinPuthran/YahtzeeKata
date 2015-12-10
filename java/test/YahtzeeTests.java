import static org.junit.Assert.*;

import org.junit.Test;

public class YahtzeeTests {

    @Test
    public void yahtzeeTakes5DiceValues() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new Yahtzee(1, 2, 3, 4, 5).dice);
    }

    @Test
    public void yahtzeeWith11244PlacedOnOnesGives2Points() {
        assertEquals(2, new Yahtzee(1, 1, 2, 4, 4).ones());
    }

    @Test
    public void yahtzeeWith12244PlacedOnOnesGives1Points() {
        assertEquals(1, new Yahtzee(1, 2, 2, 4, 4).ones());
    }

    @Test
    public void yahtzeeWith12244PlacedOnTwosGives4Points() {
        assertEquals(4, new Yahtzee(1, 2, 2, 4, 4).twos());
    }

    @Test
    public void yahtzeeWith12244PlacedOnThreesGives0Points() {
        assertEquals(0, new Yahtzee(1, 2, 2, 4, 4).threes());
    }

    @Test
    public void yahtzeeWith12334PlacedOnThreesGives6Points() {
        assertEquals(6, new Yahtzee(1, 2, 3, 3, 4).threes());
    }

    @Test
    public void yahtzeeWith11244PlacedOnFoursGives8Points() {
        assertEquals(8, new Yahtzee(1, 1, 2, 4, 4).fours());
    }

    @Test
    public void yahtzeeWith11444PlacedOnFoursGives12Points() {
        assertEquals(12, new Yahtzee(1, 1, 4, 4, 4).fours());
    }

    @Test
    public void yahtzeeWith51544PlacedOnFivesGives10Points() {
        assertEquals(10, new Yahtzee(5, 1, 5, 4, 4).fives());
    }

    @Test
    public void yahtzeeWith66646PlacedOnSixesGives24Points() {
        assertEquals(24, new Yahtzee(6, 6, 6, 4, 6).sixes());
    }

    @Test
    public void yahtzeeWith33344PlacedOnPairGives8Points() {
        assertEquals(8, new Yahtzee(3, 3, 3, 4, 4).pair());
    }

    @Test
    public void yahtzeeWith31524PlacedOnPairGives0Points() {
        assertEquals(0, new Yahtzee(3, 1, 5, 2, 4).pair());
    }

    @Test
    public void yahtzeeWith11233PlacedOnTwoPairsGives8Points() {
        assertEquals(8, new Yahtzee(1, 1, 2, 3, 3).twoPairs());
    }

    @Test
    public void yahtzeeWith14233PlacedOnTwoPairsGives0Points() {
        assertEquals(0, new Yahtzee(1, 4, 2, 3, 3).twoPairs());
    }

    @Test
    public void yahtzeeWith33345PlacedOnThreeOfAKindGives9Points() {
        assertEquals(9, new Yahtzee(3, 3, 3, 4, 5).threeOfAKind());
    }

    @Test
    public void yahtzeeWith53255PlacedOnThreeOfAKindGives15Points() {
        assertEquals(15, new Yahtzee(5, 3, 2, 5, 5).threeOfAKind());
    }

    @Test
    public void yahtzeeWith53225PlacedOnThreeOfAKindGives0Points() {
        assertEquals(0, new Yahtzee(5, 3, 2, 2, 5).threeOfAKind());
    }

    @Test
    public void yahtzeeWith22225PlacedOnFourOfAKindGives8Points() {
        assertEquals(8, new Yahtzee(2, 2, 2, 2, 5).fourOfAKind());
    }

    @Test
    public void yahtzeeWith12345PlacedOnSmallStraightGives15Points() {
        assertEquals(15, new Yahtzee(1, 2, 3, 4, 5).smallStraight());
    }

    @Test
    public void yahtzeeWith23456PlacedOnSmallStraightGives0Points() {
        assertEquals(0, new Yahtzee(2, 3, 4, 5, 6).smallStraight());
    }

    @Test
    public void yahtzeeWith23456PlacedOnLargeStraightGives20Points() {
        assertEquals(20, new Yahtzee(2, 3, 4, 5, 6).largeStraight());
    }

    @Test
    public void yahtzeeWith12345PlacedOnLargeStraightGives0Points() {
        assertEquals(0, new Yahtzee(1, 2, 3, 4, 5).largeStraight());
    }

    @Test
    public void yahtzeeWith11222PlacedOnFullHouseGives8Points() {
        assertEquals(8, new Yahtzee(1, 1, 2, 2, 2).fullHouse());
    }

    @Test
    public void yahtzeeWith11322PlacedOnFullHouseGives0Points() {
        assertEquals(0, new Yahtzee(1, 1, 3, 2, 2).fullHouse());
    }

    @Test
    public void yahtzeeWith11111PlacedOnYahtzeeGives50Points() {
        assertEquals(50, new Yahtzee(1, 1, 1, 1, 1).yahtzee());
    }

    @Test
    public void yahtzeeWith11115PlacedOnYahtzeeGives0Points() {
        assertEquals(0, new Yahtzee(1, 1, 1, 1, 5).yahtzee());
    }

    @Test
    public void yahtzeeWith14234PlacedOnChanceGives14Points() {
        assertEquals(14, new Yahtzee(1, 4, 2, 3, 4).chance());
    }

}