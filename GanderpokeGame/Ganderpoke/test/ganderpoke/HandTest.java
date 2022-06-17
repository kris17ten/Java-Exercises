/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristen
 */
public class HandTest {
    
    public HandTest() {
    }
    
    @Before
    public void setUp() {
        //create and shuffle a pack
        Pack pack = new Pack();
        pack.shuffle();
        
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
    }

    /**
     * Test of setCards method, of class Hand.
     */
    
    @Test
    public void testSetCards() {
        //create and shuffle a pack
        Pack pack = new Pack();
        pack.shuffle();
        
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        boolean testValue = hand1.getCards().isEmpty();
        assert testValue == true : "hand1 starts with 0 cards";
        
        //invoke method
        player1.getHand().setCards(pack.getCardsForPlayerOne());
        
        assert hand1.getCards().size() == 8 : "hand1 has 8 cards";
        
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        //create and shuffle a pack
        Pack pack = new Pack();
        pack.shuffle();
        
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        //new card to add
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN);
        
        player1.getHand().setCards(pack.getCardsForPlayerOne());
        assert hand1.getCards().size() == 8 : "hand1 has 8 cards";
        
        //invoke method
        hand1.addCard(testCard);
        
        assert hand1.getCards().size() == 9 : "hand1 has 9 cards";
    }

    /**
     * Test of removeCard method, of class Hand.
     */
    @Test
    public void testRemoveCard() {
        //create and shuffle a pack
        Pack pack = new Pack();
        pack.shuffle();
        
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        //new card to add
        Card testCard = new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN);
        
        player1.getHand().setCards(pack.getCardsForPlayerOne());
        hand1.addCard(testCard);
        assert hand1.getCards().size() == 9 : "hand1 has 9 cards";
        
        //invoke method
        hand1.removeCard(testCard);
        
        assert hand1.getCards().size() == 8 : "hand1 has 8 cards";
    }

    /**
     * Test of makeHighCombo method, of class Hand.
     */
    @Test
    public void testMakeHighCombo() {
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        PokerCombo high = hand1.makeHighCombo(hand1.getCards());
        
        assert high.getCombo() == Combination.STRAIGHT_FLUSH : "Cards are in Straight Flush";
    }

    /**
     * Test of makeLowCombo method, of class Hand.
     */
    @Test
    public void testMakeLowCombo() {
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        PokerCombo low = hand1.makeLowCombo(hand1.getCards());
        
        assert low.getCombo() == Combination.STRAIGHT : "Cards are in Straight";
    }

    /**
     * Test of sortByRankAndSuit method, of class Hand.
     */
    @Test
    public void testSortByRankAndSuit() {
    }

    /**
     * Test of sortByRank method, of class Hand.
     */
    @Test
    public void testSortByRank() {
    }

    /**
     * Test of hasStraightFlush method, of class Hand.
     */
    @Test
    public void testHasStraightFlush() {
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertTrue(hand1.hasStraightFlush(hand1.getCards()));
    }

    /**
     * Test of hasFourOfAKind method, of class Hand.
     */
    @Test
    public void testHasFourOfAKind() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertFalse(hand1.hasFourOfAKind(hand1.getCards()));
    }

    /**
     * Test of hasFlush method, of class Hand.
     */
    @Test
    public void testHasFlush() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertTrue(hand1.hasFlush(hand1.getCards()));
    }

    /**
     * Test of hasStraight method, of class Hand.
     */
    @Test
    public void testHasStraight() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertTrue(hand1.hasStraight(hand1.getCards()));
    }

    /**
     * Test of hasFullHouse method, of class Hand.
     */
    @Test
    public void testHasFullHouse() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertFalse(hand1.hasFullHouse(hand1.getCards()));
    }

    /**
     * Test of hasTriplet method, of class Hand.
     */
    @Test
    public void testHasTriplet() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertFalse(hand1.hasTriplet(hand1.getCards()));
    }

    /**
     * Test of hasTwoPairs method, of class Hand.
     */
    @Test
    public void testHasTwoPairs() {
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertFalse(hand1.hasTwoPairs(hand1.getCards()));
    }

    /**
     * Test of hasOnePair method, of class Hand.
     */
    @Test
    public void testHasOnePair() {
        
        Hand hand1 = new Hand();
        
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        hand1.addCard(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));
        
        //invoke method
        assertFalse(hand1.hasOnePair(hand1.getCards()));
    }

    
}
