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
public class SquareTest {
    
    public SquareTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of setCards method, of class Square.
     */
    @Test
    public void testSetCards() {
        //create and shuffle a pack
        Pack pack = new Pack();
        pack.shuffle();
        
        //get a player and hand
        Square square1 = new Square();
        
        boolean testValue = square1.getCards().isEmpty();
        assert testValue == true : "hand1 starts with 0 cards";
        
        //invoke method
        square1.setCards(pack.getCardsForSquare());
        
        assert square1.getCards().size() == 25 : "hand1 has 8 cards";
        
    }

    /**
     * Test of removeCard method, of class Square.
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
     * Test of placeCard method, of class Square.
     */
    @Test
    public void testPlaceCard() {
        
    }

    /**
     * Test of notAllFaceUpCards method, of class Square.
     */
    @Test
    public void testNotAllFaceUpCards() {
    }

    /**
     * Test of makeHighCombo method, of class Square.
     */
    @Test
    public void testMakeHighCombo() {
    }

}    