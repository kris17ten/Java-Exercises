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
public class Card {
    private final CardType cardType;
    private final Rank rank;
    private final Suit suit;
    private State state;
    
    //constructor
    public Card(CardType cardType, Rank rank, Suit suit, State state) {
        this.cardType = cardType;
        this.rank = rank;
        this.suit = suit;
        this.state = state;
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public CardType getCardType() {
        return cardType;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public int getNumericValue() {
        return this.suit.getNumericValue() + this.rank.getNumericValue();
    }

    public int getRankAsNumber() {
        return this.rank.getNumericValue();
    }
    
    @Override
    public String toString() {
        // If card is FACE_DOWN, hide...
        if (this.state == State.FACE_DOWN) {
            return "**-***";
        }

        // If it is a joker, print only cardType...
        return (this.cardType == CardType.JOKER)
                ? this.cardType.toString()
                // otherwise, print the card suit and rank
                : (this.suit.toString() + "-" + this.rank.toString());
    }
}
