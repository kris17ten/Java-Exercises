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
public enum PlayerNumber {
    PLAYER1("PLAYER1"), PLAYER2("PLAYER2");
    
    private final String name;
    
    PlayerNumber(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
