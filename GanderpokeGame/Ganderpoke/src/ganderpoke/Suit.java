/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

/**
 *
 * @author Kristen
 */
public enum Suit {
    DIAMONDS("DIAMONDS", 1), HEARTS("HEARTS", 2), CLUBS("CLUBS", 3),
    SPADES("SPADES", 4), NOT_RELEVANT("NOT_RELEVANT", 5);
    
    private final String name;
    private final int numericValue;
    
    Suit(String name, int numericValue) {
        this.name = name;
        this.numericValue = numericValue;
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public int getNumericValue() {
        return this.numericValue;
    }
    
    //to string
    @Override
    public String toString() {
        return this.name;
    }
}
