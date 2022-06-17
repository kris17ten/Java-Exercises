/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

import java.util.*;

/**
 *
 * @author Kristen
 */
public class Pack {
    
    private final List<Card> pack = new ArrayList<>();
    
    //shuffle cards
    public void shuffle() {
        
        this.pack.clear();
        
        //add cards to pack
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.FIVE, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SIX, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.CLUBS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.CLUBS, State.FACE_DOWN));

        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.FIVE, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SIX, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.DIAMONDS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.DIAMONDS, State.FACE_DOWN));

        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.FIVE, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SIX, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.HEARTS, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.HEARTS, State.FACE_DOWN));

        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.FIVE, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SIX, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.SEVEN, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.EIGHT, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.NINE, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.TEN, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.JACK, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.QUEEN, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.KING, Suit.SPADES, State.FACE_DOWN));
        this.pack.add(new Card(CardType.NORMAL_CARD, Rank.ACE, Suit.SPADES, State.FACE_DOWN));

        this.pack.add(new Card(CardType.JOKER, Rank.NOT_RELEVANT, Suit.NOT_RELEVANT, State.FACE_DOWN));
        
        //shuffle
        Collections.shuffle(this.pack);
    }
    
    //deal cards to square
    public List<Card> getCardsForSquare() {
        return this.pack.subList(0, 25);
    }
    
    //deal cards to player1
    public List<Card> getCardsForPlayerOne() {
        return this.pack.subList(25, 33);
    }
    
    //deal cards to player2
    public List<Card> getCardsForPlayerTwo() {
        return this.pack.subList(33, 41);
    }
}
