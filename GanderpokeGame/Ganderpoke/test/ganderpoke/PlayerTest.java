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
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore() {
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        int testScore = player1.getScore();
        assert testScore == 0 : "Player starts with score 0";
        
        //invoke method
        player1.setScore(432);
        
        int testScore1 = player1.getScore();
        assert testScore1 == 432 : "Player should have a score of 432";
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        //get a player and hand
        Hand hand1 = new Hand();
        Player player1 = new Player(PlayerNumber.PLAYER1, 0, hand1);
        
        //invoke method
        String testString = player1.toString();
        
        assert testString.equals("PLAYER1") : "PLAYER1";
    }
    
}
