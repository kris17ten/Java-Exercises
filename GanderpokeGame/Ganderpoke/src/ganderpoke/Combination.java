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
public enum Combination {
    STRAIGHT_FLUSH("STRAIGHT_FLUSH", 1), 
    FOUR_OF_A_KIND("FOUR_OF_A_KIND", 2), 
    FULL_HOUSE("FULL_HOUSE", 3),
    FLUSH("FLUSH", 4), 
    STRAIGHT("STRAIGHT", 5), 
    TRIPLET("TRIPLET", 6), 
    TWO_PAIR("TWO_PAIR", 7), 
    ONE_PAIR("ONE_PAIR", 8), 
    HIGH_CARD("HIGH_CARD", 9);
    
    private final String name;
    private final int numericValue;
    
    Combination(String name, int numericValue) {
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
