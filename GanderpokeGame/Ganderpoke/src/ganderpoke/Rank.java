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
public enum Rank {
    FIVE("5", 1),
    SIX("6", 2),
    SEVEN("7", 3),
    EIGHT("8", 4),
    NINE("9", 5),
    TEN("10", 6),
    JACK("J", 7),
    QUEEN("Q", 8),
    KING("K", 9),
    ACE("A", 10),
    NOT_RELEVANT("NR", 11);

    private final String name;
    private final int numericValue;
    
    Rank(String name, int numericValue) {
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
