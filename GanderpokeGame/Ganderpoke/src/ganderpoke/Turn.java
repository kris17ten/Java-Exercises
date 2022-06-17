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
public class Turn {
    private Player currentPlayer;
    
    //constructor
    public Turn(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    //blank constructor
    public Turn() {
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    
}
