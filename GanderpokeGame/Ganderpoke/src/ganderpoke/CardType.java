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
public enum CardType {
    JOKER("JOKER"), NORMAL_CARD("NORMAL_CARD");
    
    private final String name;
    
    CardType(String name) {
        this.name = name;
    }
    
    //to string
    @Override
    public String toString() {
        return this.name;
    }
}
