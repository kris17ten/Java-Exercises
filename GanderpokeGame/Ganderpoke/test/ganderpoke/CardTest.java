/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristen
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getNumericValue method, of class Card.
     */
    @Test
    public void testGetNumericValue() {
        //new card to test
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN);
        
        //test suit
        int suitValue = testCard.getSuit().getNumericValue();
        assert suitValue == 3 : "Numerical value of clubs is 3";
        
        //test suit
        int rankValue = testCard.getRank().getNumericValue();
        assert rankValue == 5 : "Numerical value of nine is 5";
        
    }

    /**
     * Test of getRankAsNumber method, of class Card.
     */
    @Test
    public void testGetRankAsNumber() {
        //new card to test
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN);
        
        //invoke method
        int rankAsNumber = testCard.getRankAsNumber();
        
        assert rankAsNumber == 5 : "Numerical value of nine is 5";
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString2() {
        //new card to test
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN);
        
        //to string
        String testString = testCard.toString();
        
        assert testString.equals("**-***") : "To string method of face-down cards";
    }
    
    public void testToString1() {
        //new card to test
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_UP);
        
        //to string
        String testString = testCard.toString();
        
        assert testString.equals("9-CLUBS") : "To string method of face-up cards";
    }
    
}
