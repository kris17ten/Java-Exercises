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
public class Player {
    private final PlayerNumber player;
    private int score;
    private final Hand hand;

    //constructor
    public Player(PlayerNumber player, int score, Hand hand) {
        this.player = player;
        this.score = score;
        this.hand = hand;
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public PlayerNumber getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public Hand getHand() {
        return hand;
    }

    public void setScore(int score) {
        this.score += score;
    }
    
    //display player's hand
    public void displayHand() {
        for (int i = 0; i < this.getHand().getCards().size(); i++) {
            Card card = this.getHand().getCards().get(i);
            card.setState(State.IN_HAND);
        }
        for(int i=0; i < this.getHand().getCards().size(); i++) {
            System.out.print("  " + this.getHand().getCards().get(i).toString() + "  ");
        }
    }
    
    //select card from square
    public void selectCardFromHand(int index) {
        
        for(int i=0; i < this.getHand().getCards().size(); i++) {
            if(i == index) {
                
                    System.out.print(" >" + this.getHand().getCards().get(i).toString() + "< ");
                }
            
            else {
            System.out.print("  " + this.getHand().getCards().get(i).toString() + "  ");
            }
        }
    }
    
    //get card from hand
    public Card getCardFromHand(int index) {
        return this.getHand().getCards().get(index);
    }
    
    //to string
    @Override
    public String toString() {
        return this.player.toString();
    }



}
